<template>
<MainHeader/>

    <div class="new-post-container" style="margin-top: 10%;">
      <form @submit.prevent="submitPost">
        <div>
          <label for="title">제목:</label>
          <input type="text" id="title" v-model="postForm.title">
        </div>
        <div>
          <label for="content">내용:</label>
          <textarea id="content" v-model="postForm.content"></textarea>
        </div>
        <div>
          <label for="photos">사진 등록:</label>
          <input type="file" id="photos" @change="handleFileUpload" multiple>
        </div>
        
        <button type="submit" @click="testPost">게시글 작성</button>
      </form>
    </div>

    <MainFooter/>
  </template>
  
  <script setup>

import MainHeader from '@/components/Header.vue';
import MainFooter from '@/components/Footer.vue';

import { reactive, ref } from 'vue';
import { useRouter } from 'vue-router';


  const postForm = reactive({
    title: '',
    content: '',
    photos: [],
  });
  
  const router = useRouter();
  
  
  function handleFileUpload(event) {
    postForm.photos = Array.from(event.target.files);
  }
  
  function submitPost() {
    console.log('게시글 데이터:', postForm);
    // 게시글 데이터를 서버에 전송하거나 저장하는 로직을 여기에 추가
  }
  
  function testPost () {
    alert('게시글이 등록되었습니다.');
    router.push('/free-board')
  }
  </script>
  
  <style scoped>
.new-post-container {
  box-sizing: border-box;
  width: 100%;
  max-width: 700px;
  margin: 40px auto;
  padding: 20px;
  background-color: #f9f9f9;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  font-family: 'KCC-Hanbit', sans-serif;
}

.new-post-container form {
  display: flex;
  flex-direction: column;
}

.new-post-container form div {
  margin-bottom: 15px;
}

.new-post-container form label {
  display: block;
  margin-bottom: 5px;
  font-size: 16px;
  font-weight: bold;
  color: #333;
}

.new-post-container form input,
.new-post-container form select,
.new-post-container form textarea {
  font-family: 'KCC-Hanbit';
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
  color: #333;
}

.new-post-container form button {
  font-family: 'KCC-Hanbit';
  padding: 10px 20px;
  background-color: #ffe8a9;
  color: #ffffff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
}

.new-post-container form button:hover {
  background-color: #e7b344;
}

#content {
  width: 100%;
  height: 400px;
}
  
  </style>
  