<template>
    <div class="col-sm-12 col-md-4 mb-4">
        <div class="card custom-card">
            <img :src="car.image" class="card-img-top" width="100%">
            <div class="card-body pt-0 px-0">
                <div class="d-flex flex-row justify-content-between mb-0 px-3">
                    <small class="text-muted mt-1">CAR</small>
                    <h6>{{car.name}}</h6>
                </div>
                <div class="d-flex flex-row justify-content-between mb-0 px-3">
                    <small class="text-muted mt-1">STARTING AT</small>
                    <h6>&dollar;{{car.price}}</h6>
                </div>
                <hr class="mt-2 mx-3">
                <div class="d-flex flex-row justify-content-between px-3 pb-4">
                    <div class="d-flex flex-column">
                        <span class="text-muted">Fuel Efficiency</span>
                        <small class="text-muted">L/100KM</small>
                    </div>
                    <div class="d-flex flex-column">
                        <h5 class="mb-0">{{ car.fuel_efficiency }}</h5>
                        <small class="text-muted text-right">(city/Hwy)</small>
                    </div>
                </div>
                <div class="d-flex flex-row justify-content-between p-3 mid">
                    <div class="d-flex flex-column">
                        <small class="text-muted mb-1">ENGINE</small>
                        <div class="d-flex flex-row">
                            <img src="https://imgur.com/iPtsG7I.png" width="35px" height="25px">
                            <div class="d-flex flex-column ml-1">
                                <small class="ghj">{{ car.engine }}</small>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex flex-column">
                        <small class="text-muted mb-2">HORSEPOWER</small>
                        <div class="d-flex flex-row">
                            <img src="https://imgur.com/J11mEBq.png">
                            <h6 class="ml-1">{{car.horsepower}}</h6>
                        </div>
                    </div>
                </div>
                <small class="text-muted key pl-3">Standard key Features</small>
                <div class="mx-3 mt-3 mb-2"><button type="button" class="btn btn-danger btn-block"
                        @click="showModal = true"><small>BOOK</small></button></div>
                <small class="d-flex justify-content-center text-muted">*Legal Disclaimer</small>
            </div>
        </div>
    </div>
    <div class="modal" tabindex="-1" role="dialog" style="display: block;" v-if="showModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Book confirmation</h5>
                    <button type="button" class="close" @click="showModal = false">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to book this vehicle? This will appear on your profile page and decrease available
                    stock.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary text-danger" @click="showModal = false">Cancel</button>
                    <button type="button" class="btn btn-primary text-white bg-danger">Rent</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        car: {
            type: Object
        }
    },
    data() {
        return {
            showModal: false,
        }
    },
}
</script>

<style>
.modal {
    position: fixed;
    z-index: 9999;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-content {
    background-color: white;
    padding: 20px;
    max-width: 500px;
    max-height: 80%;
    overflow-y: auto;
}

.modal-header .close {
    display: none;
}

.custom-card {
    width: 250px;

}

.card-img-top {
    height: 170px;
}
</style>