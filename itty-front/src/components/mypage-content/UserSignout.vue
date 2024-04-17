<template>
  <div class="container">
    <button class="delete-button" @click="showModal = true">회원 탈퇴</button>
    <div v-if="showModal" class="modal">
      <div class="modal-content">
        <span @click="showModal = false" class="close">&times;</span>
        <p>정말로 탈퇴하시겠습니까?</p>
        <form @submit.prevent="submitDeletion">
          <input type="email" v-model="email" placeholder="이메일" required><br><br>
          <input type="password" v-model="password" placeholder="비밀번호" required><br><br>
          <button type="submit" class="submit-button">탈퇴하기</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>

  import { ref, onMounted, inject } from 'vue';
  import { useRouter } from 'vue-router';
  
  import * as api from '@/api/api.js';

  const router = useRouter();

  const userInfo = inject('userInfo');

  const showModal = ref(false);
  const email = ref('');
  const password = ref('');

  const loginInfo = JSON.parse(window.localStorage.getItem('loginInfo'));

  function submitDeletion() {
    console.log(userInfo.value);
    console.log(email.value);
    console.log(password.value);

    if (userInfo.value.userEmail != email.value) {
      alert('이메일이 일치하지 않습니다.');
      return;
    }

    const withdrawalUserInfo = {
      userEmail: email.value,
      userPassword: password.value
    }

    api.withdrawal(
      withdrawalUserInfo,
      (response) => {
        console.log(response);

        if (response.status == 200) {
          showModal.value = false;
          email.value = '';
          password.value = '';

          window.localStorage.removeItem('loginInfo');
          router.replace('/');

          alert('탈퇴 처리가 완료되었습니다.');
        } else {
          alert('탈퇴 실패');  
        }
      },
      (error) => {
        console.log(error);
        alert('탈퇴 실패');
      }
    )
  }
</script>

<style scoped>
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50vh; /* Full viewport height */
  }

  .delete-button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #dc3545; /* Bootstrap danger color */
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .delete-button:hover {
    background-color: #c82333; /* Darken on hover */
  }

  .modal {
    display: block;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.4);
  }

  .modal-content {
    background-color: #fefefe;
    margin: 15% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 30%;
  }

  .close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }

  .close:hover,
  .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }

  .submit-button {
    padding: 10px 20px;
    font-size: 16px;
    color: white;
    background-color: #ffd13a; /* Bootstrap primary color */
    border: none;
    border-radius: 5px;
  }

  .submit-button:hover {
    background-color: #ca4747; /* Darken on hover */
  }
</style>
