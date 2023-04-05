<template>
  <div class="home">
    <h1 class="page-heading">Some of our products</h1>
    <ul id="products">
      <li>
        <ProductItem></ProductItem>
      </li>
    </ul>
  </div>
</template>

<script>
// @ is an alias to /src
import ProductItem from "../components/ProductItem.vue"

export default {
  name: 'HomeView',
  components: {
    ProductItem
  }
}
</script>

<style>
.home {
  margin-top: 5%;
}
</style>

