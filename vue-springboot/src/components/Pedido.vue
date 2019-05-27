<template>

  <div class="submitform">
    <div v-if="!pedidoRealizado">
      <div class="form-group">
            <label for="name">Nombre</label>
            <input type="text" class="form-control" id="nombreUsuario" required v-model="pedido.nombreUsuario" name="nombreUsuario">

            <label for="primeirosPlatos">Primeiro Plato</label>
            <select class="form-control" v-model="selected1">
              <option v-for="option in primeirosPlatos" v-bind:value="option.id" :key="option.id">
                {{ option.nome }}
              </option>
            </select>
            <input type="number" class="form-control" id="qtd1" required v-model="qtd1" name="qtd1">

            <label for="segundosPlatos">Segundo Plato</label>
            <select class="form-control" v-model="selected2">
              <option v-for="option in segundosPlatos" v-bind:value="option.id" :key="option.id">
                {{ option.nome }}
              </option>
            </select>
            <input type="number" class="form-control" id="qtd2" required v-model="qtd2" name="qtd2">

            <label for="postres">Postre</label>
            <select class="form-control" v-model="selected3">
              <option v-for="option in postres" v-bind:value="option.id" :key="option.id">
                {{ option.nome }}
              </option>
            </select>
            <input type="number" class="form-control" id="qtd3" required v-model="qtd3" name="qtd3">
            <br>
            <br>
            <button v-on:click="savePedido" class="btn btn-success">Submit</button>
            
      </div>
    </div>
  <div v-else>
    <br/>
      <div class="form-group">
        <p>Aguarde el pedido...</p>
        <button v-on:click="novoPedido" class="btn btn-success">Hacer nuevo pedido!</button>
      </div>
  </div>
</div>
</template>

<script>
import http from "../http-common";

export default {
  data() {
    return {
      pedido: {
        nombreUsuario: '',
        dataEmissao: new Date(),
        dataEntrega: new Date(),
        status: ''
      },
      primeirosPlatos: [],
      segundosPlatos: [],
      postres: [],
      selected1:'',
      selected2:'',
      selected3:'',
      qtd1:'',
      qtd2:'',
      qtd3:'',
      pedidoRealizado :false
    };
  },
  methods: {
    novoPedido(){
      this.pedidoRealizado = false;
      this.$router.push('/');
    },
    savePedido() {
      var data = {
                  nombreUsuario: this.pedido.nombreUsuario,
                  dataEmissao: this.pedido.dataEmissao,
                  dataEntrega: this.pedido.dataEntrega,
                  platoPedido: [
                                  {
                                    plato: {
                                      id: this.selected1
                                    },
                                    quantidade: this.qtd1
                                  },
                                  {
                                    plato: {
                                      id: this.selected2
                                    },
                                    quantidade: this.qtd2
                                  },
                                  {
                                    plato: {
                                      id: this.selected3
                                    },
                                    quantidade: this.qtd3
                                  }
                                ],
                  status: this.status
                };
      http
        .post("/pedido/add", data)
        .then(response => {
          localStorage.setItem('nombreUsuario',this.response.data.nombreUsuario);
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
        this.pedidoRealizado = true;
        this.$router.push('/pedido/status')
    },
    getAllPostresPlatos(){
      http
        .get("/platos/"+ "POSTRE")
        .then(response => {
          this.postres = response.data;
        })
    },
    getAllSegundosPlatos(){
      http
        .get("/platos/"+ "SEGUNDO")
        .then(response => {
          this.segundosPlatos = response.data;
        })
    },
    getAllPrimeirosPlatos(){
      http
        .get("/platos/"+ "PRIMEIRO")
        .then(response => {
          this.primeirosPlatos = response.data;
        })
    }
  },
  mounted() {
    this.pedidoRealizado = false;
    this.getAllPrimeirosPlatos();
    this.getAllSegundosPlatos();
    this.getAllPostresPlatos();
  }
};

</script>

<style>
  .list {
    text-align: left;
    max-width: 450px;
    margin: auto;
  }

  .submitform {
    max-width: 300px;
    margin: auto;
  }
</style>
