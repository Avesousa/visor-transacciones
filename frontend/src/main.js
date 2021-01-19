import Vue from 'vue'
import Index from './Index.vue'
import BootstrapVue from "bootstrap-vue"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"

Vue.use(BootstrapVue);

new Vue({
  el: '#web',
  render: h => h(Index)
})
