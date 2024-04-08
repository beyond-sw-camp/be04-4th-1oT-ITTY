<template>

    <main class="main">
        <section class="home">
          <h1>Welcome to the <span>ITTY</span></h1>
          <button v-if="!isSignUpVisible && !isSignInVisible" @click="showSignUp">Sign Up</button>
          <button v-if="!isSignUpVisible && !isSignInVisible" @click="showSignIn">Sign In</button>
          <button @click="showHome">Home</button>
        </section>
      
        <div v-if="isSignUpVisible" class="sign-up">
        <section class="sign-up">
          <article class="signup-left">
            <h1>ITTY</h1>
            <div class="wc_message">
              <h3>Join us!</h3>
              <p>It's Easy and takes less then 30 seconds.</p>
            </div>
            <div class="btn-back">
              <i class="fas fa-2x fa-angle-left angle-left-color"></i>
              HOME
            </div>
          </article>
      
          <article class="form-area">
            <!-- Form area Sign Up -->
            <div class="organize-form form-area-signup">
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
              <p>Have an account? <a href="#" class="link-in">Sign In</a></p>
      
            </div>
      
            <!-- Form area Sign In -->
            <div class="organize-form form-area-signin">
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
      
                <button class="btn-sign btn-in">Sign In</button>
              </form>
              <p>Haven't an account? <a href="#" class="link-up">Sign Up</a></p>
            </div>
          </article>
      
          <article class="signup-right">
            <i class="fas fa-2x fa-bars bars-style"></i>
      
          </article>
        </section>
      </div>
      </main>

      
</template>

<script>
 import { ref } from 'vue';

export default {
  setup() {
    const isSignUpVisible = ref(false);
    const isSignInVisible = ref(false);

    function showSignUp() {
      isSignUpVisible.value = true;
      isSignInVisible.value = false;
    }

    function showSignIn() {
      isSignInVisible.value = true;
      isSignUpVisible.value = false;
    }

    function showHome() {
      isSignUpVisible.value = false;
      isSignInVisible.value = false;
    }

    return { isSignUpVisible, isSignInVisible, showSignUp, showSignIn, showHome };
  }
};

</script>

<style scoped>
  @import "@/assets/css/login.css"
</style>