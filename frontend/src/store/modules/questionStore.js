import axios from 'axios'
import api from '@/assets/api/api'
import router from '@/router'

const questionStore = {
    namespaced : true,
    state: {
        questions: null,
        question: null,
        answers: null,
    },
    getters: {

    },
    mutations: {
        setQuestions(state, questions) {
            state.questions = questions
        },
        setQuestion(state, question) {
            state.question = question 
        },
        setAnswers(state, payload) {
            state.answers = payload
        }
    },
    actions: {
        // 질문 가져오기
        fetchQuestions({ rootGetters, commit }) {
            axios.get(api.URL + api.ROUTES.questions, rootGetters.config)
                .then(res => {
                    commit('setQuestions', res.data)
                })
                .catch(err => {
                    console.log(err)
                })
        },
        // 상세 질문 가져오기 
        getQuestion({ rootGetters, commit }, qid) {
            axios.get(api.URL + api.ROUTES.questions + "/" + qid, rootGetters.config)
                .then(res => {
                    commit('setQuestion', res.data)
                })
                .catch(err => {
                    console.log(err)
                })
        },
        // 질문 추가하기 
        addQuestion({ rootGetters }, questionData) {
            axios.post(api.URL + api.ROUTES.questions, questionData, rootGetters.config)
                .then(res => {
                    console.log("SUCCESS", res)
                    router.push({ name: 'Home' })
                })
                .catch(err => {
                    console.log("FAIL", err)
                })
        },
        //질문 삭제하기
        deleteQuestion({ rootGetters }, qid) {
            axios.delete(api.URL + api.ROUTES.questions + "/" + qid, rootGetters.config)
                .then(() => {
                    console.log("SUCCESS DELETING")
                    router.push({ name: 'Home'})
                })
                .catch(err => {
                    console.log("FAIL", err)
                })
        },
        // 답변 가져오기
        fetchAnswers({ rootGetters, commit }, qid) {
            axios.get(api.URL + api.ROUTES.answers + "/qid/" + qid, rootGetters.config)
                .then(res => {
                    commit('setAnswers', res.data)
                })
                .catch(err => {
                    console.log(err)
                })
        },
        // 답변 등록하기 
        addAnswer({ rootGetters, dispatch }, answerData) {
            axios.post(api.URL + api.ROUTES.answers, answerData, rootGetters.config)
                .then(() => {
                    dispatch('fetchAnswers', answerData.qid)
                })
                .catch(err => {
                    console.log("FAIL", err)
                })
        },
        deleteAnswer({ rootGetters, dispatch }, data) {
            axios.delete(api.URL + api.ROUTES.answers + "/" + data.aid, rootGetters.config)
                .then(()=> {
                    dispatch('fetchAnswers', data.qid)
                })
                .catch(err => {
                    console.log("FAIL", err)
                })
        }
    },
}

export default questionStore