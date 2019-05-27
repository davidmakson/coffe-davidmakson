import Vue from "vue";
import Router from "vue-router";
import PlatosList from "./components/PlatosList.vue";
import Pedido from "./components/Pedido.vue";
import PedidoDetails from "./components/PedidoDetails.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "platosList",
      alias: "/platosList",
      component: PlatosList
    },
    {
      path: "/pedido",
      name: "pedido",
      component: Pedido
    },
    {
      path: "/pedido/status",
      name: "pedido-details",
      component: PedidoDetails
    }
  ]
});