<template>
  <div>
    <div class="bg_load justify-content-center">
      <div class="cuerpo_load">
        <div class="card tarjeta">
          <div class="card-header tarjeta-header">
            <p class="tarjeta-parrafo">Cargando</p>
          </div>
          <div class="card-body tarjeta-body">
            <img src="../assets/load.gif" alt="cargando">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "load",
  components:{
  },
  data: function() {
    return {
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

  .tarjeta{
    width: 22%;
    margin: 0 auto;
    box-shadow: 1px 1px 15px;
  }

  .tarjeta-header{
    background-color: #fff;
  }

  .tarjeta-body{
    padding: 0px;
  }

  .tarjeta-body img{
    width: 30%;
  }

  .tarjeta-parrafo{
    margin: 0px;
    font-size: 18px;
  }

</style>