<template>
  <div class="page-holder bg-gray-100">
    <div class="container-fluid px-lg-4 px-xl-5 contentDiv">
      <!-- Page Header-->
      <div class="page-header mb-4">
        <h1 class="page-heading">Profile</h1>
      </div>
      <section>
        <div class="row">
          <div class="col-lg-4">
            <div class="card card-profile mb-4">
              <div class="card-header"
                style="background-image: url(https://www.albilegeant.com/articles/wp-content/uploads/2021/04/genesis-concept-x-1-low-624x446.jpg);">
              </div>
              <div class="card-body text-center"><img class="card-profile-img"
                  src="https://www.sunsetlearning.com/wp-content/uploads/2019/09/User-Icon-Grey-300x300.png" alt="Avatar">
                <h3 class="mb-3" v-if="displayName()">{{name}}</h3>
              </div>
            </div>
          </div>
          <div class="col-lg-8">
            <div class="card overflow-hidden mb-4" id="Commandes">
              <h2 class="card overflow-hidden mb-4">Mes commandes</h2>
              <div class="list-group rounded-0" v-for="(command, index) in commandes" :key="index">
                <div class="list-group-item border-start-0 border-end-0 py-5">
                  <div class="d-flex">
                    <div class="flex-shrink-0"><img class="avatar avatar-lg p-1"
                        src="https://cdn-icons-png.flaticon.com/512/72/72191.png" alt="Rent"></div>
                    <div class="flex-grow-1 ps-3"><small class="float-right" id="Time">{{command.time}}</small>
                      <h5 class="fw-bold">{{command.title}}</h5>
                      <div class="text-muted text-sm">{{command.description}}</div>
                    </div>
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
var name = "Florian Grimmer"
window.onload = () => {

}
export default {
  data() {
    return {
      name: "Florian",
      commandes: [{ time: "12 min ago", title: "Golf 8 GTI", description: "Véhicule très sportif" }]
    }
  },
  methods: {
    displayName() {
      return this.name != null
    }
  }
}
</script>