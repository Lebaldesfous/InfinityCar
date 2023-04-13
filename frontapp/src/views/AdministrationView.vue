<template>
    <div class="container mt-5">
        <div class="row mb-3">
            <div class="col">
                <h1>Users</h1>
            </div>
            <div class="col-auto">
                <button class="btn btn-primary" @click="showModalUser = true">Add a user</button>
            </div>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" :key="user.id">
                    <td>{{ user.id }}</td>
                    <td>{{ user.email }}</td>
                    <td>{{ user.username }}</td>
                    <td>{{ user.role }}</td>
                    <td>
                        <button class="btn btn-primary mr-2" @click="editUser(user)">Modify</button>
                        <button class="btn btn-danger" @click="deleteUser(user)">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <modal v-if="showModalUser" @close="showModalUser = false">
            <h2>{{ modalTitle }}</h2>
            <form @submit.prevent="saveUser">
                <div class="form-group">
                    <label for="user-email">Email</label>
                    <input id="user-email" class="form-control" type="email" v-model="editedUser.email" required>
                </div>
                <div class="form-group">
                    <label for="user-username">Username</label>
                    <input id="user-username" class="form-control" type="text" v-model="editedUser.username" required>
                </div>
                <div class="form-group">
                    <label for="user-password">Password</label>
                    <input id="user-password" class="form-control" type="password" v-model="editedUser.password" required>
                </div>
                <div class="form-group">
                    <label for="user-role">Role</label>
                    <select id="user-role" class="form-control" v-model="editedUser.role" required>
                        <option value="user">user</option>
                        <option value="admin">admin</option>
                    </select>
                </div>
                <button class="btn btn-primary mt-1" type="submit">Save</button>
            </form>
        </modal>
        <modal v-if="showModalUserEdit" @close="showModalUserEdit = false">
            <h2>{{ modalTitle }}</h2>
            <form @submit.prevent="applyEditUser">
                <div class="form-group">
                    <label for="user-email">Email</label>
                    <input id="user-email" class="form-control" type="email" v-model="editedUser.email">
                </div>
                <div class="form-group">
                    <label for="user-username">Username</label>
                    <input id="user-username" class="form-control" type="text" v-model="editedUser.username">
                </div>
                <div class="form-group">
                    <label for="user-password">Password</label>
                    <input id="user-password" class="form-control" type="password" v-model="editedUser.password">
                </div>
                <div class="form-group">
                    <label for="user-role">Role</label>
                    <select id="user-role" class="form-control" v-model="editedUser.role">
                        <option value="user">user</option>
                        <option value="admin">admin</option>
                    </select>
                </div>
                <button class="btn btn-primary mt-1" type="submit">Save</button>
            </form>
        </modal>

        <div class="container mt-5">
            <div class="row mb-3">
                <div class="col">
                    <h1>Cars</h1>
                </div>
                <div class="col-auto">
                    <button class="btn btn-primary" @click="showModalCar = true">Add a car</button>
                </div>
            </div>

            <table class="table">
                <thead>
                    <tr>
                        <th>Identifiant</th>
                        <th>Engine</th>
                        <th>Fuel Efficiency</th>
                        <th>Horsepower</th>
                        <th>Name</th>
                        <th>Picture URL</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="car in cars" :key="car.id">
                        <td>{{ car.id }}</td>
                        <td>{{ car.engine }}</td>
                        <td>{{ car.fuel_efficiency }}</td>
                        <td>{{ car.horsepower }}</td>
                        <td>{{ car.name }}</td>
                        <td>{{ car.picture_url }}</td>
                        <td>{{ car.price }}</td>
                        <td>{{ car.stock }}</td>
                        <td>
                            <button class="btn btn-primary mr-2" @click="editCar(car)">Modify</button>
                            <button class="btn btn-danger" @click="deleteCar(car)">Delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>

            <modal v-if="showModalCar" @close="showModalCar = false">
                <h2>{{ modalTitle }}</h2>
                <form @submit.prevent="saveCar">
                    <div class="form-group">
                        <label for="car-engine">Engine:</label>
                        <input id="car-engine" class="form-control" type="text" v-model="editedCar.engine">
                    </div>
                    <div class="form-group">
                        <label for="car-fuel-efficiency">Fuel Efficiency:</label>
                        <input id="car-fuel-efficiency" class="form-control" type="text" v-model="editedCar.fuel_efficiency">
                    </div>
                    <div class="form-group">
                        <label for="car-horsepower">Horsepower:</label>
                        <input id="car-horsepower" class="form-control" type="text" v-model="editedCar.horsepower">
                    </div>
                    <div class="form-group">
                        <label for="car-name">Name:</label>
                        <input id="car-name" class="form-control" type="text" v-model="editedCar.name" required>
                    </div>
                    <div class="form-group">
                        <label for="car-pictureurl">Picture URL :</label>
                        <input id="car-pictureurl" class="form-control" type="text" v-model="editedCar.picture_url">
                    </div>
                    <div class="form-group">
                        <label for="car-price">Price :</label>
                        <input id="car-price" class="form-control" type="text" v-model="editedCar.price">
                    </div>
                    <div class="form-group">
                        <label for="car-price">Stock :</label>
                        <input id="car-stocks" class="form-control" type="text" v-model="editedCar.stock">
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Sauvegarder</button>
                </form>
            </modal>
            <modal v-if="showModalCarEdit" @close="showModalCarEdit = false">
                <h2>{{ modalTitle }}</h2>
                <form @submit.prevent="applyEditCar">
                    <div class="form-group">
                        <label for="car-engine">Engine:</label>
                        <input id="car-engine" class="form-control" type="text" v-model="editedCar.engine">
                    </div>
                    <div class="form-group">
                        <label for="car-fuel-efficiency">Fuel Efficiency:</label>
                        <input id="car-fuel-efficiency" class="form-control" type="text" v-model="editedCar.fuel_efficiency">
                    </div>
                    <div class="form-group">
                        <label for="car-horsepower">Horsepower:</label>
                        <input id="car-horsepower" class="form-control" type="text" v-model="editedCar.horsepower">
                    </div>
                    <div class="form-group">
                        <label for="car-name">Name:</label>
                        <input id="car-name" class="form-control" type="text" v-model="editedCar.name" required>
                    </div>
                    <div class="form-group">
                        <label for="car-pictureurl">Picture URL :</label>
                        <input id="car-pictureurl" class="form-control" type="text" v-model="editedCar.picture_url">
                    </div>
                    <div class="form-group">
                        <label for="car-price">Price :</label>
                        <input id="car-price" class="form-control" type="text" v-model="editedCar.price">
                    </div>
                    <div class="form-group">
                        <label for="car-price">Stock :</label>
                        <input id="car-stocks" class="form-control" type="text" v-model="editedCar.stock">
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Sauvegarder</button>
                </form>
            </modal>
        </div>
    </div>
