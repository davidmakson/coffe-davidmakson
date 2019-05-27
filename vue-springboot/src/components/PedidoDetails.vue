<template>
  <div class="form-group" style="margin-left: 389px">
    <h4>Pedido</h4>
    <div>
      <label>Nombre: </label> {{this.pedido.nombreUsuario}}
    </div>
    <div>
      <label>Emision del Pedido: </label> {{this.pedido.dataEmissao}}
    </div>
    <div>
      <label>Status: </label> {{this.pedido.status}}
    </div>
  
    <span v-on:click="updateActive('PAGO')" class="button is-small btn-primary">
      PAGAR
    </span>
    <span  v-on:click="updateActive('CANCELADO')" class="button is-small btn-danger" >
      CANCELAR
    </span>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "pedido-details",

  data() {
    return {
      pedido: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    getPedidoByUsuario() {
      http
        .get("/pedido/" + this.nombreUsuario)
        .then(response => {
          this.pedido = response.data;
        })
        .catch(e => {
          console.log(e);
        });
      }
    /* eslint-enable no-console */
    },
    updateStatus(statusAtualizado) {
      var data = {
        nombreUsuario: this.pedido.nombreUsuario,
        dataEmissao: this.pedido.dataEmissao,
        status: this.pedido.status
      };

      http
        .put("/pedido/" + statusAtualizado, data)
        .then(response => {
          this.pedido.status = response.data.status;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

  },
  mounted() {
    this.pedido.nombreUsuario = localStorage.getItem('nombreUsuario');
    this.getPedidoByUsuario();
  }
};
</script>