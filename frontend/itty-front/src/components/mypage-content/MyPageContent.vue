<template>
  <div class="userInfo">
    <div id="all" @click="changeUserInfo('')" :class="{All: activeUserInfo == ''}" >내 정보</div><hr><br>
    <div id="scrap" @click="changeUserInfo(1)" :class="{Scrap: activeUserInfo == 1}">스크랩</div><hr><br>
    <div id="history" @click="changeUserInfo(2)" :class="{History: activeUserInfo == 2}">활동 내역</div><hr><br>
    <div id="modifyUser" @click="changeUserInfo(3)" :class="{ModifyUser: activeUserInfo == 3}">회원 정보 수정</div><hr><br>
    <div id="qna" @click="changeUserInfo(4)" :class="{QnA: activeUserInfo == 4}">문의</div><hr><br>
    <div id="signout" @click="changeUserInfo(5)" :class="{Signout: activeUserInfo == 5}">회원탈퇴</div><hr><br>
  </div>
</template>

<script setup>
    import { defineEmits, ref } from 'vue';
    import { useRouter } from "vue-router";

    const emit = defineEmits(['change']);
    const activeUserInfo = ref('');

function changeUserInfo(userInfo) {
  activeUserInfo.value = userInfo;
  emit('change', userInfo);

  switch (userInfo) {
    case '':
      router.replace('/mypage'); // '내 정보'에 해당하는 라우트로 변경
      break;
    case 1:
      router.replace('/mypage/userscrap'); // '스크랩'에 해당하는 라우트로 변경
      break;
    case 2:
      router.replace('/mypage/userhistory'); // '활동 내역'에 해당하는 라우트로 변경
      break;
    case 3:
      router.replace('/mypage/modifyuserinfo'); // '회원 정보 수정'에 해당하는 라우트로 변경
      break;
    case 4:
      router.replace('/mypage/userqna'); // '문의'에 해당하는 라우트로 변경 (QnA라는 라우트가 정의되어 있어야 함)
      break;
    case 5:
      router.replace('/mypage/usersignout'); // '회원탈퇴'에 해당하는 라우트로 변경
      break;
  }
}

const router = useRouter();
</script>

<style scoped>
    @import './mypage.css';
</style>