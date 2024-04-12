<template>
    <MainHeader/>
    <div class="article-container">
      <div class="article-header">
        <h1>{{ article.title }}</h1>
        <span class="author">{{ article.author }}</span>
      </div>
      <hr>
      <p>{{ article.content }}</p>
      <div style="margin-left: 43%;">
    </div>
      <div margin-left="43%">
      <button @click="likeArticle">좋아요 {{ article.likes }}</button>
      </div>
      <hr>
      <h2>댓글</h2>
        <div v-for="comment in comments" :key="comment.id" class="comment">
        <p>{{ comment.text }}</p>
        <button @click="likeComment(comment)">좋아요 {{ comment.likes }}</button>
        </div>  
    
      <div class="comment-form">
        <input type="text" v-model="newComment" placeholder="댓글을 입력하세요">
        <button @click="addComment">댓글 추가</button>
      </div>
    </div>
    <MainFooter/>
</template>

<script setup>
import MainHeader from '@/components/Header.vue';
import MainFooter from '@/components/Footer.vue';
import { ref } from 'vue';

const article = ref({
  title: '제목',
  content: '내용',
  author: '작성자닉네임',
  likes: 4,
  comments : 'dfdf',
});
  
  // 아래 axios를 쓸 땐 <script setup>에서 setup을 빼야함

  /*
  import axios from 'axios';
  
  export default {
    data() {
      return {
        article: {
          id: this.$route.params.id,
          title: '',
          content: '',
          likes: 0
        },
        comments: [],
        newComment: ''
      };
    },
    created() {
      this.fetchArticle();
      this.fetchComments();
    },
    methods: {
      fetchArticle() {
        axios.get(`/api/articles/${this.article.id}`)
          .then(response => {
            this.article = {...this.article, ...response.data};
          })
          .catch(error => console.error("Error fetching article:", error));
      },
      fetchComments() {
        axios.get(`/api/articles/${this.article.id}/comments`)
          .then(response => {
            this.comments = response.data;
          })
          .catch(error => console.error("Error fetching comments:", error));
      },
      likeArticle() {
        this.article.likes++;
        // Update the likes on the server
        axios.post(`/api/articles/${this.article.id}/like`);
      },
      likeComment(comment) {
        comment.likes++;
        // Update the likes on the server
        axios.post(`/api/comments/${comment.id}/like`);
      },
      addComment() {
        const newCommentData = {
          text: this.newComment,
          likes: 0
        };
        axios.post(`/api/articles/${this.article.id}/comments`, newCommentData)
          .then(response => {
            this.comments.push(response.data);
            this.newComment = ''; // Reset input field after posting
          })
          .catch(error => console.error("Error posting comment:", error));
      }
    }
  };
  */
  </script>
  
  <style scoped>
.article-container {
  margin-top: 10%;
  margin-left: 25%;
  margin-bottom: 5%;
  max-width: 800px;
  align-content: center;
  padding: 30px;
  background: #ffffff;
  border-radius: 12px;
  box-shadow: 0 6px 20px rgba(0, 0, 0, 0.05);
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
  line-height: 1.6;
}

h1 {
  color: #2c3e50;
  font-size: 24px;
  margin-bottom: 20px;
}

h2 {
  color: #34495e;
  font-size: 20px;
  border-bottom: 2px solid #ecf0f1;
  padding-bottom: 10px;
  margin-top: 40px;
  margin-bottom: 20px;
}

p {
  color: #7f8c8d;
}

button {
  font-size: 16px;
  border-radius: 6px;
  padding: 10px 20px;
  background-color: #4c606d;
  color: #ffffff;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
}

button:hover {
  background-color: #b1e0ff;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.comment {
  background: #ecf0f1;
  border-radius: 8px;
  padding: 15px;
  margin-top: 10px;
  position: relative;
}

.comment::before {
  content: '';
  position: absolute;
  left: 10px;
  top: -5px;
  width: 50px;
  height: 2px;
  background: #465f70;
}

.comment-form {
  display: flex;
  margin-top: 20px;
}

.comment-form input, .comment-form button {
  height: 40px;
}

.comment-form input {
  flex: 1;
  border: 1px solid #bdc3c7;
  border-radius: 6px;
  padding: 0 15px;
  margin-right: 10px;
}

.comment-form button {
  width: auto;
  padding: 0 20px;
  background-color: #000000;
  transition: background-color 0.3s;
}

.comment-form button:hover {
  background-color: #a5a5a5;
}

.author {
  color: #7f8c8d;
  font-size: 18px;
  display: flex;
  margin-right: 0; /* Right align the author name */
  justify-content: flex-end;
}

</style>