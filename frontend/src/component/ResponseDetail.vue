<template>
  <div>
    <div class="bg_alert justify-content-center">
      <div class="titulo_alerta">
        <div class="row">
          <div class="col-10 ubicacion-inicial">
            <span class="izq">{{titulo}}</span>
          </div>
          <div class="col-2">
            <a @click="cerrarAviso()">x</a>
          </div>
        </div>
      </div>
      <div class="cuerpo_alerta">
        <form>
          <!-- Parte superior -->
          <div class="row">
            <div class="col-12">
              <div class="panel">
                <div class="panel-body">
                  <div class="row">
                    <div class="col-12">
                      <div class="row">
                        <div class="form-group col-3">
                          <label for="fecha">fecha</label>
                          <input type="date" name="fecha" id="fecha" class="form-control" :value="cabecera.getCabecera()[0].CDay_id" disabled/>
                        </div>
                        <div class="form-group col-2">
                          <label for="tienda">Tienda</label>
                          <input type="text" name="tienda" id="tienda" class="form-control" :value="crearTienda(consulta.getTienda())" disabled/>
                        </div>
                        <div class="form-group col-2">
                          <label for="caja">Caja</label>
                          <input type="text" name="caja" id="caja" class="form-control" :value="cabecera.getCabecera()[0].Checkout_id" disabled/>
                        </div>
                        <div class="form-group col-3">
                          <label for="transaccion">Transacción</label>
                          <input type="text" name="transaccion" id="transaccion" class="form-control" :value="crearTransaccion(cabecera.getCabecera()[0].PosEvent_id)" disabled
                          />
                        </div>
                        <!-- <div class="form-group col-2">
                          <label for="ticket">Número ticket</label>
                          <input type="text" name="ticket" id="ticket" class="form-control" :value="cabecera.getCabecera()[0].ReceiptNbr_id" disabled/>
                        </div> -->
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Cuerpo de información del detalle-->
          <div class="row">
            <div class="col-12">
              <div class="panel">
                <div class="panel-body">
                  <div class="row">
                    <div class="col-12">
                      <div class="div_info_detalle">
                        <table class="table table-responsive panel">
                          <thead class="panel-heading">
                            <tr>
                              <th>Tipo</th>
                              <th>EAN</th>
                              <th>Descripción</th>
                              <th>Cantidad</th>
                              <th>SubTotal</th>
                            </tr>
                          </thead>
                          <tbody v-for="val in detalles.getDetalle()" class="table-main-imago">
                            <tr>
                              <td class="aling_start">{{val.ItemType_description}}</td>
                              <td>{{val.ProductBarCode_id}}</td>
                              <td class="aling_start">{{val.product_description}}</td>
                              <td>{{crearMonto(val.SaleQty)}}</td>
                              <td class="aling_end">{{crearMonto(val.TotAmount)}}</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Pie de información del detalle-->
          <div class="row">
            <div class="col-12">
              <div class="panel">
                <div class="panel-body">
                  <div class="row">
                    <!-- Información detallada de los medios de pagos-->
                    <div class="col-8">
                      <div class="div_info_pago">
                        <table class="table table-responsive panel">
                          <thead class="panel-heading">
                            <tr>
                              <th>Tipo Medio de pago</th>
                              <th>Medio de pago</th>
                              <th>Importe</th>
                            </tr>
                          </thead>
                          <tbody v-for="val in pagos.getPagos()" class="table-main-imago">
                            <tr>
                              <td>{{val.Tender_Description}}</td>
                              <td>{{val.SubTender_Description}}</td>
                              <td class="aling_end">{{crearMonto(val.F_TenderAmount)}}</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                    <!-- Información resumida del monto de la transacción-->
                    <div class="col-4">
                      <div class="row">
                        <div class="form-group col-12">
                          <label for="importe-total">Importe Total</label>
                          <input type="text" name="importe-total" id="importe-total" class="form-control aling_end" :value="crearMonto(cabecera.getCabecera()[0].total_amount)" disabled/>
                        </div>
                      </div>
                      <div class="row">
                        <div class="form-group col-12">
                          <input class="btn btn-alert btn-primary" type="button" value="Generar PDF" @click="generarPdf()" />
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import Cabecera from '../model/Cabecera';
import Detalle from '../model/Detalle';
import Pagos from '../model/Pagos';
import Consulta from '../model/Consulta';

export default {
  name: "responseDetail",
  components:{
    Cabecera,
    Detalle,
    Pagos,
    Consulta
  },
  data: function() {
    return {
      detalle: true,
      titulo: "Detalle del comprobante",
      detalles: Detalle.instanciar(),
      cabecera: Cabecera.instanciar(),
      pagos: Pagos.instanciar(),
      consulta: Consulta.instanciar(),
      tienda: null,
      detalles_def: null,
      cabecera_def: null,
      pagos_def: null
    };
  },
  methods: {
    cerrarAviso: function() {
      this.$emit("cerrarAviso");
    },
    generarPdf(){
      this.$emit("generarPdf", false);
    },
    crearMonto(num){
      let valor = num.toString().split(".");
      let entero = this.crearMiles(valor[0]);
      let decimal = valor.length > 1 ? ( valor[1].length > 1 ? valor[1] : (valor[1] + "0") ) : "00";
      let final = entero + "," + decimal;
      console.log(final);
      return final;
    },
    // crearMontoPagos(num, cashReturn){
    //   let total = num - cashReturn;
    //   let valor = total.toString().split(".");
    //   let entero = this.crearMiles(valor[0]);
    //   let decimal = valor.length > 1 ? ( valor[1].length > 1 ? valor[1] : (valor[1] + "0") ) : "00";
    //   let final = entero + "," + decimal;
    //   console.log(final);
    //   return final;
    // },
    crearMiles(num){
      let valor = (num.toString().split('')).reverse();
      let respuesta = "";
      for(let i = 0; i < valor.length; i++){
        respuesta = i > 0 ? (((i/3).toString().split(".")[1]>0) ? valor[i] : ( valor[i] + ".") ) + respuesta : valor[i] + respuesta;
      }
      return respuesta;
    },
    crearTransaccion(trans){
      console.log('console: ', trans);
      let respuesta = trans.toString().substr(4,8);
      return respuesta;
    },
    crearTienda(tienda){
      console.log('console: ', tienda);
      let respuesta = tienda - 10000;
      return respuesta;
    }
  }
};
</script>

<style>

  .titulo_alerta .col-2 a{
    font-size: 13px;
    font-weight: bold;
    float: right;
    padding-right: 10%;
    cursor: pointer;
  }

  .aling_end{
    text-align: end;
  }

  .aling_start{
    text-align: start;
  }

</style>