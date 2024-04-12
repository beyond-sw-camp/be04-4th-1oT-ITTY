<template>
  <div class="user-profile-update">
    <h3>정보 수정</h3>
    <form @submit.prevent="updateProfile">
      <div class="form-group">
        <label for="email">Email(ID):</label>
        <input type="email" id="email" v-model="user.email" disabled>
      </div>
      <div class="form-group">
        <label for="password">Password(비밀번호):</label>
        <input type="password" id="password" v-model="user.password"><br><br>
        <input type="password" id="passwordConfirm" placeholder="비밀번호 확인" v-model="passwordConfirm">
      </div>
      <div class="form-group">
        <label for="name">Name(이름):</label>
        <input type="text" id="name" v-model="user.name">
      </div>
      <div class="form-group">
        <label for="nickname">Nickname(닉네임):</label>
        <input type="text" id="nickname" v-model="user.nickname">
      </div>
      <div class="form-group">
        <label for="address">Address(주소):</label>
        <input type="text" id="address" v-model="user.address">
      </div>
      <div class="form-group">
        <label for="profileImage">Image(프로필 이미지):</label>
        <input type="file" id="profileImage" @change="onFileChange">
      </div>
      <div class="form-group">
        <label for="phonenumber">Phone Number(전화번호):</label>
        <input type="tel" id="phonenumber" v-model="user.phonenumber">
      </div>
      <button type="submit" class="update-button">정보 수정</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        email: 'user@example.com',
        password: '',
        name: '',
        nickname: '',
        address: '',
        profileImage: null,
        phonenumber: ''
      },
      passwordConfirm: '',
      originalUserData: {}
    };
  },
  created() {
    this.originalUserData = {...this.user}; // 초기 데이터 복사
  },
  methods: {
    onFileChange(e) {
      const file = e.target.files[0];
      this.user.profileImage = file;
    },
    updateProfile() {
      if (this.user.password && this.user.password !== this.passwordConfirm) {
        alert('비밀번호가 일치하지 않습니다.');
        return;
      }
      const hasChanges = Object.keys(this.user).some(key => {
        if (key === 'profileImage') {
          return this.user[key] !== this.originalUserData[key];
        }
        return this.user[key] && this.user[key] !== this.originalUserData[key];
      });
      
      // API 호출을 통해 사용자 정보 업데이트 로직을 구현하세요
      console.log('Updated user profile:', this.user);
      alert('회원 정보가 성공적으로 수정되었습니다.');
    }
  }
};
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