</template>
  
<script>
import Modal from '@/components/Modal.vue'
import api from '@/api'

export default {
    name: 'AdminPage',

    components: {
        Modal
    },

    data() {
        return {
            users: [],
            showModalUser: false,
            showModalUserEdit: false,
            showModalCar: false,
            showModalCarEdit: false,
            modalTitle: '',
            editedUser: {
                id: null,
                email: '',
                username: ''
            },
            cars: [],
            editedCar: {
                id: null,
                engine: '',
                fuel_efficiency: '',
                horsepower: '',
                name: '',
                picture_url: '',
                price: '',
                stock: ''
            }
        }
    },

    mounted() {
        this.getUsers()
        this.getCars()
    },

    methods: {
        getUsers() {
            api.get('/users').then(response => {
                this.users = response.data
            })
        },

        editUser(user) {
            this.editedUser = {
                id: user.id,
                email: user.email,
                username: user.username
            }
            this.modalTitle = 'User Modify'
            this.showModalUserEdit = true
        },
        async saveUser() {
            let result = api.post('/signin', this.editedUser)
            this.showModalUser = false
            window.location.reload()
        },
        async applyEditUser(){
            let result = api.put(`/users/${this.editedUser.id}/update`, this.editedUser)
            this.showModalUserEdit = false
            window.location.reload()
        },
        async deleteUser(user) {
            if (confirm('Are you sure that you want to delete this user ?')) {
                let result = api.delete(`users/${user.id}/delete`)
                this.showModalUser = false
                window.location.reload()
            }
        },

        getCars() {
            api.get('/cars').then(response => {
                this.cars = response.data
            })
        },
        async saveCar() {
            let result = api.post('/cars/add', this.editedCar)
            this.showModalCar = false
            window.location.reload()
        },
        async applyEditCar(){
            let result = api.put(`/cars/${this.editedCar.id}/update`, this.editedCar)
            this.showModalCarEdit = false
            window.location.reload()
        },
        editCar(car) {
            this.editedCar = {
                id: car.id,
                engine: car.engine,
                fuel_efficiency: car.fuel_efficiency,
                horsepower: car.horsepower,
                name: car.name,
                picture_url: car.picture_url,
                price: car.price,
                stock: car.stock
            }
            this.modalTitle = 'Car Modify'
            this.showModalCarEdit = true
        },

        deleteCar(car) {
            if (confirm('Are you sure that you want to delete this car ?')) {
                api.delete('/cars/' + car.id + '/delete')
                    .then(() => this.getCars())
                    .catch(error => console.log(error))
            }
        },
    }
}
</script>