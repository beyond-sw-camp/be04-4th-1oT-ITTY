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
                            <label for="email-in">Email</label>
                            <input type="text" name="email_in" id="email-in" />
                        </div>
            
                        <div class="form-field">
                            <label for="password-in">Password</label>
                            <input type="text" name="password_in" id="password-in" />
                        </div>
            
                        <button class="btn-sign btn-in" @click="signIn">Sign In</button>
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

    import { ref, onMounted } from 'vue';
    import { useRouter } from 'vue-router';

    const isSignUpVisible = ref(false);
    const isSignInVisible = ref(false);

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
</script>

<style scoped>
    @import '@/assets/css/login.css';
</style>