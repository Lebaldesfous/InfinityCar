<template>
    
    <form class="container">
        <div class="page-header mb-4">
            <h1 class="page-heading">Register</h1>
        </div>
      <!-- 2 column grid layout with text inputs for the first and last names -->
      <MDBRow class="mb-4">
        <MDBCol>
          <MDBInput
            type="text"
            label="First name"
            id="form3FirstName"
            v-model="firstname"
          />
        </MDBCol>
        <MDBCol>
          <MDBInput
            type="text"
            label="Last name"
            id="form3LastName"
            v-model="lastname"
          />
        </MDBCol>
      </MDBRow>
      <!-- Email input -->
      <MDBInput
        type="email"
        label="Email address"
        id="form3Email"
        v-model="email"
        wrapperClass="mb-4"
      />
      <!-- Password input -->
      <MDBInput
        type="password"
        label="Password"
        id="form3Password"
        v-model="password"
        wrapperClass="mb-4"
      />
      <MDBInput
        type="password"
        label="PasswordConfirm"
        id="form3PasswordConfirm"
        v-model="passwordconfirm"
        wrapperClass="mb-4"
      />
  
      <!-- Submit button -->
      <MDBBtn color="primary" block class="mb-4" v-on:click="signup"> Sign up </MDBBtn>
  
    </form>
</template>

<style>

.container{
    width: 30%;
    margin-top: 5%;
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
import axios from 'axios'
export default {
  components: {
    MDBRow,
    MDBCol,
    MDBInput,
    MDBCheckbox,
    MDBBtn,
    MDBIcon
  },
  methods: {
    data() {
      return {
        firstname:"",
        lastname:"",
        email:"",
        password:"",
        passwordconfirm: ""
      }
    },
    async signup() {
      let result = await axios.post(
        "http://localhost:8081/signin",
        {username: this.firstname, email: this.email, password:this.password},
        {headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*'
        }}
      )
      console.warn(result)
    } 
  }
};
</script>