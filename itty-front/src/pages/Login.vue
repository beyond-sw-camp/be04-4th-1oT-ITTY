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
                                <input type="text" id="email" />
                            </div>
                            
                            <div class="form-field">
                                <label for="password">Password</label>
                                <input type="text" id="password" />
                            </div>
                            
                            <div class="form-field">
                                <label for="name">Name</label>
                                <input type="text" id="name" />
                            </div>

                            <div class="form-field">
                                <label for="name">Nickname</label>
                                <input type="text" id="nickname" />
                            </div>

                            <div class="form-field">
                                <label for="name">Phone</label>
                                <input type="text" id="phonenumber" />
                            </div>
                                
                            <button class="btn-sign btn-up">Sign Up</button>
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
                            <label :style="{visibility: emailLabelVisibility}" for="email-in">Email</label>
                            <input type="text" name="email_in" id="email-in" @input="onChangeEmailInput" />
                        </div>
            
                        <div class="form-field">
                            <label :style="{visibility: passwordLabelVisibility}" for="password-in">Password</label>
                            <input type="password" name="password_in" id="password-in" @input="onChangePasswordInput" />
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
    
    const emailLabelVisibility = ref('');
    const passwordLabelVisibility = ref('');

    const emailInputValue = ref('');
    const passwordInputValue = ref('');

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

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

    function checkEmailValidation() {
        if (emailInputValue.value.length == 0) {
            alert('이메일을 입력해 주세요.');
            return false;
        }

        if (!emailRegex.test(emailInputValue.value)) {
            alert('이메일 주소 형식이 올바르지 않습니다.');
            return false;
        }

        return true;
    }

    function checkPasswordValidation() {
        if (passwordInputValue.value.length == 0) {
            alert('비밀번호를 입력해 주세요.');
            return;
        }

        return true;
    }

    function signIn() {        
        if (checkEmailValidation() && checkPasswordValidation()) {
            const userInfo = {
                userEmail: emailInputValue.value,
                userPassword: passwordInputValue.value
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
    }

    function onChangeEmailInput(e) {
        emailInputValue.value = e.target.value;

        e.target.value.length > 0
            ? emailLabelVisibility.value = 'hidden'
            : emailLabelVisibility.value = '';
    }

    function onChangePasswordInput(e) {
        passwordInputValue.value = e.target.value;

        e.target.value.length > 0
            ? passwordLabelVisibility.value = 'hidden'
            : passwordLabelVisibility.value = '';
    }
</script>

<style scoped>
    @import '@/assets/css/login.css';
</style>