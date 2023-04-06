import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SignIn from '../views/SignIn.vue'
import SignUp from '../views/SignUp.vue'
import ProfileView from '../views/ProfileView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: SignIn
  },
  {
    path: '/signin',
    name: 'signin',
    component:  SignUp
  },
  {
    path: '/profile',
    name: 'profil',
    component:  ProfileView
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
