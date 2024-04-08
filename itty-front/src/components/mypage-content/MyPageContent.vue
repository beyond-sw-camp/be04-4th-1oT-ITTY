<template>
  <div class="userInfo">
    <div id="All" @click="changeUserInfo('')" :class="{All: activeUserInfo == ''}" >내 정보</div><hr><br>
    <div id="Scrap" @click="changeUserInfo(1)" :class="{Scrap: activeUserInfo == 1}">스크랩</div><hr><br>
    <div id="History" @click="changeUserInfo(2)" :class="{History: activeUserInfo == 2}">활동 내역</div><hr><br>
    <div id="ModifyUser" @click="changeUserInfo(3)" :class="{ModifyUser: activeUserInfo == 3}">회원 정보 수정</div><hr><br>
    <div id="QnA" @click="changeUserInfo(4)" :class="{QnA: activeUserInfo == 4}">문의</div><hr><br>
    <div id="Signout" @click="changeUserInfo(5)" :class="{Signout: activeUserInfo == 5}">회원탈퇴</div><hr><br>
  </div>
</template>

<script setup>
    import { defineEmits, ref } from 'vue';
    import { useRouter } from "vue-router";

    const emit = defineEmits(['change']);
    const activeUserInfo = ref('');

function changeUserInfo(userInfo) {
  console.log(userInfo);
  activeUserInfo.value = userInfo;
  emit('change', userInfo);
}

const router = useRouter();
</script>

<style scoped>
    @import './mypage.css';
</style>