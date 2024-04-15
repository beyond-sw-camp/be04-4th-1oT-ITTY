<template>
    <body>
        <main class="main">
            <section class="home" v-if="!isSignUpVisible && !isSignInVisible">
                <h1>Welcome to the <span>ITTY</span></h1>
                <button @click="showSignUp" class="btn">Sign Up</button>
                <button @click="showSignIn" class="btn">Sign In</button>
                <br>
                <a href="/">MAIN</a> 
            </section>

            <div v-if="isSignUpVisible || isSignInVisible" class="sign-up">
                <section class="sign-up">
                    <article class="signup-left">
                        <h1>ITTY</h1>
                        <div v-if="isSignUpVisible">
                        <div class="wc_message">
                        <h3>Join us!</h3>
                        <p>It's Easy and takes less then 30 seconds.</p>
                        </div>
                        </div>
                        <div class="btn-back" @click="showHome">
                        <i class="fas fa-2x fa-angle-left angle-left-color"></i>
                        HOME
                        </div>
                    </article>
                </section>
                
                <transition name="slide-fade">
                    <!-- Form area Sign Up -->
                    <div class="organize-form form-area-signup" v-if="isSignUpVisible">
                        
                        <h2>SIGN UP</h2>
                        <form class="form">
                        
                            <div class="form-field">
                                <label for="email">Email</label>
                                <input type="text" id="email" @input="onChangeSignUpInput" />
                            </div>
                            
                            <div class="form-field">
                                <label for="password">Password</label>
                                <input type="password" id="password" @input="onChangeSignUpInput" />
                            </div>
                            
                            <div class="form-field">
                                <label for="name">Name</label>
                                <input type="text" id="name" @input="onChangeSignUpInput" />
                            </div>

                            <div class="form-field">
                                <label for="nickname">Nickname</label>
                                <input type="text" id="nickname" @input="onChangeSignUpInput" />
                            </div>

                            <div class="form-field">
                                <label for="phoneNumber">Phone</label>
                                <input type="text" id="phoneNumber" @input="onChangeSignUpInput" />
                            </div>
                                
                            <button type="button" class="btn-sign btn-up" @click="signUp">Sign Up</button>
                        </form>
                        <p>Have an account? <a href="#" @click.prevent="showSignIn">Sign In</a></p>
                    </div>
                </transition>  
            </div>

            <transition name="slide-fade">
                <!-- Form area Sign In -->
                <div class="organize-form form-area-signin" v-if="isSignInVisible">
                    <h2>SIGN IN</h2>
                    <form class="form">
                        <div class="form-field">
                            <label for="email-in">Email</label>
                            <input type="text" name="email_in" id="email-in" @input="onChangeSignInInput" />
                        </div>
            
                        <div class="form-field">
                            <label for="password-in">Password</label>
                            <input type="password" name="password_in" id="password-in" @input="onChangeSignInInput" />
                        </div>
            
                        <button type="button" class="btn-sign btn-in" @click="signIn">Sign In</button>
                    </form>
                    <p>Have an account? <a href="#" @click.prevent="showSignUp">Sign Up</a></p>
                </div>
            </transition>

            <article class="signup-right">
                <i class="fas fa-2x fa-bars bars-style"></i>
            </article>
        </main>
    </body>
</template>

<script setup>

    import { ref } from 'vue';
    import { useRouter } from 'vue-router';
    import * as api from '@/api/api.js';

    const router = useRouter();

    const isSignUpVisible = ref(false);
    const isSignInVisible = ref(false);

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    let signUpInputTextObj = {};
    let signInInputTextObj = {};

    function showSignUp() {
        isSignUpVisible.value = true;
        isSignInVisible.value = false;
    }

    function showSignIn() {
        isSignUpVisible.value = false;
        isSignInVisible.value = true;
    }

    function showHome() {
        isSignUpVisible.value = false;
        isSignInVisible.value = false;
    }

    function signUp() {
        const email = signUpInputTextObj.email;
        const password = signUpInputTextObj.password;
        const name = signUpInputTextObj.name;
        const nickname = signUpInputTextObj.nickname;
        const phoneNumber = signUpInputTextObj.phoneNumber;


        if (!email) {
            alert('이메일을 입력해 주세요.');
            return;
        }

        if (!password) {
            alert('비밀번호를 입력해 주세요.');
            return;
        }

        if (!name) {
            alert('이름을 입력해 주세요.');
            return;
        }

        if (!nickname) {
            alert('닉네임를 입력해 주세요.');
            return;
        }

        if (!phoneNumber) {
            alert('전화번호를 입력해 주세요.');
            return;
        }

        if (!emailRegex.test(email)) {
            alert('이메일 주소 형식이 올바르지 않습니다.');
            return;
        }

        const userInfo = {
            userEmail: email,
            userPassword: password,
            userName: name,
            userNickname: nickname,
            userPhoneNumber: phoneNumber
        }

        api.regist(
            userInfo,
            (response) => {
                signInInputTextObj['email'] = email;
                signInInputTextObj['password'] = password;

                signIn();
            },
            (error) => {
                console.log(error);
                
                if (error.response.status == 409) {
                    const errorMessage = error.response.data.message;
                    console.log(errorMessage);
                    alert(errorMessage);
                } else {
                    alert('회원가입 실패');
                }
            }
        );
    }

    function signIn() {
        const email = signInInputTextObj.email;
        const password = signInInputTextObj.password;

        if (!email) {
            alert('이메일을 입력해 주세요.');
            return;
        }

        if (!password) {
            alert('비밀번호를 입력해 주세요.');
            return;
        }

        if (!emailRegex.test(email)) {
            alert('이메일 주소 형식이 올바르지 않습니다.');
            return;
        }

        const userInfo = {
            userEmail: email,
            userPassword: password
        }

        api.login(
            userInfo,
            function(response) {
                if (response.status == 200) {
                    const header = response.headers;
                    const accessToken = header['access-token'];
                    const refreshToken = header['refresh-token'];
                    const userCode = header['user-code-pk'];
                    const userEmail = header['user-email'];

                    const loginInfo = {
                        accessToken: accessToken,
                        refreshToken: refreshToken,
                        userCode: userCode,
                        userEmail: userEmail
                    }

                    window.localStorage.setItem('loginInfo', JSON.stringify(loginInfo));

                    router.replace('/');
                }
            },
            function(error) {
                console.log(error);
                alert('로그인 실패');
            }
        );
    }

    function onChangeSignInInput(e) {
        const inputName = e.target.id.split('-')[0];
        signInInputTextObj[inputName] = e.target.value;
        console.log(signInInputTextObj);
        onChangeInput(e);
    }

    function onChangeSignUpInput(e) {
        signUpInputTextObj[e.target.id] = e.target.value;
        console.log(signUpInputTextObj);
        onChangeInput(e);

    }

    function onChangeInput(e) {
        e.target.value.length > 0
            ? e.target.previousSibling.style.visibility = 'hidden'
            : e.target.previousSibling.style.visibility = ''
    }
</script>

<style scoped>
    @import '@/assets/css/login.css';
</style>