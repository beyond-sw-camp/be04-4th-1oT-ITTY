<template>
    <header id="header" class="header fixed-top" data-scrollto-offset="0">
    <div class="container-fluid d-flex align-items-center justify-content-evenly">

      <a href="index.html" class="">
        <img style="border-radius: 20%; scale:70%" src="@/assets/img/logo-itty.jpg" width="130px" height="auto"> 
      </a>

      <nav id="navbar" class="navbar">
        <ul>

          <li class="dropdown"><a href="#"><span>Home</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
            <ul>
              <li><a href="index.html" class="active">공지사항</a></li>
              <li><a href="index.html">FAQ</a></li>
              <li><a href="index.html">1oT</a></li>
              <li><a href="index.html">EVENT</a></li>
            </ul>
          </li>

          <li><a class="nav-link scrollto" href="index.html#about">Guide</a></li>
          <li><a class="nav-link scrollto" href="index.html#services">Services</a></li>

          <li class="dropdown"><a href="#"><span>게시판</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
            <ul>
              <li class="dropdown"><a><span>트렌드 게시판</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
                <ul>
                  <li><a @click="navigateToTrendBoard">IT정보(전체) 게시판</a></li>
                  <li><a href="#">BACKEND</a></li>
                  <li><a href="#">FRONTEND</a></li>
                  <li><a href="#">DEVOPS</a></li>
                  <li><a href="#">AI</a></li>
                </ul>
              </li>
              <li><a href="#">경력직 개발자 관련 게시판</a></li>
              <li><a href="#">스터디 모집 게시판</a></li>
              <li><a href="#">공모전 게시판</a></li>
              <li><a href="#">논문 게시판</a></li>
              <li><a href="#">자유 게시판</a></li>
            </ul>
          </li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle d-none"></i>
      </nav><!-- .navbar -->

      <a class="btn-getstarted scrollto" @click="navigateToLogin">로그인</a>

    </div>
  </header><!-- End Header -->
</template>

<script setup>
  import { useRouter } from 'vue-router';

  const router = useRouter();

  function navigateToTrendBoard() {
    router.push('/trend-board');
  }

  function navigateToLogin() {
    router.push('/login');
  }
</script>

<style scoped>
    @import './main-content/css/main.css';
</style>