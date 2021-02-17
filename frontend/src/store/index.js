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
    userInfo: null
  },
  getters: {
    config: state => ({headers: { 'Authorization' : `Bearer ${state.authToken}`}}),
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.authToken = token
      cookies.set('auth-token', token)
    },
    SET_USERINFO(state, userInfo) {
      state.userInfo = userInfo
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
    login({ commit, dispatch }, loginData) {
      axios.post(api.URL + api.ROUTES.login, loginData)
        .then(res => {
          commit('SET_TOKEN', res.data.token)
          dispatch('getInfo')
          router.push({ name: 'Home' })
        })
        .catch(err => {
          console.log(err)
        })
    },
    logout({ commit }) {
      commit('SET_TOKEN', null)
      commit("SET_USERINFO", null)
      cookies.remove('auth-token')
      router.push({ name: 'Login'})
    },
    getInfo({ getters, commit }) {
      axios.get(api.URL + api.ROUTES.users, getters.config)
        .then(res => {
          commit('SET_USERINFO', res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }
  },
  modules: {
    questionStore: questionStore,
  }
})
