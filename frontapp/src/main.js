import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "bootstrap/dist/js/bootstrap.js"
import "bootstrap/dist/css/bootstrap.css"
import 'mdb-vue-ui-kit/css/mdb.min.css'; 


createApp(App).use(store).use(router).mount('#app')
