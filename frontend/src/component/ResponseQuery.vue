<template>
<div>
    <div class="row mt-1">
      <div class="col-12">
        <button class="btn btn-primary btn-detalle" @click="mostrarDetalle()" :disabled="!activarBoton">Ver Detalle</button>
        <button class="btn btn-primary btn-detalle" @click="generarPdf()" :disabled="!activarBoton">Generar PDF</button>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <table class="table table-responsive table-borde">
          <thead class="panel-heading">
            <tr>
              <th></th>
              <th class="table-col-w-l"><span>Hora</span></th>
              <th class="table-col-w-m"><span>Caja</span></th>
              <th class="table-col-w-xl"><span>Transacción</span></th>
              <th class="table-col-w-xl"><span>Tipo de Transaccion</span></th>
              <th class="table-col-w-l"><span>Importe Total</span></th>
              <th class="table-col-w-l"><span>DNI de Medio de Pago</span></th>
              <th class="table-col-w-l"><span>DNI Mi Carrefour</span></th>
            </tr>
          </thead>
          <tbody v-if="info" class="table-main-imago">
              <tr v-for="(trans,index) in transacciones" v-on:click="seleccionar(trans.id,(index+1))" :class="(index+1) == rowSelected ? 'table-row-selected' : ''">
                  <td>
                    <input type="radio" name="seleccion" :id="index+1" :value="index+1" v-bind:checked="(index+1) == rowSelected">
                  </td>
                  <td>{{trans.horaOperacion}}</td>
                  <td>{{trans.codigoCaja}}</td>
                  <td>{{trans.codigoTransaccion}}</td>
                  <td>{{trans.descripcionTipoTransaccion}}</td>
                  <td>{{crearMonto(trans.total)}}</td>
                  <td>{{trans.documentoMedioPago}}</td>
                  <td>{{trans.documentoCarrefour}}</td>
              </tr>
          </tbody>
        </table>
        <div v-if="!info" class="row p-left-15px">
          <p>{{mensaje}}</p>
        </div>
      </div>
    </div>
</div>
</template>
<script>

import Transaccion from '../model/Transaccion';
import Consulta from '../model/Consulta';

export default {
    name: 'responseQuery',
    components:{
      Transaccion,
      Consulta
    },
    props:{
      transacciones:{
        type: Array
      }
    },
    data(){
      return{
        transaccion: Transaccion.instanciar(),
        consulta: Consulta.instanciar(),
        id: 0,
        rowSelected: 0,
        activarBoton: false,
        info: true,
        seleccion: "",
        mensaje: "",
      }
    },
    methods:{
      mostrarDetalle(){
        console.log("ID a consultar: " + this.id);
        this.$emit("mostrarDetalle",this.id,false);
      },
      generarPdf(){
        this.$emit("generarPdf", true, this.id);
      },
      seleccionar(id,row){
        this.id = this.id == id ? 0 : id;
        this.activarBoton = this.rowSelected == row ? false : true;
        this.rowSelected = this.rowSelected == row ? 0 : row;

        console.log("ID seleccionado: " + this.id + " / fila Seleccionada: " + this.rowSelected);
      },
      mostrarInfo(){
        this.info = true;
      },
      mostrarError(texto){
        this.info = false;
        this.mensaje = texto;
        this.activarBoton = false;
      },
      vaciarSeleccion(){
        this.id = 0;
        this.activarBoton = false;
        this.rowSelected = 0;
      },
      crearMonto(num){
        let valor = num.toString().split(".");
        let entero = this.crearMiles(valor[0]);
        let decimal = valor.length > 1 ? ( valor[1].length > 1 ? valor[1] : (valor[1] + "0") ) : "00";
        let final = entero + "," + decimal;
        console.log(final);
        return final;
      },
      crearMiles(num){
        let valor = (num.toString().split('')).reverse();
        let respuesta = "";
        for(let i = 0; i < valor.length; i++){
          respuesta = i > 0 ? (((i/3).toString().split(".")[1]>0) ? valor[i] : ( valor[i] + ".") ) + respuesta : valor[i] + respuesta;
        }
        return respuesta;
      }

    }
}
</script>
<style>

</style>