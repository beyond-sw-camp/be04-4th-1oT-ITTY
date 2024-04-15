<template>
    
    <MainHeader/>
    
    <body>
    <div class="board-container">
    <h1>자유게시판</h1>
    <table class="board-table">
      <thead>
        <tr>
          <th style="width: 150px;">날짜</th>
          <th style="width: 400px;">제목</th>
          <th>작성자</th>
          <th>조회</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="post in posts" :key="post.id">
          <td>{{ post.date }}</td>
          <td>{{ post.title }}</td>
          <td>{{ post.author }}</td>
          <td>{{ post.views }}</td>
        </tr>
      </tbody>
    </table>
    <div class="createPost" style="text-align: right;">
      <button type="submit" class="create-btn" @click="createPost">글 작성</button>
    </div>
    <div class="controls">
            <select v-model="searchOption" class="search-select">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="title_content">제목+내용</option>
                <option value="author">작성자</option>
            </select>
      <input v-model="searchQuery" type="text" placeholder="검색..." class="search-input">
      <button @click="searchPost" class="write-btn">검색</button>
    </div>
  </div>
</body>
    <MainFooter/>
  </template>
  
  <script setup>

  import MainHeader from '@/components/Header.vue';
  import MainFooter from '@/components/Footer.vue';

  import { useRouter } from "vue-router";

  import { ref } from 'vue';

  const router = useRouter();

  const posts = ref([
    // 예시 게시글 데이터
    { id: 1, title: '게시글 제목 1', author: '작성자1', date: '2024-01-01', views: 100 },
    { id: 2, title: '게시글 제목 2', author: '작성자2', date: '2024-01-02', views: 150 },
    // 추가 게시글 데이터...
  ]);

  const searchQuery = ref('');

  const searchPost = () => {
    alert('검색창 구현 예정');
  };

  const createPost = () => {
    router.push('/free-board/new');
  };

  const searchOption = ref('title'); // 기본 검색 옵션

  </script>
  
  <style>
/*
.board-container {
  width: 800px;
  margin: 0 auto;
  text-align: center;
}

.board-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.board-table th, .board-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

.board-actions {
  margin-top: 20px;
}

input[type="text"] {
  width: 70%;
  padding: 10px;
}

button {
  padding: 10px 20px;
}
*/

/* 기본 마진과 패딩을 제거하여 더 깔끔한 레이아웃을 구성 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* 전체 폰트 설정을 좀 더 세련된 것으로 변경 */
body {
  font-family: 'SejonghospitalBold', Tahoma, Geneva, Verdana, sans-serif;
  background-color: #ffffff;
  color: #333;
}

.board-container {
  max-width: 850px;
  margin: 20px auto 20px auto;
  background: #fff;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  margin-top: 150px; 
}

/* 테이블 스타일을 좀 더 현대적으로 만듦 */
.board-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.board-table th, .board-table td {
  border: 1px solid #ddd;
  padding: 12px;
  text-align: center;
}

.board-table th {
  background-color: #ffe693;
  color: black;
  text-transform: uppercase;
}

.board-table tr:nth-child(even) {
  background-color: #f2f2f2;
}

/* 호버 효과를 추가하여 상호작용성을 높임 */
.board-table tr:hover {
  background-color: #ddd;
  cursor: pointer;
}

/* 컨트롤 박스 스타일을 개선 */
.controls {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
  height: 50px;
}

.search-input {
  width: calc(100% - 230px);
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  margin-right: 10px;
}

.write-btn {
  padding: 10px 20px;
  background-color: #ffe693;
  border: none;
  color: black;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.write-btn:hover {
  background-color: #ffc400;
}

.create-btn {
  margin: 10px;
  padding: 10px 20px;
  background-color: #b8b8b8;
  border: none;
  color: black;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.create-btn:hover {
  background-color: #ffc400;
}

.search-select {
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        margin-right: 10px;
        background-color: white;
        cursor: pointer;
    }
  </style>
  