<template>
    
    <form class="container">
        <div class="page-header mb-4">
            <h1 class="page-heading">Login</h1>
        </div>
      <!-- Email input -->
      <MDBInput
        type="username"
        label="Username"
        v-model="username"
        wrapperClass="mb-4"
      />
      <!-- Password input -->
      <MDBInput
        type="password"
        label="Password"
        v-model="password"
        wrapperClass="mb-4"
      />

      <!-- Submit button -->
      <MDBBtn color="primary" block v-on:click="login"> Sign in </MDBBtn>
  
      <!-- Register buttons -->
      <div class="text-center">
        <p>Not a member? <a href="#!">Register</a></p>
      </div>
    </form>
  </template>

<style>
.container{
    margin-top: 5%;
    width: 30%;
}
</style>
<script>
import {
  MDBRow,
  MDBCol,
  MDBInput,
  MDBCheckbox,
  MDBBtn,
  MDBIcon
} from "mdb-vue-ui-kit";
import api from '../api'
export default {
  components: {
    MDBRow,
    MDBCol,
    MDBInput,
    MDBCheckbox,
    MDBBtn,
    MDBIcon
  },
  data() {
    return {
      email:"",
      password:""
    }
  },
  methods:{
    async login(){
      let result = await api.post(
        "/login",
        {username: this.username, password:this.password}
      )
      if(result.data != null){
        document.cookie = `session=${this.username}; path=/; SameSite=Strict`
      }
    }
  }
};
</script>