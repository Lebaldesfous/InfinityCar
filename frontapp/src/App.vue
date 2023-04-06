<template>
  <NavbarView></NavbarView>
  <RouterView></RouterView>
</template>

<script>
import NavbarView from './components/NavbarView.vue';

export default {
  name: 'App',
  components: {
    NavbarView
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
