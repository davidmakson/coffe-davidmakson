<template>
	<div class="list row">
		<div class="row food-menu-list" id="MixItUpD563A8">

            <ul class="search-result">
              <li v-for="(plato, index) in platos" :key="index">
                <div class="mix col-md-6 col-lg-6 col-sm-12 col-xs-12 single-menu breakfast" data-bound="" style="display: inline-block;">
                    <div class="single-menu-details">
                      <div class="food-menu-img"><img src="http://quomodosoft.com/html/dawat/demo/img/menu/menu_3.jpg" alt=""></div>
                        <div class="food-menu-details">
                            <h3>{{plato.nome}} <span class="menu-price">{{plato.tipoPlato}}</span></h3>
                            <p class="menu-speacification"><span>- {{plato.nome}}</span> <span>- {{plato.tipoPlato}}</span> <span>- {{plato.tipoPlato}}</span> </p>
                            <p class="menu-speacification"><span>- {{plato.nome}}</span> <span>- {{plato.tipoPlato}}</span> <span>- {{plato.tipoPlato}}</span> </p>
                            <p class="menu-speacification"><span>- {{plato.nome}}</span> <span>- {{plato.tipoPlato}}</span> <span>- {{plato.tipoPlato}}</span> </p>
                        </div>
                    </div>
                </div>
                <div class="mix col-md-6 col-lg-6 col-sm-12 col-xs-12 single-menu breakfast" data-bound="" style="display: inline-block;">
                    <div class="single-menu-details">
                      <div class="food-menu-img"><img src="http://quomodosoft.com/html/dawat/demo/img/menu/menu_3.jpg" alt=""></div>
                        <div class="food-menu-details">
                            <h3>{{plato.nome}} <span class="menu-price">{{plato.tipoPlato}}</span></h3>
                            <p class="menu-speacification"><span>- {{plato.nome}}</span> <span>- {{plato.tipoPlato}}</span> <span>- {{plato.tipoPlato}}</span> </p>
                            <p class="menu-speacification"><span>- {{plato.nome}}</span> <span>- {{plato.tipoPlato}}</span> <span>- {{plato.tipoPlato}}</span> </p>
                            <p class="menu-speacification"><span>- {{plato.nome}}</span> <span>- {{plato.tipoPlato}}</span> <span>- {{plato.tipoPlato}}</span> </p>
                        </div>
                    </div>
                </div>
              </li>
            </ul>
			
		</div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "platosList",
  data() {
    return {
      platos: []
    };
  },
  methods: {
    getAllPlatos() {
      http
        .get("/platos")
        .then(response => {
          this.platos = response.data; 
              /* eslint-enable no-console */
          console.log(response.data);
              /* eslint-enable no-console */
        })
    },
    refreshList() {
      this.getAllPlatos();
    }

  },
  mounted() {
    this.getAllPlatos();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
