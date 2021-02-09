<template>
  <div class="home">
    <!-- Q & A 리스트 -->
    <div class="col-9">
      <v-card
      :loading="loading"
      class="mx-auto my-12"
      width="100%"
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
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home',
}
</script>

<style scoped>

</style>


