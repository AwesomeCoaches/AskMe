<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot name="header">
              <div class="d-flex justify-content-between w-100">
                <h5>답변을 작성해주세요</h5>
                <button class="modal-default-button" @click="$emit('close')">
                  닫기
                </button>
              </div>
              
            </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
              <editor 
                ref="toastuiEditor"
                :options="editorOptions"
                height="300px"
                initialEditType="wysiwyg"
                previewStyle="vertical"
                placeholder="내용입니다."
              />
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              <button class="modal-default-button" @click="clickSubmit()">
                제출하기
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import 'codemirror/lib/codemirror.css';
import '@toast-ui/editor/dist/toastui-editor.css';

import { Editor } from '@toast-ui/vue-editor';
import { mapState, mapActions } from 'vuex'



export default {
    name: 'Modal',
    components: {
      editor: Editor
    },
    computed: {
      ...mapState(['userInfo']),
    },
    methods: {
      ...mapActions(['getInfo']),
      ...mapActions('questionStore', ['addAnswer']),
      clickSubmit() {
        let answerData = {
          author: this.userInfo.name,
          qid: this.$route.params.qid ,
          content: this.$refs.toastuiEditor.invoke("getHtml")
        }
        this.addAnswer(answerData)
        this.$emit('close')
      }
    },
    created() {
      this.getInfo()
    }
}
</script>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 500px;
  margin: 100px auto;
  padding: 10px 15px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
}

.modal-header h5 {
  margin: 0;
  color: #42b983;
}

.modal-default-button {
  float: right;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}

</style>