<template>
  <div class="user-profile">
    <div class="avatar"></div>
    <div class="profile-info">
      <div class="upper-info">
        <h1 class="Nickname">{{ userInfo.userNickname }}</h1>
        <div class="counts">
          <div class="count">
            <span class="label">팔로우</span>
            <span class="number">{{ userInfo.followers || 0 }}</span>
          </div>
          <div class="count">
            <span class="label">팔로잉</span>
            <span class="number">{{ userInfo.following || 0 }}</span>
          </div>
        </div>
      </div>
      <div class="bio">
        <p>{{ userInfo.userIntroduction }}</p>
      </div>
    </div>
  </div>
</template>
  
  <script setup>
  import { ref, onMounted } from 'vue';

  import * as api from '@/api/api.js';

onMounted(() => {
  api.findUserByUserCode(
    1,
    function(response) {
      
      console.log(response);
      
      userInfo.value = response.data;
    },
    function(error) {
      console.log(error);
    }
  )

});

const userInfo = ref({});
  </script>
  
  <style scoped>
.user-profile {
  display: flex;
  align-items: flex-start; /* 아바타와 나머지 정보를 상단 정렬로 조정 */
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
}

.profile-info {
  display: flex;
  flex-direction: column;
  width: 75%;
  margin-left: 20px; /* 아바타와 나머지 정보 사이 간격 조정 */
}

.upper-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 20px;
  margin-bottom: 15px; /* 닉네임/팔로우 정보와 소개글 사이 간격 조정 */
}

.avatar {
  width: 150px;
  height: 150px;
  background-color: #bbb;
  border-radius: 50%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.bio {
  font-size: 10pt;
  color: #666;
}

  
  .Nickname {
    font-size: 1.8rem;
    font-weight: 600;
    color: #333;
  }
  
  .counts {
    display: flex;
    align-items: center;
  }
  
  .count {
    display: flex;
    align-items: center;
    margin-right: 25px;
    font-weight: 500;
  }
  
  .label {
    font-size: 1rem;
    color: #555;
    margin-right: 8px;
  }
  
  .number {
    font-size: 1.2rem;
    color: #222;
  }
  </style>
  