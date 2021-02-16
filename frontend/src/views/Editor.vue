<template>
  <div class="container">
    <v-row align="center" no-gutters>
      <v-col
        class="d-flex mr-5"
        cols="12"
        sm="3"
      >
        <v-select
          v-model="mainCategory"
          :items="items"
          label="대분류"
        ></v-select>
      </v-col>

      <v-col
        class="d-flex mr-5"
        cols="12"
        sm="3"
      >
        <v-select
          v-if="mainCategory==='Backend'"
          v-model="subCategory"
          :items="Backend"
          label="소분류"
        ></v-select>
        <v-select
          v-if="mainCategory==='Frontend'"
          v-model="subCategory"
          :items="Frontend"
          label="소분류"
        ></v-select>
        <v-select
          v-if="mainCategory==='Database'"
          v-model="subCategory"
          :items="Database"
          label="소분류"
        ></v-select>
        <v-select
          v-if="mainCategory==='Server'"
          v-model="subCategory"
          :items="Server"
          label="소분류"
        ></v-select>
        <v-select
          v-if="mainCategory==='기타'"
          v-model="subCategory"
          :items="기타"
          label="소분류"
        ></v-select>
        
      </v-col>
      <v-col
        class="d-flex"
        cols="12"
        sm="3"
      >
        <v-select
          v-model="keyword"
          :items="keywords"
          label="키워드"
        ></v-select>
      </v-col>
    </v-row>
    <input 
      class="QnA-title mb-5 p-3"
      v-model="title" 
      placeholder="제목을 작성해주세요."
    >
    <editor 
      ref="toastuiEditor"
      :options="editorOptions"
      height="500px"
      initialEditType="wysiwyg"
      previewStyle="vertical"
      placeholder="내용입니다."
    />
    <div class="d-flex justify-content-end">
      <button 
        class="my-3"
        @click="submit" 
      >
        저장하기
      </button>
    </div>
  </div>
</template>

<script>
import 'codemirror/lib/codemirror.css';
import '@toast-ui/editor/dist/toastui-editor.css';

import { Editor } from '@toast-ui/vue-editor';
import { mapState, mapActions } from 'vuex'

export default {
  name: 'Editor',
  components: {
    editor: Editor
  },
  computed: {
    ...mapState(['author']),
  },
  data() {
    return {
      editorText: '질문을 작성해주세요.',
      editorOptions: {
        hideModeSwitch: true
      },
      title: "",
      items: ['Frontend', 'Backend', 'Database', 'Server', '기타'],
      Frontend: ['React', 'Vue.js', 'HTML & CSS'],
      Backend: ['Django', 'Spring', 'Node.js', 'Flask'],
      Database: ['MySQL', 'MariaDB', 'Redis'],
      Server: ['Jenkins', 'AWS', 'Docker'],
      기타: ['운영', '발표', '평가',  '명세서'],
      keywords: ['인프라', '에러', '설계', '환경설정', '배포', '교보재', '산출물', '학습', '개발'],
      mainCategory: "",
      subCategory: "",
      keyword:""
    }
  },
  methods: {
    ...mapActions('questionStore', ['addQuestion']),
    submit() {
      var content = this.$refs.toastuiEditor.invoke("getMarkdown")
      if (this.mainCategory === "") {
        alert('대분류를 선택해주세요')
      } else if (this.subCategory === "") {
        alert('소분류를 선택해주세요')
      } else if (this.keyword === "") {
        alert('키워드를 선택해주세요')
      } else if (this.title === "") {
        alert('제목을 입력해주세요')
      } else if (content === "") {
        alert('질문의 내용을 입력해주세요')
      } else {
        var obj = new Object()
        obj.title = this.title 
        obj.mainCategory = this.mainCategory
        obj.subCategory = this.subCategory
        obj.keyword = this.keyword
        obj.author = this.author 
        obj.content = content
        this.addQuestion(obj)
      }
    }
  },
}
</script>

<style scoped>
.QnA-title {
  border: 1px solid black ;
  width: 100%;
  height: 5vh;
}

button {
  padding: 10px;
  border-radius: 15px;
  background-color: #67d5b5;
  color: white;
}
</style>