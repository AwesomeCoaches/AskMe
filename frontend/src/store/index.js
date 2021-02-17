import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import questionStore from '@/store/modules/questionStore'

import api from '@/assets/api/api'
import cookies from 'vue-cookies'
import router from '@/router'
import axios from 'axios'

export default new Vuex.Store({
  state: {
    authToken: cookies.get('auth-token'),
    author: ""
  },
  getters: {
    config: state => ({headers: { 'Authorization' : `Bearer ${state.authToken}`}}),
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.authToken = token
      cookies.set('auth-token', token)
    },
    SET_AUTHOR(state, author) {
      state.author = author 
    }
  },
  actions: {
    signup({state}, signupData) {
      console.log(state.author)
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
          commit('SET_TOKEN', res.data.token)
          commit('SET_AUTHOR', loginData.name)
          router.push({ name: 'Home' })
        })
        .catch(err => {
          console.log(err)
        })
    },
    logout({ commit }) {
      commit('SET_TOKEN', null)
      commit('SET_AUTHOR', null)
      cookies.remove('auth-token')
      router.push({ name: 'Login'})
    }
  },
  modules: {
    questionStore: questionStore,
  }
})
