import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import api from '@/assets/api/api'
import cookies from 'vue-cookies'
import router from '@/router'
import axios from 'axios'

export default new Vuex.Store({
  state: {
    authToken: cookies.get('auth-token')
  },
  getters: {
    config: state => ({headers: { jwt : state.authToken }}),
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.authToken = token
      cookies.set('auth-token', token)
    },
  },
  actions: {
    signup(signupData) {
      axios.post(api.URL + api.ROUTES.signup, signupData)
        .then(res => {
          console.log("Success", res)
          router.push({ name: 'Login' })
        })
        .catch(err => {
          console.log(err)
        })
    },
    login({ commit }, loginData) {
      axios.post(api.URL + api.ROUTES.login, loginData)
        .then(res => {
          console.log("Success", res)
          commit('SET_TOKEN', res.data)
          router.push({ name: 'Home' })
        })
        .catch(err => {
          console.log(err)
        })
    },
    logout({ commit }) {
      commit('SET_TOKEN', null)
      cookies.remove('auth-token')
      router.push({ name: 'Login'})
    }
  },
  modules: {
  }
})
