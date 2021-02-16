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
        addQuestion(state, questionData) {
            console.log(state.sample)
            axios.post(api.URL + api.ROUTES.questions, questionData)
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