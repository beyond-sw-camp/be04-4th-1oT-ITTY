<template>
    <div class="user-info-window">
      <br>
      <div class="user-detail">
        <label>이름:  </label>
        <span>{{ userInfo.name }}</span>
      </div>
      <br>
      <br>
      <br>
      <div class="user-detail">
        <label>전화번호:  </label>
        <span>{{ userInfo.phoneNumber }}</span>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  
  const userInfo = ref({
    name: '테스트 탈퇴',
    phoneNumber: '010-1234-5678'
  });
  </script>
  
  <style scoped>
    .user-info-window {
  border: 1px solid #dee2e6; /* Light grey border */
  border-radius: 8px;
  padding: 20px;
  max-width: 1000px;
  margin: 40px auto; /* Centers the box and gives some space from the top */
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
  min-width: 80px; /* Gives labels a consistent width */
  font-weight: bold;
  color: #495057; /* Dark grey color for text for better readability */
}

.user-detail span {
  font-weight: normal;
  color: #212529; /* Even darker color for contrast */
  margin-left: 0.5rem; /* Space between label and value */
}
  </style>