<template>
    <div class="background">
         <!-- Question Part -->
        <div class="w-50 mx-auto question">
            <!-- header -->
            <div class="d-flex header">
                <div class="counter text-center mr-4">
                    <p>{{question.count}}회</p>
                </div>
                <div class="d-flex">
                    <h3>{{question.title}}</h3>
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
                <h4 class="my-3">A 3개</h4>
                <!--  답변 1 -->
                <div class="answer p-3 my-3">
                    <div class="header">
                        <h6>신채린님 답변</h6>
                        <h6>2021.02.04</h6>
                    </div>
                    <hr class="my-2" />
                    <div class="content">
                        <p>nginx 사용하면 해결돼요.</p>
                        <p>여기 링크 참고해보세요!.</p>
                    </div>
                </div>
                <!--  답변 2 -->
                <div class="answer p-3 my-3">
                    <div class="header">
                        <h6>신채린님 답변</h6>
                        <h6>2021.02.04</h6>
                    </div>
                    <hr class="my-2" />
                    <div class="content">
                        <p>nginx 사용하면 해결돼요.</p>
                        <p>여기 링크 참고해보세요!.</p>
                    </div>
                </div>
                <!--  답변 3 -->
                <div class="answer p-3 my-3">
                    <div class="header">
                        <h6>신채린님 답변</h6>
                        <h6>2021.02.04</h6>
                    </div>
                    <hr class="my-2" />
                    <div class="content">
                        <p>nginx 사용하면 해결돼요.</p>
                        <p>여기 링크 참고해보세요!.</p>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    name: 'Detail',
    computed: {
        ...mapState(['userInfo']),
        ...mapState('questionStore', ['question'])
    },
    methods: {
        ...mapActions(['getInfo']),
        ...mapActions('questionStore', ['getQuestion'])
    },
    created() {
        this.getQuestion(this.$route.params.qid)
        this.getInfo()
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