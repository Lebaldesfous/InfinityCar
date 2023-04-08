<template>
  <div class="home">
    <h1 class="page-heading">Some of our cars...</h1>
    <div class="container-fluid d-flex justify-content-center">
      <div class="row mt-5 justify-content-center">
        <div class="col-md-4" v-for="(car, index) in cars" :key="index">
          <ProductItem :car="car"></ProductItem>
        </div>
        <div v-if="cars.length % 3 == 1 || cars.length % 3 == 2" class="col-sm-4 mb-4"></div>
      </div>
    </div>
  </div>
</template>

<script>
import ProductItem from "../components/ProductItem.vue"

export default {
  name: 'HomeView',
  components: {
    ProductItem
  },
  data() {
    return {
      cars: [
        {
          image: 'https://imgur.com/edOjtEC.png',
          price: '22,495',
          fuel_efficiency: '8.5/7.1',
          engine_icon: 'https://imgur.com/iPtsG7I.png',
          engine: '1.4L MultiAir',
          engine_type: '16V I-4 Turbo',
          horsepower: '135 hp',
        },
        {
          image: 'https://imgur.com/edOjtEC.png',
          price: '22,495',
          fuel_efficiency: '8.5/7.1',
          engine_icon: 'https://imgur.com/iPtsG7I.png',
          engine: '1.4L MultiAir',
          engine_type: '16V I-4 Turbo',
          horsepower: '135 hp',
        },
        {
          image: 'https://imgur.com/edOjtEC.png',
          price: '22,495',
          fuel_efficiency: '8.5/7.1',
          engine_icon: 'https://imgur.com/iPtsG7I.png',
          engine: '1.4L MultiAir',
          engine_type: '16V I-4 Turbo',
          horsepower: '135 hp',
        },
        {
          image: 'https://imgur.com/edOjtEC.png',
          price: '22,495',
          fuel_efficiency: '8.5/7.1',
          engine_icon: 'https://imgur.com/iPtsG7I.png',
          engine: '1.4L MultiAir',
          engine_type: '16V I-4 Turbo',
          horsepower: '135 hp',
        }
      ]
    }
  }
}
</script>

<style>
.home {
  margin-top: 5%;
}
</style>

