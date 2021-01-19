<template>
  <div>
    <Load v-if="load"></Load>
    <ResponseDetail v-if="detalle" @cerrarAviso="cerrarAviso" @generarPdf="generarPdf"></ResponseDetail>
    <Mostrador v-if="mostrador" @cerrarAviso="cerrarMostrador"></Mostrador>
    <div class="container p-3">
      <form action>
        <div class="row">
          <div class="col-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <span>Cabecera</span>
              </div>
              <div class="panel-body">
                <div class="row">
                  <div class="col-2 borderRight">
                    <div class="form-group" v-if="multiPunto">
                      <label for="tienda">Tienda</label>
                      <input
                        type="text"
                        name="tienda"
                        id="tienda"
                        class="form-control input-imago"
                        v-model="store"
                        focus
                        @blur="validarBlur('tienda')"
                      />
                    </div>
                    <div class="form-group" v-else>
                      <label for="tienda">Tienda</label>
                      <select
                          name="tienda"
                          id="tienda"
                          class="form-control input-imago"
                          v-model="store"
                          @focus="validarMain()"
                        >
                          <option :value="store">{{store}}</option>
                          <option
                            v-for="branch in stores"
                            :value="branch"
                          >{{branch}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                      <label for="fecha">fecha</label>
                      <the-mask
                        :mask="['##/##/####']"
                        placeholder="dd/mm/aaaa"
                        name="fecha"
                        id="fecha"
                        v-model="fecha"
                        @blur="validarBlur('fecha')"
                        class="form-control input-imago"
                      />
                    </div>
                  </div>
                  <div class="col-7 borderRight">
                    <div class="row">
                      <div class="form-group col-4">
                        <label for="caja">Caja</label>
                        <input
                          type="text"
                          maxlength="2"
                          name="caja"
                          id="caja"
                          class="form-control input-imago"
                          @focus="validarMain()"
                          v-model="caja"
                          @change="activar"
                        />
                      </div>
                      <div class="form-group col-4">
                        <label for="medio">Medio de pago</label>
                        <select
                          name="medio"
                          id="medio"
                          class="form-control input-imago"
                          v-model="medio"
                          @focus="validarMain()"
                        >
                          <option value>-</option>
                          <option
                            v-for="medio in medios"
                            :value="medio.Tender_id"
                          >{{medio.Tender_Description}}</option>
                        </select>
                      </div>
                      <div class="form-group col-4">
                        <label for="dniTarjeta">DNI Tarjeta</label>
                        <input
                          type="text"
                          name="dniTarjeta"
                          id="dniTarjeta"
                          class="form-control input-imago"
                          @focus="validarMain()"
                        />
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-group col-4">
                        <label for="transaccion">Transacción</label>
                        <input
                          type="text"
                          maxlength="6"
                          name="transaccion"
                          id="transaccion"
                          v-model="transaccion"
                          class="form-control input-imago"
                          @focus="validarMain()"
                          :disabled="validarCaja"
                        />
                      </div>
                      <div class="form-group col-4">
                        <label for="ean">EAN</label>
                        <input
                          type="text"
                          name="ean"
                          id="ean"
                          class="form-control input-imago"
                          @focus="validarMain()"
                        />
                      </div>
                      <div class="form-group col-4">
                        <label for="dniCarrefour">DNI Mi Carrefour</label>
                        <input
                          type="text"
                          name="dniCarrefour"
                          id="dniCarrefour"
                          class="form-control input-imago"
                          @focus="validarMain()"
                        />
                      </div>
                    </div>
                  </div>
                  <div class="col-3 text-center" :class="alertaError ? 'mt-1' : 'mt-5'">
                    <div v-if="alertaError" class="row">
                      <div class="col-12">
                        <div class="alert alert-danger" role="alert">{{mensajeError}}</div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-6">
                        <button
                          type="button"
                          class="btn btn-primary"
                          v-on:click="buscar()"
                        >
                          <span class="ui-button-text">Buscar</span>
                        </button>
                      </div>
                      <div class="col-6">
                        <button
                          type="button"
                          class="btn btn-default"
                          v-on:click="limpiar()"
                        >
                          <span class="ui-button-text">Limpiar</span>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </form>
      <responseQuery v-if="response" @mostrarDetalle="mostrarDetalle" @generarPdf="generarPdf" ref="responseQuery" :transacciones="armarPagination()"/>
      <Pagination v-if="responsePagination" ref="paginationS" :rows="filas" :countPage="cantidadPagina"/>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import ResponseQuery from "../component/ResponseQuery";
import ResponseDetail from "../component/ResponseDetail";
import Load from "../component/Load";
import Mostrador from "../component/Mostrador";
import Connection from "../service/Connection";
import Consulta from "../model/Consulta";
import Transaccion from "../model/Transaccion";
import MediosDePago from "../model/MediosDePago";
import Cabecera from "../model/Cabecera";
import Detalle from "../model/Detalle";
import Pagos from "../model/Pagos";
import Documento from "../model/Documento";
import { TheMask } from 'vue-the-mask';
import Pagination from '../component/util/Pagination';
import { getAllUrlParams } from '../component/util/utils';

export default {
  name: "formQuery",
  components: {
    ResponseDetail,
    ResponseQuery,
    Connection,
    Consulta,
    Transaccion,
    MediosDePago,
    Cabecera,
    Detalle,
    Pagos,
    Load,
    Documento,
    Mostrador,
    TheMask,
    Pagination
  },
  data: function () {
    return {
      detalle: false,
      response: false,
      responsePagination: false,
      mostrador: false,
//      conexion: Connection.instanciar(),
      consulta: Consulta.instanciar(),
      transacciones: Transaccion.instanciar(),
      mediosDePago: MediosDePago.instanciar(),
      cabecera: Cabecera.instanciar(),
      detalles: Detalle.instanciar(),
      pagos: Pagos.instanciar(),
      documento: Documento.instanciar(),
      medios: null,
      tiendaBool: true,
      fechaBool: true,
      alertaError: false,
      load: false,
      inputs: {
        caja: "caja",
        dniTarjeta: "dniTarjeta",
        transaccion: "transaccion",
        ean: "ean",
        dniCarrefour: "dniCarrefour",
      },
      medio: "",
      mensajeError: "",
      fecha: "",
      repositorio: null,
      filas: 1,
      cantidadPagina: 2,
      validarCaja: true,
      store: 0,
      stores: [],
      multiPunto: false
    };
  },
  beforeCreate() {
    this.$service = Connection.instanciar();
  },
  created() {
    if (!this.mediosDePago.getBandera()){
      this.load = true;
      this.setTokenHeader();
      this.traerTienda();
      this.traerMediosDePago();
    } 
  },
  methods: {
    mostrarDetalle: function (id, esSimple) {
      this.load = true;
      this.alertaError = false;
      this.$service
        .conectar("GET", apiHost + "detallar", { id_transaccion: id })
        .then((valor) => {
          this.cabecera.setCabecera(valor.resultado.Head);
          this.detalles.setDetalle(valor.resultado.detail);
          this.pagos.setPagos(valor.resultado.payment);
          if(esSimple){
            this.generarPdf(false);
          }else{
            this.detalle = true;
            this.load = false;
          }
        })
        .catch((err) => {
          console.log(err);
          console.log("Error encontrado: " + err.mensaje);
          this.mensajeError = err.mensaje;
          this.alertaError = true;
          this.load = false;
        });
    },
    generarPdf: function (esSimple, id) {
      this.load = true;
      if(esSimple){
        this.mostrarDetalle(id, true)
      } else {
        this.$service
        .conectar("POST", apiHost + "getPdf",{
          header: this.cabecera.getCabecera(),
          detail: this.detalles.getDetalle(),
          payment: this.pagos.getPagos()
        })
        .then((valor) => {
          this.load = false;
          var down = document.createElement("a"); //Create <a>
          down.href = "data:image/pdf;base64," + valor.resultado; //Image Base64 Goes here
          down.download = "trans_" + this.cabecera.getCabecera()[0].SaleTrx_id + ".pdf"; //File name Here
          down.click();
        })
        .catch((err) => {
          console.log(err);
          console.log("(" + err.error + ") " + err.mensaje);
          this.load = false;
          alert("Ha ocurrido un error inesperado");
        });
      }
      
    },
    buscar: function () {
      this.load = true;
      let fechaNew = this.hacerFecha();
      let cajaNew = '';
      let transactionNew = '';

      if(document.getElementById("caja").value !== '') {
        cajaNew = this.hacerCaja();
        if(document.getElementById("transaccion").value !== '') {
          transactionNew = this.hacerTransferencia(cajaNew);
        }
      }

      if (this.validar()) {
        this.consulta.setConsulta(
          document.getElementById("dniCarrefour").value,
          fechaNew,
          cajaNew,//document.getElementById("caja").value,
          document.getElementById("dniTarjeta").value,
          (parseInt(this.store) + 10000) + "",
          transactionNew,//document.getElementById("transaccion").value,
          document.getElementById("ean").value,
          this.medio
        );
        this.consulta.getTienda();
        this.response = true;
        this.responsePagination = true;
        this.$service
          .conectar("POST", apiHost + "consultar", this.consulta)
          .then((val) => {
            this.transacciones.setTrans(val.resultado, true);
            this.repositorio = val.resultado;
            this.filas = this.repositorio.length;
            try {
              this.$refs.responseQuery.mostrarInfo();
              this.$refs.paginationS.setPage(1);
            } catch (error) {
              console.log("Mostrar info no se encontro");
              this.responsePagination = false;
            }
            this.load = false;
          })
          .catch((err) => {
            console.log(err);
            console.log("Error encontrado: " + err.mensaje);
            this.$refs.responseQuery.mostrarError(err.mensaje);
            this.load = false;
            this.responsePagination = false;
          });
      } else {
        this.alertaError = true;
        this.mensajeError = "¡Se necesita más información para realizar la búsqueda!";
        this.load = false;
        this.responsePagination = false;
      }
    },
    traerMediosDePago() {
      this.alertaError = false;
      this.$service
        .conectar("POST", apiHost + "mediosPagos", null)
        .then((valor) => {
          this.medios = valor.resultado.ResultRows;
          this.load = false;
        })
        .catch((err) => {
          console.log(err);
          console.log("Error encontrado: " + err.mensaje)
          this.alertaError = true;
          this.mensajeError = err.mensaje;
          this.load = false;
        });
    },
    traerTienda(){
      this.$service
        .conectar("GET", `${apiHost}getStore`,null)
        .then((valor) => {
          console.log(valor);
          this.store = valor.resultado.main;
          this.multiPunto = valor.resultado.multiple;
          this.stores = valor.resultado.secondary;
          console.log("Store success");
        })
        .catch((err) =>{
          console.log(err);
          console.log("Error encontrado: " + err.mensaje)
          this.mensajeError = this.alertaError ? 
            null : ()=>{ 
              this.alertaError = true; 
              this.mensajeError = err.mensaje;
            }


        });
    },
    setTokenHeader() {
      let urlParams = getAllUrlParams(window.location);

      console.log(urlParams);

      this.$service.set({
          token: urlParams.key
      });
    },
    validar() {
      return this.validarMain();
    },
    validarMain() {
      this.validarBlur("tienda");
      this.validarBlur("fecha");
      return (
        document.querySelector("#tienda").value != "" &&
        document.querySelector("#fecha").value != ""
      );
    },
    validarBlur(e) {
      let elemento = document.querySelector("#" + e);
      if (elemento.value == "") {
        elemento.classList.add("input-error-imago");
      } else {
        elemento.classList.remove("input-error-imago");
      }
      this.alertaError = false;
    },
    limpiar: function () {
      for (let input in this.inputs) {
        document.getElementById(this.inputs[input]).value = "";
      }
      document.querySelector("#tienda").value = "";
      this.fecha = "";
      this.medio = "";
      this.transacciones.setTrans(null, false);
      this.$refs.responseQuery.mostrarError("No hay información para mostrar");
      this.alertaError = false;
      this.responsePagination = false;
    },
    hacerFecha(){
      let val = fecha.value;

      return val.charAt(6) + val.charAt(7) + val.charAt(8) + val.charAt(9) + "-" + // año
      val.charAt(3) + val.charAt(4) + "-" + // mes
      val.charAt(0) + val.charAt(1) // día;
    },
    hacerCaja(){
      let val = caja.value;
      return val.padStart(2,'00');
    },
    hacerTransferencia: function(cajaNew){
      let trans = transaccion.value;

      return cajaNew + trans.padStart(6,'000000');
    },
    cerrarAviso: function () {
      this.detalle = false;
    },
    cerrarMostrador(){
      this.mostrador = false;
    },
    armarPagination(){
      console.log("Aramar pagination");
      try {
        let change = this.$refs.paginationS.changePage();
        let repo = this.repositorio.slice(change.start,change.end);
        this.$refs.responseQuery.vaciarSeleccion();
        return repo;
      } catch (error) {
        console.log("El armar pagination no está disponible");
        console.log(error);
      }
    },
    activar: function() {
      if(document.getElementById("caja").value === '') {
        document.getElementById("transaccion").value = '';
      }
        this.validarCaja = document.getElementById("caja").value === '';
    }
  }
};
</script>
<style>
.borderRight {
  border-right: solid darkorange 1px;
}
</style>