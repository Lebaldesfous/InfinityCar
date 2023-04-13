<template>
    
    <form class="container">
        <div class="page-header mb-4">
            <h1 class="page-heading">Register</h1>
        </div>
      <!-- 2 column grid layout with text inputs for the first and last names -->
      <MDBInput
        type="text"
        label="Username"
        id="form3FirstName"
        v-model="username"
        wrapperClass="mb-4"
      />
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
        username:"",
        email:"",
        password:"",
        passwordconfirm: ""
      }
  },
  methods: {
    async signup() {
      if (this.username.trim() === '') {
        alert('Username is required');
        return;
      }
      if (!this.email.match(/^[^\s@]+@[^\s@]+\.[^\s@]+$/)) {
        alert('Invalid email format');
        return;
      }
      if (this.password !== this.passwordconfirm) {
        alert('Passwords do not match');
        return;
      }
      let result = await api.post(
        "/signin",
        {username: this.username, email: this.email, password:this.password}
      )
      if (result.status === 200) {
        alert('User created successfully');
        window.location.href="/"
      } else {
        alert('Error creating user');
        window.location.reload()
      }
    } 
  }
};
</script>