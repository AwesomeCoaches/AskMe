<template>
    <div class="background">
         <!-- Question Part -->
        <div class="w-50 mx-auto question">
            <!-- header -->
            <div class="d-flex justify-content-between header">
                <div>   
                    <div class="counter text-center mr-4">
                        <p>{{question.count}}회</p>
                    </div>
                    <div class="d-flex">
                        <h3>{{question.title}}</h3>
                    </div>
                </div>
                <div>
                    <div class="mt-3">
                        <button
                            v-if="question.author === userInfo.name"
                            id="delete-btn"
                            @click="deleteQuestion(question.qid)"
                        >
                            삭제
                        </button>
                    </div>
                </div>
                
            </div>
            <!-- content  -->
            <div class="content mt-3">
                <!-- Detailed Question -->
                <p class="mb-3">{{question.content}}</p>
                <!-- 대분류 소분류 -->
                <div class="d-flex">
                    <button class="badge big-classification" disabled>{{question.mainCategory}}</button>
                    <button class="badge small-classification" disabled>{{question.subCategory}}</button>
                </div>
            </div>
            <!-- footer -->
            <div class="footer d-flex my-2">
                <p>
                    <span>{{question.author}}</span> ·
                    <span>{{question.createDate}}</span>
                </p>
            </div>
        </div>
        <hr/>
        <!-- 답변 -->
        <div class="bottom">
            <div class="w-50 mx-auto">
                <div class="d-flex justify-content-between my-3">
                    <h4>{{countingAnswers}}</h4>
                    <button
                        id="show-modal"
                        @click="showModal=true"
                    >
                        답변 작성하기
                    </button>
                    <modal v-if="showModal" @close="showModal=false"></modal>
                </div>
                <div 
                    class="answer p-3 my-3"
                    v-for="answer in answers"
                    :key="answer.aid"
                >
                    <div class="header d-flex justify-content-between">
                        <div>
                            <h6>{{answer.author}}님 답변</h6>
                            <h6>{{answer.createDate}}</h6>
                        </div>
                        <button 
                            v-if="answer.author===userInfo.name"
                            @click="deleteAnswer({aid: answer.aid, qid: question.qid})"
                        >
                            삭제
                        </button>
                    </div>
                    <hr class="my-2" />
                    <div class="content">
                        {{answer.content}}
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import modal from '@/components/Modal.vue'

export default {
    name: 'Detail',
    components: {
        modal
    },
    data() {
        return {
            showModal: false
        }
        
    },
    computed: {
        ...mapState(['userInfo']),
        ...mapState('questionStore', ['question', 'answers']),
        countingAnswers: function() {
            if (this.answers) {
                if (this.answers.length >= 1) {
                    return "A " + this.answers.length + "개"
                } else {
                    return "아직 등록된 답변이 없어요"
                }
            } else {
                return "아직 등록된 답변이 없어요"
            }
        }
    },
    methods: {
        ...mapActions(['getInfo']),
        ...mapActions('questionStore', ['getQuestion', 'deleteQuestion', 'fetchAnswers', 'deleteAnswer']),
    },
    created() {
        this.getQuestion(this.$route.params.qid)
        this.getInfo()
        this.fetchAnswers(this.$route.params.qid)
    }
}
</script>

<style scoped lang="scss">
h1, h2, h3, h4, h5, h6, p {
    margin: 0;
}
html, body {
    background-color: #d1f2e8;
    height: 100% !important;
}

.background {
    display: flex;
    flex-flow: column;
    height: 100%;
}
.header {
    .counter {
        background-color: mediumaquamarine;
        width: 50px;
        height: 50px;
        p{
            font-weight: bold;
            line-height: 50px;
        }
    }
    #delete-btn {
        background-color: #d1f2e8;
        padding: 5px;
        border-radius: 20%;
    }
    h3 {
        font-weight: bold;
        line-height: 50px;
    }
}

.content {
    margin-top: 10px;
    .big-classification {
        padding: 10px;
        border-radius: 20px;
        background-color: #A3E6D2;
        margin-right: 10px;
        color: black;
    }
    .small-classification {
        padding: 10px;
        border-radius: 30%;
        background-color: #d1f2e8;
        color: black;
    }
}

hr {
    margin: 0;
    padding: 0 5px 0 5px;
    color: #d1f2e8;
}

.bottom {
    background-color: #d1f2e8;
    flex-grow: 1;
    .answer {
        background-color: white;
    }
}
</style>