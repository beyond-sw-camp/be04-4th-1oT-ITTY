<template>
  <div>
  <MainHeader/>
  
    <div class="article-container">
      <div class="article-header">
        <h1>{{ article.articleTitle }}</h1>
        <span class="author">{{ userNickname }}</span>
      </div>
      <hr>
      <div class="article-content">
      <p>{{ article.articleContent }}</p>
      </div>
      <div margin-left="43%">
     <button type="button" :class="{ liked: article.likedByUser, unliked: !article.likedByUser }" @click="likeArticle">좋아요 {{ article.likes }}</button>
      </div>
      <hr>
      <h2>댓글</h2>
        <div v-for="comment in comments" :key="comment.id" class="comment">
        <div class="comment-writer"><p>{{ comment.userCodeFk }}</p></div>
        <p>{{ comment.replyContent }}</p>
        <button @click="likeComment(comment)">좋아요 {{ comment.likes }}</button>
        </div>  
    
      <div class="comment-form">
        <input type="text" v-model="newComment" placeholder="댓글을 입력하세요">
        <button @click="addComment">댓글 추가</button>
      </div>
    </div>
  
  <MainFooter/>
</div>
</template>

<script setup>

import MainHeader from '@/components/Header.vue';
import MainFooter from '@/components/Footer.vue';

import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import * as api from '@/api/api.js';


const article = ref('');
const comments = ref([]);
const likedArticlesResponse = ref();
const newComment = ref('');
const userNickname = ref('');

const route = useRoute();

onMounted(async () => {
  try {
    userNickname.value = route.params.nickname;

    const articleCodePk = route.params.id;
    const userCode = 1; // 사용자 코드 설정

    const articleResponse = await api.fetchArticleById(articleCodePk);

    if (articleResponse && articleResponse.articleTitle) {
      article.value = {...article.value, ...articleResponse};
    } else {
      console.error('Invalid article data:', articleResponse);
    }

    const likedArticlesResponse = await api.fetchArticlesLikedByUser(userCode);
    console.log("맞냐?" + likedArticlesResponse.likedArticleDTOList[0].articleCodePk);
    if (Array.isArray(likedArticlesResponse.likedArticleDTOList)) {
      const isLiked = likedArticlesResponse.likedArticleDTOList.some(a => a.articleCodePk === articleCodePk);
    
      console.log("화깅ㄴ" + isLiked)
      article.value.likedByUser = isLiked;
    } else {
      console.error('계속 생기는 오류 Invalid liked articles data:', likedArticlesResponse);
    }
  } catch (error) {
    console.error('Failed to fetch data:', error);
  }
});

const likeArticle = async () => {
  console.log(article.value);
  if (article.value) {
    const userCode = 1;  // 실제 로그인된 사용자 ID로 변경 필요
    try {
      console.log(article.value.likedByUser)
      if (article.value.likedByUser) {
        const response = await api.deleteArticleLike(article.value.articleCodePk, userCode);
        if (response && response.message.includes('successfully')) {
          article.value.likedByUser = false;
          article.value.likes--;
        }
      } else {
        const response = await api.addArticleLike(article.value.articleCodePk, userCode);
        if (response && response.message.includes('successfully')) {
          article.value.likedByUser = true;
          article.value.likes++;
        }
      }
    } catch (error) {
      console.error('Failed to toggle like:', error);
    }
  }
};

const likeComment = (comment) => {
  if (!comment.likes) {
    comment.likes = 0;
  }
  comment.likes++;
  // 서버에 좋아요 상태 업데이트를 요청하는 API 호출을 추가할 수 있습니다.
};

const addComment = async () => {
    if (newComment.value.trim()) {
        const newCommentObj = {
            replyContent: newComment.value,
            userCodeFk: article.value.userCodeFk,
            articleCodeFk: article.value.articleCodePk
        };
        try {
            const response = await api.addCommentAPI(newCommentObj);
            if (response.resultCode === 201) {
                console.log('댓글 등록 성공:', response.message);
                console.log(response);
                comments.value.push({
                    id: response.commentId || Date.now(), // 서버에서 ID를 반환하면 사용, 그렇지 않으면 임시 ID 사용
                    userCodeFk: 1,
                    replyContent: newComment.value,
                  
                });
                newComment.value = ''; // 입력 필드 초기화
            } else {
                console.error('댓글 등록 실패:', response.message);
            }
        } catch (error) {
            console.error('Failed to add comment:', error);
        }
    }
};
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

.article-content {
  height: 200px;
}

.comment-writer {
  text-align: right;
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

.liked {
  background-color: #ff6347; 
}

.unliked {
  background-color: #4c606d;
}

</style>