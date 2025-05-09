import { createApp } from 'vue'
import App from './App.vue'
import 'vant/lib/index.css'
import * as VueRouter from 'vue-router';
import routes from './config/route'
import Vant from 'vant';
import '../global.css'

const app = createApp(App);
app.use(Vant);


  
const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes,
})

app.use(router)

app.mount('#app');




