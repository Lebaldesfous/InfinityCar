<template>
  <div class="home">
    <h1 class="page-heading">Some of our cars...</h1>
    
    <div class="d-flex justify-content-center">
      <form class="d-flex w-50 p-2" @submit.prevent="searchCar">
        <input class="form-control me-2" v-model="searchQuery" type="search" placeholder="Search" aria-label="Search">
      </form>
    </div>
    
    <div class="container-fluid d-flex justify-content-center">
      <div class="row mt-5 justify-content-center">
        <div class="col-md-4"  v-for="(car, index) in filteredCars" :key="index">
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
      searchQuery: ''
    };
  },
  mounted() {
    this.fetchCars();
  },
  computed: {
    filteredCars() {
      return this.cars.filter((car) => car.name.toLowerCase().includes(this.searchQuery.toLowerCase()))
    }
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
    searchCar(){
      //find car by name
      
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
