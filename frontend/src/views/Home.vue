<template>
  <div class="home">
    <!-- Q & A 리스트 -->
    <div class="col-9">
      <div v-for="question in questions" :key="question.qid">
        <v-card
          class="mx-auto my-12 p-2"
          width="100%" 
          @click="clickCard"
          min-height="160px"
        >
          <h6># {{question.qid}}</h6>
          <div class="d-flex">
            <div class="col-2 m-auto">
              <div class="question-count d-flex justify-content-center align-center mr-0">
                {{question.count}} 회
              </div>
            </div>
            <div class="col-8">
              <div class="d-flex flex-column justify-content-between h-100">
                <h5>Q. {{question.title}}</h5>
                <div>        
                  <v-chip 
                    class="mr-3" 
                    text-color="white" 
                    color="#27433a"
                  >
                    {{question.mainCategory}}
                  </v-chip>
                  <v-chip 
                    class="mr-3"
                    text-color="white" 
                    color="#468975" 
                  >
                    {{question.subCategory}}
                  </v-chip>
                  <v-chip 
                    text-color="white" 
                    color="#57ae94" 
                  >
                    {{question.keyword}}
                  </v-chip>
                </div>
              </div>
            </div>
            <div class="col-2">
              <div class="d-flex flex-column justify-content-between h-100">
                <h6 class="text-right">{{question.author}}</h6>
                <p class="text-right text-muted">{{question.createDate}}</p>
              </div>

            </div>
          </div>
    
        </v-card>
      </div>

    </div>
    <!-- 목차쪽 -->
    <div class="col-3">

    </div>
    <button 
      class="plus" 
      @click="clickAdd"
    >+</button>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  name: 'Home',
  data() {
    return {
    }
  },
  computed: {
    ...mapState('questionStore', ['questions'])
  },
  methods: {
    ...mapActions('questionStore', ['fetchQuestions']),
    clickCard() {
      this.$router.push('/detail')
    },
    clickAdd() {
      this.$router.push('/add')
    }
  },
  created() {
    this.fetchQuestions()
  }
}
</script>

<style scoped lang="scss">
p, h1, h2, h3, h4, h5, h6 {
  margin: 0 !important;
}

.question-count {
  height: 100px;
  width: 100px;
  background-color: #ccf0e6;
  color: black;
  font-size: 1.2rem;
}
.plus {
  font-size: 2.5rem;
  background-color: #ccf0e6;
  color: black; 
  padding: 5px 25px 5px 25px;
  position: fixed;
  right: 50px;
  bottom : 50px;
  border-radius: 50%;
}
</style>


