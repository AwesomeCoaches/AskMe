<template>
  <div class="background d-flex align-center">
    <div class="card w-75 mx-auto">
      <div class="card-item d-flex">
        <div class="intro col-5 d-flex align-center justify-content-center h-100">
          <div class="w-75 m-auto h-50">
            <h3 class="welcome">Welcome to AskMe</h3>
            <hr class="w-25">
            <small class="intro-text">
              SSAFY 실습코치 4기가 만든 Q&A 프로젝트 웹사이트입니다. 
              교육생들의 질문을 함께 공유하고, 정리하기 위한 목적으로 만들었습니다.
              언제든 참여해주세요!!
            </small>
            <br/>
            <button class="btn mt-3" @click="clickLogin">Login</button>
          </div>
        </div>
        <div class="signup-form col-7 h-100 d-flex align-center">
          <div class="signup-container m-auto h-50">
            <h3 class="signup text-center">Signup</h3>
            <hr class="w-25 m-auto">
            <input 
              placeholder="이름을 입력해주세요" 
              autofocus
              v-model="signupData.name"
              required
            >
            <input 
              placeholder="비밀번호를 입력해주세요"
              v-model="signupData.password"
              type="password"
              required
            >
            <input 
              placeholder="비밀번호를 다시 입력해주세요"
              v-model="passwordConfirmation"
              type="password"
              required
              @keyup.enter="clickSignup"
            >
            <button 
              class="btn mt-3"
              @click="clickSignup"
            >Signup</button>
          </div>
        </div>
      </div>
      
    </div>
  </div>

</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'Login',
  data() {
    return {
      signupData: {
        name: '',
        password: '',
      },
      passwordConfirmation: '',
    }
  },
  methods: {
    ...mapActions(['signup']),
      clickLogin() {
          this.$router.push('/login')
      },
      clickSignup() {
        if (this.signupData.password === this.passwordConfirmation) {
          this.signup(this.signupData)
        } else {
          alert('비밀번호가 일치하지 않습니다.')
        }
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
</style>