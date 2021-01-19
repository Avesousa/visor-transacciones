<template>
  <div>
    <div class="bg_alert justify-content-center">
      <div class="bg_pdf_white">
        <div class="titulo_alerta titulo_pdf">
          <div class="row">
            <div class="col-10">
              <h3 class="izq">Documento</h3>
            </div>
            <div class="col-2">
              <h3 class="der">
                <a @click="cerrarAviso()">x</a>
              </h3>
            </div>
          </div>
        </div>
        <div class="cuerpo_pdf">
          <embed :src="documento.getDocumento()" width="100%" height="600" type="text/html" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Documento from "../model/Documento";

export default {
  name: "mostrador",
  components:{
    Documento
  },
  data: function() {
    return {
      documento: Documento.instanciar()
    };
  },
  methods: {
    cerrarAviso: function() {
      this.$emit("cerrarAviso");
    }
  }
};
</script>

<style>
</style>