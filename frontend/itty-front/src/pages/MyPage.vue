<template>
    <MyPageHeader/>
    <div id="main-content">
		<div id="userinfo">
			<MyPageUserInfo />
		</div>
		<div id="profile">
			<UserProfile/>
			<RouterView/>
		</div>
	</div>
	<MyPageFooter/>
</template>

<script setup>
	import { ref, onMounted, provide } from 'vue';
    import { RouterView } from 'vue-router';

    import MyPageHeader from '@/components/Header.vue';
    import MyPageUserInfo from '@/components/mypage-content/MyPageContent.vue';
    import UserProfile from '@/components/mypage-content/UserProfile.vue';
    import MyPageFooter from '@/components/Footer.vue';

	import * as api from '@/api/api.js';

	const loginInfo = JSON.parse(window.localStorage.getItem('loginInfo'));
	const userInfo = ref({});

	provide('userInfo', userInfo);

	api.findUserByUserCode(
		loginInfo.userCode,
		(response) => {
			if (response.status == 200) {
				userInfo.value = response.data;
			} else {
				alert('회원 정보 조회 실패');
			}
		},
		(error) => {
			console.log(error);
			alert('회원 정보 조회 실패');
		}
	);
</script>

<style scoped>

#main-content {
	display: flex;
  	justify-content: center; /* Centers the children horizontally in the container */
  	align-items: flex-start; /* Aligns children to the top of the flex container */
  	margin-top: 180px; /* Adjust the margin to fit under your header */
  	padding: 0 10px; /* Add padding on the sides */
}

#userinfo, #profile {
  	width: calc(40%); /* Subtract the gap from the total width */
	width: 60%;
  	max-width: 100%; /* Control the maximum width */
}

#userinfo {
  	flex-basis: 15%; /* Adjust this to control the width of each section */
  	align-self: start; /* Aligns each section to the start of the flex container */
}

</style>