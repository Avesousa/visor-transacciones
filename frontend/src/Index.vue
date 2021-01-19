<template>

  <div class="container-fluid sinPadding">
    <router-view></router-view>
  </div>
  
</template>

<script>

export default {
  name: 'index',
  data () {
  }
}
</script>

<style>
@import url("css/bootstrap.css");
@import url('css/principal.css');
@import url('css/imago.css');
.sinPadding{
  padding: 0;
}

</style>
