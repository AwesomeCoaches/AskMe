<template>
  <div class="home">
    <!-- Q & A 리스트 -->
    <div class="col-9">
      <v-card
      :loading="loading"
      class="mx-auto my-12"
      width="100%" 
      @click="clickCard"
      >
    
        <template slot="progress">
          <v-progress-linear
            color="deep-purple"
            height="10"
            indeterminate
          ></v-progress-linear>
        </template>

        <v-card-text># 질문 번호</v-card-text>
        
         
        <v-card-title>Q. 여기에 질문을 작성할 것입니다. I'll write question here.</v-card-title>
        <v-card-title class="d-flex justify-content-end">작성자다!</v-card-title>
        
        <v-divider class="mx-4"></v-divider>
        <v-card-text>
          <v-col align="left" margin="0px" >        
            <v-chip text-color="white" color="blue" small>대분류</v-chip>
            <v-chip text-color="white" color="green" small>소분류</v-chip>
            <v-chip text-color="white" color="pink" small>키워드</v-chip>
          </v-col>
        </v-card-text>   
   
      </v-card>
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
export default {
  name: 'Home',
  data() {
    return {
    }
  },
  methods: {
    clickCard() {
      this.$router.push('/detail')
    },
    clickAdd() {
      this.$router.push('/add')
    }
  }
}
</script>

<style scoped lang="scss">
.background {
  background-color: snow;
  height: 100%;
}

.card {
  height: 60%;
  border-radius: 5%;
  border: 0;
  box-shadow: 12px 12px 2px 1px rgba(0, 0, 0, .1);
  .card-item {
    height: 100%;
    .intro {
      background-color: #d1f2e8;
      border-top-left-radius: 6%;
      border-bottom-left-radius: 6%;
      hr {
        height: 3px;
        background-color: #2e0d17;
      }
      .welcome {
        color: midnightblue;
      }
      .intro-text {
        word-break: keep-all;
      }
      button {
        border: 1px solid white;
        border-radius: 15px;
        &:hover {
          background-color: #8bdec5;
          color: white;
        }
      }
    }
    .signup-form {
      .signup-container {
        width: 60%;
      }
      hr {
        margin-bottom: 10px;
        height: 3px;
        background-color: midnightblue; 
        border: 0;
      }
      input {
        font-family: fangsong;
        border-bottom: 2px solid #8080800f;
        margin: 15px 0;
        width: 100%;
        &:hover, &:active {
          border-bottom: 2px solid #8bdec5;
        }
      } 
      button {
        background-color: #8bdec5;
        color: white;
        width: 100%;
        border-radius: 15px;
        &:hover {
            background-color: #67d5b5;
        }
      }
    }
  }
}

.plus {
  font-size: 2.5rem;
  background-color: pink;
  color: white; 
  width: 50px;
  height: 50px;
  position: absolute;
  right: 50px;
  bottom : 50px;
  border-radius: 50%;
}
</style>


