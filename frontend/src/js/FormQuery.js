import Vue from 'vue';
import Index from '../Index.vue';
import FormQuery from '../view/FormQuery.vue';
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';

Vue.use(VueResource);
Vue.use(VueRouter);

const router = new VueRouter({
  routes: [
    //{ path: "/", redirect: "/form"},
    { path: "/", component: FormQuery}
  ]
});

new Vue({
  el: "#app",
  router: router,
  render: h => h(Index)
});
