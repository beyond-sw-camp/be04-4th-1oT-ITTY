<template>
  <div class="user-profile-update">
    <h3>정보 수정</h3>
    <form @submit.prevent="updateProfile">
      <div class="form-group">
        <label for="email">Email(ID):</label>
        <input type="email" id="email" v-model="userInfo.userEmail" disabled>
      </div>
      <div class="form-group">
        <label for="password">Password(비밀번호):</label>
        <input type="password" id="password" v-model="newPassword"><br><br>
        <input type="password" id="passwordConfirm" placeholder="비밀번호 확인" v-model="passwordConfirm">
      </div>
      <div class="form-group">
        <label for="name">Name(이름):</label>
        <input type="text" id="name" v-model="userInfo.userName">
      </div>
      <div class="form-group">
        <label for="nickname">Nickname(닉네임):</label>
        <input type="text" id="nickname" v-model="userInfo.userNickname">
      </div>
      <div class="form-group">
        <label for="nickname">Introduce(소개글):</label>
        <input type="text" id="introduce" v-model="userInfo.userIntroduction">
      </div>
      <div class="form-group">
        <label for="profileImage">Image(프로필 이미지):</label>
        <input type="file" id="profileImage" @change="onFileChange">
      </div>
      <div class="form-group">
        <label for="phonenumber">Phone Number(전화번호):</label>
        <input type="tel" id="phonenumber" v-model="userInfo.userPhoneNumber">
      </div>
      <button type="submit" class="update-button">정보 수정</button>
    </form>
  </div>
</template>

<script setup>
  import { ref, onMounted, inject } from 'vue';
  import * as api from '@/api/api.js';

  const userInfo = inject('userInfo');
  const newPassword = ref("");
  const passwordConfirm = ref("");


  function updateProfile() {
    // 비밀번호 입력값 업데이트
    userInfo.value.userPassword = newPassword.value;

    // 비밀번호 일치 검사
    if (newPassword.value !== passwordConfirm.value) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    // API 호출로 사용자 정보 업데이트
    api.modifyUserInfo(
      userInfo.value,
      (response) => {
        alert("사용자 정보가 성공적으로 업데이트되었습니다.");
        console.log(response);
      },
      (error) => {
        console.error('Error updating user info:', error);
      }
    );
  }

  function onFileChange(event) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        userInfo.value.profileImage = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  }
</script>

<style scoped>
  .user-profile-update {
    max-width: 100%;
    margin: 5px;
    padding: 20px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    border-radius: 8px;
  }

  .form-group {
    margin-bottom: 20px;
  }

  label {
    display: block;
    margin-bottom: 5px;
  }

  input[type="email"],
  input[type="password"],
  input[type="text"],
  input[type="url"],
  input[type="tel"],
  input[type="file"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  .update-button {
    background-color: #585167;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
  }

  .update-button:hover {
    background-color: #3f3c44;
  }
</style>
