<template>
    <div class="user-profile">
      <div class="avatar"></div>
      <div class="info">
        <h1 class="Nickname">테스트</h1>
        <div class="counts">
          <div class="count">
            <span class="label">팔로우</span>
            <span class="number">0</span>
          </div>
          <div class="count">
            <span class="label">팔로잉</span>
            <span class="number">0</span>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  // 여기에 JavaScript 또는 Vue 로직을 추가할 수 있습니다.
  </script>
  
  <style scoped>
.user-profile {
  display: flex;
  align-items: center;
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
}

.avatar {
  flex-shrink: 0;
  width: 150px;
  height: 150px;
  background-color: #bbb; /* 실제 이미지 URL로 변경해주세요 */
  border-radius: 50%;
  margin-right: 25px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.info {
  flex-grow: 1;
}

.Nickname {
  font-size: 1.8rem;
  font-weight: 600;
  color: #333;
  margin-bottom: 10px;
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