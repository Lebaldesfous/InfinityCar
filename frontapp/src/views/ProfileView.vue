<template>
  <div class="page-holder bg-gray-100">
    <div class="container-fluid px-lg-4 px-xl-5 contentDiv">
      <!-- Page Header-->
      <div class="page-header mb-4">
        <h1 class="page-heading">Profile</h1>
      </div>
      <section>
        <div class="d-flex justify-content-center">
          <div class="profile-card col-lg-3">
            <div class="card card-profile mb-4">
              <div class="card-header"
                style="background-image: url(https://www.albilegeant.com/articles/wp-content/uploads/2021/04/genesis-concept-x-1-low-624x446.jpg);">
              </div>
              <div class="card-body text-center"><img class="card-profile-img"
                  src="https://www.sunsetlearning.com/wp-content/uploads/2019/09/User-Icon-Grey-300x300.png" alt="Avatar">
                <h3 class="mb-3" v-if="haveCookie()">{{ this.name }}</h3>
              </div>
            </div>
          </div>
          <div class="col-lg-8">
            <div class="card overflow-hidden mb-4" id="Commandes">
              <h2 class="card overflow-hidden mb-4">Mes réservations</h2>
              <div class="list-group rounded-0" v-for="(command, index) in commandes" :key="index">
                <div class="list-group-item border-start-0 border-end-0 py-5">
                  <div class="d-flex">
                    <div class="flex-shrink-0"><img class="avatar avatar-lg p-1" :src="command.car.pictureUrl" alt="Rent">
                    </div>
                    <div class="mx-auto d-flex justify-content-center">
                      <h5 class="fw-bold">N° de réservation : {{ command.id }}</h5>
                      <div>
                        <div class="flex-grow-1 ps-3"><small class="float-right" id="Time">Modèle :
                            {{ command.car.name }}</small>

                        </div>
                        <div class="flex-grow-1 ps-3"><small class="float-right" id="Time">À payer :
                            {{ command.car.price }}</small></div>
                        <div class="flex-grow-1 ps-3"><small class="float-right" id="Time">Moteur :
                            {{ command.car.engine }}</small></div>
                        <div class="flex-grow-1 ps-3"><small class="float-right" id="Time">
                            {{ command.car.horsepower }}</small></div>
                      </div>
                    </div>
                    <button class="btn btn-danger pull-right" @click="cancelOrder(command.id)">Cancel</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>
<script>
import api from '../api'
export default {
  data() {
    return {
      name: "",
      id: 1,
      commandes: []
    }
  },
  mounted() {
    this.fetchOrders();
  },
  methods: {
    async haveCookie() {
      if (document.cookie.includes("session=")) {
        this.name = document.cookie.split("session=")[1].split(";")[0]
        let result = await api.get(
          `user/${this.name}`,
        )
        this.id = result.data
        return true
      } else {
        return false
      }
    },
    async fetchOrders() {
      try {
        const response = await api.get(
          `order/user/${this.id}`
        );
        this.commandes = response.data
      } catch (error) {
        console.log(error);
      }
    },
    async cancelOrder(orderId) {
      try {
        await api.delete(`order/${orderId}/delete`);
        window.location.reload()
      } catch (error) {
        console.log(error);
      }
}
  }
}
</script>

<style>
.profile-card {
  margin-right: 3%;
}
</style>