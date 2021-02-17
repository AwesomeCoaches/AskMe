<template>
  <div class="background">
      <div class="title text-center my-5">
        <h1>FAQ 랭킹 순위</h1>
      </div>
      <v-container class="bod">
          <v-row>
            <v-col cols="1"></v-col>
            <v-col cols="4">
                <h3>카테고리별</h3>
                <div class="list-container">
                    <div class="list-element d-flex" v-for="(category, i) in categoryRanking" :key="i">
                        <h2 class="rank-number my-auto ml-5 mr-10">{{ i + 1 }}</h2>
                        <div>
                            <h4>{{ category._id }}</h4>
                            <h6>질문: {{ category.Questions }}</h6>
                        </div>
                    </div>
                </div>
            </v-col>
            <v-col cols="2"></v-col>
            <v-col cols="4">
                <h3>키워드별</h3>
                <div class="list-container">
                    <div class="list-element d-flex" v-for="(keyword, i) in keywordRanking" :key="i">
                        <h2 class="rank-number my-auto ml-5 mr-10">{{ i + 1 }}</h2>
                        <div>
                            <h4>{{ keyword._id }}</h4>
                            <h6>질문: {{ keyword.Questions }}</h6>
                        </div>
                    </div>
                </div>
            </v-col>
            <v-col cols="1"></v-col>
          </v-row>
      </v-container>
  </div>
</template>

<script>
import axios from 'axios'
import api from '@/assets/api/api'
import { mapGetters } from 'vuex'

export default {
    name: 'Ranking',
    data() {
        return {
            categoryRanking: [],
            keywordRanking: []
        }
    },

    computed: {
        ...mapGetters(['config'])
    },

    methods: {
        fetchRankingList() {
            axios.get(api.URL + api.ROUTES.statistics, this.config)
                .then(res => {
                    this.categoryRanking = res.data.SubCategory
                    this.keywordRanking = res.data.Keyword
                })
                .catch(err => console.error(err))
        },
    },

    mounted() {
        this.fetchRankingList()
    },
}
</script>

<style scoped>
    h1, h2, h3, h4, h5, h6, p {
        margin: 0;
    }

    .background {
        margin: 0 !important;
        background-color: #d1f2e8;
        height: 100%;
    }

    .list-element {
    padding: 10px 10px;
    margin: 5px 0px;
    background-color: white;
    border-radius: 5px;
    }
    
</style>