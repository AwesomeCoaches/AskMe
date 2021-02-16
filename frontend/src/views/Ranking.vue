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
                    <div class="list-element d-flex" v-for="l in list" :key="l.rank">
                        <h2 class="rank-number my-auto ml-5 mr-10">{{ l.rank }}</h2>
                        <div>
                            <h4>{{ l.category }}</h4>
                            <h6>질문: {{ l.q }}</h6>
                        </div>
                    </div>
                </div>
            </v-col>
            <v-col cols="2"></v-col>
            <v-col cols="4">
                <h3>키워드별</h3>
                <div class="list-container">
                    <div class="list-element d-flex" v-for="l in list" :key="l.rank">
                        <h2 class="rank-number my-auto ml-5 mr-10">{{ l.rank }}</h2>
                        <div>
                            <h4>{{ l.category }}</h4>
                            <h6>질문: {{ l.q }}</h6>
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
export default {
    name: 'Ranking',
    data() {
        return {
            list: [
                {rank: 1, category: 'Spring', q: 10},
                {rank: 2, category: 'Django', q: 9},
                {rank: 3, category: 'Flask', q: 8},
                {rank: 4, category: 'Vue.js', q: 7},
                {rank: 5, category: 'React', q: 6},
                {rank: 6, category: 'Angular', q: 5},
                {rank: 7, category: 'Node.js', q: 4},
                {rank: 8, category: 'Tensorflow', q: 3},
                {rank: 9, category: 'Pandas', q: 2},
                {rank: 10, category: 'PyTorch', q: 1},
            ]
        }
    },
}
</script>

<style scoped>
    h1, h2, h3, h4, h5, h6, p {
        margin: 0;
    }

    .background {
    background-color: #d1f2e8;
    height: 100%;
    }

    .list-element {
    padding: 10px 10px;
    margin: 5px 0px;
    background-color: white;
    border-radius: 5px;
    }
    
    .rank-number {
        
    }
</style>