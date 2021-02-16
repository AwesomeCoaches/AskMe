import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import Detail from '@/views/Detail.vue'
import Login from '@/views/Login.vue'
import Signup from '@/views/Signup.vue'
import Editor from '@/views/Editor.vue'
import Ranking from '@/views/Ranking.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/detail',
    name: 'Detail',
    component: Detail
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/add',
    name: 'Editor',
    component: Editor
  },
  {
    path:'/ranking',
    name: 'Ranking',
    component: Ranking
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
