<template>
    
    <form class="container">
        <div class="page-header mb-4">
            <h1 class="page-heading">Login</h1>
        </div>
      <!-- Email input -->
      <MDBInput
        type="email"
        label="Email address"
        id="form2Email"
        v-model="form2Email"
        wrapperClass="mb-4"
      />
      <!-- Password input -->
      <MDBInput
        type="password"
        label="Password"
        id="form2Password"
        v-model="form2Password"
        wrapperClass="mb-4"
      />

      <!-- Submit button -->
      <MDBBtn color="primary" block> Sign in </MDBBtn>
  
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
import { ref } from "vue";

export default {
  components: {
    MDBRow,
    MDBCol,
    MDBInput,
    MDBCheckbox,
    MDBBtn,
    MDBIcon
  },
  setup() {
    const form2Email = ref("");
    const form2Password = ref("");
    const form2LoginCheck = ref(true);

    return {
      form2Email,
      form2Password,
      form2LoginCheck,
    };
  },
};
</script>