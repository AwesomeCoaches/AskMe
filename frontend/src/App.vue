<template>
  <v-app>
    <div>
      <nav class="d-flex justify-content-between align-center" v-if="this.$route.name!=='Login' && this.$route.name!=='Signup'">
          <img 
            class="logo"
            src="@/assets/askme.png" 
            alt="logo" 
          />
          <div class="d-flex align-center">
            <input 
              type="search" 
              v-model="keyword" 
              @keyup.enter="search(keyword)"
            >
            <div 
              class="login" 
              @click="clickLogin"
              v-if="authToken"
            >
              로그인
            </div>
            <div
              class="logout"
              @click="logout()"
              v-else
            >
              로그아웃
            </div>
          </div>
      </nav>
    </div>
    
    <router-view />
  </v-app>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  name: 'App',

  data() {
    return {
      ...mapState(['authToken']),
      keyword: null,
      isActive:null,
    }
  },
  
  methods: {
    ...mapActions(['logout']),
    clickDetail() {
      this.$router.push('/detail')
    },
    clickLogo() {
      this.$router.push('/')
    },
    clickLogin() {
      this.$router.push('/login')
    }
  }
};
</script>
<style>
@font-face{
  font-family: bm;
  src: url(../src/assets/font/BMHANNAAir_ttf.ttf);
  }

* {
  font-family: '배민', BMHANNAAir, bm;
}

/* Search bar */
input {
	outline: none;
}
input[type=search] {
	-webkit-appearance: textfield;
	-webkit-box-sizing: content-box;
	font-size: 100%;
}
input::-webkit-search-decoration,
input::-webkit-search-cancel-button {
	display: none; 
}
input[type=search] {
	background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
	border: solid 1px #ccc;
	padding: 9px 10px 9px 32px;
	width: 55px;
	
	-webkit-border-radius: 10em;
	-moz-border-radius: 10em;
	border-radius: 10em;
	
	-webkit-transition: all .5s;
	-moz-transition: all .5s;
	transition: all .5s;
}
input[type=search]:focus {
	width: 130px;
	background-color: #fff;
	border-color: #88A498;
	
	-webkit-box-shadow: 0 0 5px #88A498;
	-moz-box-shadow: 0 0 5px #88A498;
	box-shadow: 0 0 5px #88A498;
}
input:-moz-placeholder {
	color: #999;
}
input::-webkit-input-placeholder {
	color: #999;
}
#search-bar input[type=search] {
	width: 15px;
	padding-left: 10px;
	color: transparent;
	cursor: pointer;
}
#search-bar input[type=search]:hover {
	background-color: #fff;
}
#search-bar input[type=search]:focus {
	width: 130px;
	padding-left: 35px;
	color: #000;
	background-color: #fff;
	cursor: auto;
}
#search-bar input:-moz-placeholder {
	color: transparent;
}
#search-bar input::-webkit-input-placeholder {
	color: transparent;
}

</style>

<style scoped lang="scss">
nav {
  height: 7vh;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.2);
  padding: 0px 15px 0px 15px;
  background-color: #67d5b5;
  img {
    height: 6vh;
    cursor: pointer;
  }
  .login {
    color: white;
    padding: 10px;
    cursor: pointer;
    &:hover {
      color: #d56787;
    }
  }
  .logout {
    color: white; 
    padding: 10px; 
    cursor: pointer;
    &:hover {
      color: #d56787;
    }
  }
}
</style>
