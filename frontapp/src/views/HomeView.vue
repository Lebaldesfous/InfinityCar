<template>
  <div class="home">
    <h1 class="page-heading">Some of our cars...</h1>
    <div class="container-fluid d-flex justify-content-center">
      <div class="row mt-5 justify-content-center">
        <div class="col-md-4"  v-for="(car, index) in cars" :key="index">
          <ProductItem :car="car"></ProductItem>
        </div>
        
      </div>
    </div>
  </div>
</template>

<script>
import ProductItem from "../components/ProductItem.vue"
import api from '../api'

export default {
  name: 'HomeView',
  components: {
    ProductItem
  },
  data() {
    return {
      cars: [],
    };
  },
  mounted() {
    this.fetchCars();
  },
  methods: {
    async fetchCars() {
      try {
        const response = await api.get(
          "/cars"
        );
        this.cars = response.data
      } catch (error) {
        console.log(error);
      }
    },
  }
}
</script>

<style>
.home {
  margin-top: 5%;
}

.col-md-4 {
  width: 250px !important;
  margin: 1%;
}

.row {
  width: 900px!important;
}
</style>

