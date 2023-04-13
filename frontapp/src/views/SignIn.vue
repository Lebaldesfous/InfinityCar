<template>
    
    <form class="container">
        <div class="page-header mb-4">
            <h1 class="page-heading">Login</h1>
        </div>
      <!-- Email input -->
      <MDBInput
        type="username"
        label="Username or email"
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
        <RouterLink to="/signin">Not a member? <a href="/signup">Register</a></RouterLink>
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
      if(this.email == "" || this.password == ""){
        alert("Please fill all the fields")
        return
      }
      let result = await api.post(
        "/login",
        {username: this.email, password:this.password}
      )
      console.log(result)
      if(document.cookie.includes("session=")){
        console.log("Un cookie de session existe déjà.")
      }else if(result.data != null){
        document.cookie = `session=${this.email}; path=/; SameSite=Strict`
        window.location.href = "/"
      } else {
        alert("Wrong username or password")
        window.location.reload()
      }
    }
  }
};
</script>