import axios from 'axios'
import api from '@/assets/api/api'
// import router from '@/router'

const questionStore = {
    namespaced : true,
    state: {
        sample: ""
    },
    getters: {

    },
    mutations: {
    },
    actions: {
        addQuestion({rootGetters}, questionData) {
            axios.post(api.URL + api.ROUTES.questions, questionData, rootGetters.config)
                .then(res => {
                    console.log("SUCCESS", res)
                })
                .catch(err => {
                    console.log("FAIL", err)
                })
        }
    },
}

export default questionStore