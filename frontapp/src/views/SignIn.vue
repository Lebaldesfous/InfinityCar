<template>
    
    <form class="container">
        <div class="page-header mb-4">
            <h1 class="page-heading">Login</h1>
        </div>
      <!-- Email input -->
      <MDBInput
        type="email"
        label="Email address"
        v-model="email"
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
    login(){
      console.log(this.email, this.password)
    }
  }
};
</script>