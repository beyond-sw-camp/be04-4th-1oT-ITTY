<template>
    <header id="header" class="header fixed-top" data-scrollto-offset="0">
        <div class="container-fluid d-flex align-items-center justify-content-evenly">
            <a @click="navigateToHome" style="cursor: pointer;"><img style="border-radius: 20%; scale:70%" src="@/assets/img/logo-itty.jpg" width="130px" height="auto"></a>
            <nav id="navbar" class="navbar">
                <ul>
                    <li class="dropdown">
                        <a href="#"><span>Home</span><i class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="#">공지사항</a></li>
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">1oT</a></li>
                            <li><a @click="navigateToEvent">EVENT</a></li>
                        </ul>
                    </li>
                    <li><a class="nav-link scrollto" href="#about">Guide</a></li>
                    <li><a class="nav-link scrollto" href="#services">Services</a></li>
                    <li class="dropdown"><a><span>게시판</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li class="dropdown"><a><span>트렌드 게시판</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
                                <ul>
                                    <li><a @click="navigateToTrendBoard">전체</a></li>
                                    <li><a href="#">IT기업</a></li>
                                    <li><a href="#">IT·과학</a></li>
                                    <li><a href="#">포털/플랫폼</a></li>
                                    <li><a href="#">디지털마케팅</a></li>
                                    <li><a href="#">보안/해킹</a></li>
                                </ul>
                            </li>
                            <li><a href="#">경력직 개발자 관련 게시판</a></li>
                            <li><a href="#">스터디 모집 게시판</a></li>
                            <li><a href="#">공모전 게시판</a></li>
                            <li><a href="#">논문 게시판</a></li>
                            <li><a @click="navigateToFreeBoard">자유 게시판</a></li>
                        </ul>
                    </li>
                </ul>
                <i class="bi bi-list mobile-nav-toggle d-none"></i>
            </nav><!-- .navbar -->
            <div style="width: 130px; text-align: center;">
                <a v-if="isBeforeLogin" class="btn-getstarted scrollto" style="cursor: pointer;" @click="navigateToLogin">로그인</a>

                <div v-else style="cursor: pointer;">
                    <div class="dropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        <img class="profile" src="@/assets/img/icon-user.png" />
                    </div>

                    <div>
                        <ul style="width: 179px;" class="dropdown-menu">
                            <li><a class="dropdown-item" @click="navigateToUserProfile(userCode)" >내 프로필</a></li>
                            <li><a class="dropdown-item" @click="logout">로그아웃</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header><!-- End Header -->
</template>

<script setup>
    import { ref, onMounted } from 'vue';
    import { useRouter } from 'vue-router';

    const router = useRouter();

    const isBeforeLogin = ref(true);

    function navigateToTrendBoard() {
        router.push('/trend-board');
    }

    function navigateToFreeBoard() {
        router.push('/free-board');
    }

    function navigateToEvent() {
        router.replace('/event-board');
    }

    function navigateToLogin() {
        router.push('/login');
    }

    function navigateToHome() {
        router.replace('/');
    }

    function navigateToUserProfile() {
        router.push('/mypage');
    }

    function logout() {
        if (confirm('로그아웃 하시겠습니까?')) {
            window.localStorage.removeItem('loginInfo');
            isBeforeLogin.value = true;
        }
    }

    onMounted(() => {
        /**
         * Sticky header on scroll
         */
        const selectHeader = document.querySelector('#header');
        if (selectHeader) {
            document.addEventListener('scroll', () => {
                window.scrollY > 10 ? selectHeader.classList.add('sticked') : selectHeader.classList.remove('sticked');
            });
        }

        isBeforeLogin.value = !window.localStorage.getItem('loginInfo');
    });
</script>

<style scoped>
    @import './main-content/css/main.css';

    .profile {
        width: 40px !important;
        height: 40px !important;
    }
</style>