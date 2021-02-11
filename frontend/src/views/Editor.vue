<template>
  <div>
    <input 
      class="QnA-title"
      v-model="title" 
      placeholder="제목을 작성해주세요."
    >
    <editor 
      ref="toastuiEditor" 
      :initialValue="editorText"
      :options="editorOptions"
      height="500px"
      initialEditType="wysiwyg"
      previewStyle="vertical"
    />
    <button @click="submit" >저장하기</button>
  </div>
</template>

<script>
import 'codemirror/lib/codemirror.css';
import '@toast-ui/editor/dist/toastui-editor.css';

import { Editor } from '@toast-ui/vue-editor';

export default {
  name: 'Editor',
  components: {
    editor: Editor
  },
  data() {
    return {
      editorText: '질문을 작성해주세요.',
      editorOptions: {
        hideModeSwitch: true
      },
      title: "",
    }
  },
  methods: {
    submit() {
      var content = this.$refs.toastuiEditor.invoke("getMarkdown")
      console.log(content)
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

</style>