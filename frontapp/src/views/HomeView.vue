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

export default {
  name: 'HomeView',
  components: {
    ProductItem
  },
  data() {
    return {
      cars: [
        {
          name: "RS3",
          image: 'https://i.imgur.com/7AfKzqe.jpeg',
          price: '72,000',
          fuel_efficiency: '8.9',
          engine: '2.5L 5 Cylinders',
          horsepower: '400 hp',
        },
        {
          name: "C63",
          image: 'https://i.imgur.com/NmEKx6z.jpeg',
          price: '115,000',
          fuel_efficiency: '6.9',
          engine: '2.0L 4 Cylinders',
          horsepower: '476 hp',
        },
        {
          name: "Golf 7R",
          image: 'https://i.imgur.com/BFIbvcI.jpeg',
          price: '40,700',
          fuel_efficiency: '8.7',
          engine: '2.0L TSI',
          horsepower: '320 hp',
        },
        {
          name: "BMW M3",
          image: 'https://i.imgur.com/FUrb8Yx.jpeg',
          price: '109,950',
          fuel_efficiency: '12',
          engine: '2.5L Bi-Turbo',
          horsepower: '530 hp',
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

.col-md-4 {
  width: 250px !important;
  margin: 1%;
}

.row {
  width: 900px!important;

}
</style>

