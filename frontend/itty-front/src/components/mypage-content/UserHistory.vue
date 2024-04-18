<template>

  <div class="container-tab">
    <ul class="nav nav-tabs menu-nav">
      <li class="nav-item menu-item">
        <button id="likeReplyTab" type="button" class="nav-link menu-item-button active" @click="onClickTab">좋아요 한 댓글</button>
        <div class="under-line active"></div>
      </li>
      <li class="nav-item menu-item">
        <button id="likePostTab" type="button" class="nav-link menu-item-button" @click="onClickTab">좋아요 한 게시글</button>
        <div class="under-line"></div>
      </li>
      <li class="nav-item menu-item">
        <button id="replyTab" type="button" class="nav-link menu-item-button" @click="onClickTab">작성한 댓글</button>
        <div class="under-line"></div>
      </li>
      <li class="nav-item menu-item">
        <button id="postTab" type="button" class="nav-link menu-item-button" @click="onClickTab">작성한 게시글</button>
        <div class="under-line"></div>
      </li>
    </ul>
  </div>
  
  <div class="container-tab-content-outer">
    <div class="container-tab-content">

      <template v-if="selectedTab === 'likeReplyTab'">
        <div v-for="likeReply in likeReplyList" :key="likeReply.replyCodePk" class="user-info-window">
          <div class="user-detail">
            <label>댓글 내용:</label>
            <span>{{ likeReply.replyContent }}</span>
          </div>
          <div class="user-detail">
            <label>게시글 번호:</label>
            <span>{{ likeReply.articleCodeFk }}</span>
          </div>
        </div>
      </template>

      <template v-else-if="selectedTab === 'likePostTab'">
        <div v-for="likePost in likePostList" :key="likePost.articleCodePk" class="user-info-window">
          <div class="user-detail">
            <label>제목:</label>
            <span>{{ likePost.articleTitle }}</span>
          </div>
          <div class="user-detail">
            <label>내용:</label>
            <span>{{ likePost.articleContent }}</span>
          </div>
        </div>
      </template>

      <template v-else-if="selectedTab === 'replyTab'">
        <div v-for="reply in replyList" :key="reply.replyCodePk" class="user-info-window">
          <div class="user-detail">
            <label>댓글 내용:</label>
            <span>{{ reply.replyContent }}</span>
          </div>
          <div class="user-detail">
            <label>게시글 번호:</label>
            <span>{{ reply.articleCodeFk }}</span>
          </div>
        </div>
      </template>

      <template v-else>
        <div v-for="post in postList" :key="post.articleCodePk" class="user-info-window">
          <div class="user-detail">
            <label>제목:</label>
            <span>{{ post.articleTitle }}</span>
          </div>
          <div class="user-detail">
            <label>내용:</label>
            <span>{{ post.articleContent }}</span>
          </div>
        </div>
      </template>

    </div>
  </div>
</template>
  
<script setup>
  import { ref, inject, onMounted } from 'vue';

  import * as api from '@/api/api.js';
  
  const selectedTab = ref('likeReplyTab');
  const likeReplyList = ref([]);
  const likePostList = ref([]);
  const replyList = ref([]);
  const postList = ref([]);

  const userInfo = inject('userInfo');

  const loginInfo = JSON.parse(window.localStorage.getItem('loginInfo'));

  api.getUserLikeList(
    loginInfo.userCode,
    (response) => {
      const likedContentObj = response.data;
      likeReplyList.value = likedContentObj.likedReplyList;
      likePostList.value = likedContentObj.likedArticleList;
    },
    (error) => {
      console.log(error);
    }
  )

  api.getUserReplyList(
    loginInfo.userCode,
    (response) => {
      replyList.value = response.data;
    },
    (error) => {
      console.log(error);
    }
  )

  api.getUserArticleList(
    loginInfo.userCode,
    (response) => {
      postList.value = response.data;
    },
    (error) => {
      console.log(error);
    }
  )

  function onClickTab(e) {
    const buttons = document.querySelectorAll('.menu-item-button');

    for (let i = 0; i < buttons.length; i++) {
      buttons[i].classList.remove('active');
      buttons[i].nextSibling.classList.remove('active');
    }

    e.target.classList.add('active');
    e.target.nextSibling.classList.add('active');

    selectedTab.value = e.target.id;
  }

</script>
  
<style scoped>
  .user-info-window {
    border: 1px solid #dee2e6; /* Light grey border */
    border-radius: 8px;
    padding: 20px;
    max-width: 1000px;
    /*margin: 40px auto;*/ /* Centers the box and gives some space from the top */
    background-color: #f8f9fa; /* Light background */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05); /* Subtle shadow */
  }

  .user-detail {
    display: flex;
    align-items: center;
    justify-content: flex-start; /* Aligns content to the left */
    margin-bottom: 1rem; /* Provides consistent margin to the bottom */
    font-size: 1rem; /* Sets a readable font size */
  }

  .user-detail label {
    /*min-width: 80px;*/ /* Gives labels a consistent width */
    font-weight: bold;
    color: #495057; /* Dark grey color for text for better readability */
  }

  .user-detail span {
    font-weight: normal;
    color: #212529; /* Even darker color for contrast */
    margin-left: 1rem; /* Space between label and value */
  }

  .container-tab {
    margin: 40px auto;
  }

  .fixed-container-grid {
    margin-left: auto;
    margin-right: auto;
    display: grid;
    width: 1024px;
    grid-template-columns: repeat(12, minmax(0, 1fr));
    -moz-column-gap: 3rem;
    column-gap: 3rem;
    row-gap: 2rem;
    padding-left: 1.5rem;
    padding-right: 1.5rem;
  }

  .menu-nav {
    display: flex;
    grid-column-start: 3;
    grid-column: span 8 / span 8;
    list-style: none;
    margin: 0;
    padding: 0;
  }

  .menu-item {
    flex: 1 1 0%;
    display: inline-block;
    position: relative;
  }

  .menu-item-button {
    cursor: pointer;
    font-weight: 700;
    font-size: .875rem;
    padding-top: 1rem;
    padding-bottom: 1rem;
    padding-left: 1.5rem;
    padding-right: 1.5rem;
    background-color: var(--color-white, #fff);
    width: 100%;
    border: 0;
    background: none;
    overflow: visible;
    margin: 0;
    font-family: inherit;
    line-height: inherit;
    border-radius: 0;
  }

  .menu-item-button:not(.active) {
    color: #666;
  }

  .under-line {
    opacity: 0;
    background-color: #000;
    width: 100%;
    height: .125rem;
    bottom: 0;
    position: absolute;
  }

  .under-line.active {
    opacity: 1;
  }

  .container-tab-content-outer {
    border-style: solid;
    border-top-width: 1px;
    border-width: 0;
  }

  .container-tab-content {
    flex-direction: column;
    display: flex;
    margin: 1.25rem 0;
    gap: 1rem;
  }

</style>