<template>
    <section id="hero-animated" class="hero-animated d-flex align-items-center">
        <div class="container d-flex flex-column justify-content-center align-items-center text-center position-relative" data-aos="zoom-out">
            <img src="./img/logo-main.png" class="img-fluid animated">
            <h2>안녕하세요 <span>ITTY 입니다!</span></h2>
            <p>IT To You! IT 개발자, 그리고 관심 있는 사람들을 위한 사이트입니다</p>
            <div class="d-flex">
                <a href="#about" class="animated scrollto">
                    <img style="border-radius: 100%;" src="./img/icon-arrow-down.jpg" width="48px" height="auto">
                </a>
            </div>
        </div>
    </section>

    <main id="main">
        <!-- ======= Featured Services Section ======= -->
        <section id="featured-services" class="featured-services">
            <div class="container">
                <div class="row gy-4">
                    <div class="col-xl-3 col-md-6 d-flex" data-aos="zoom-out">
                        <div class="service-item position-relative">
                            <div class="icon"><i class="bi bi-chat-square-dots-fill icon"></i></div>
                            <h4><a href="" class="stretched-link">공지사항</a></h4>
                            <p>클릭 시 공지사항 페이지로 이동할 예정입니다.</p>
                        </div>
                    </div><!-- End Service Item -->

                    <div class="col-xl-3 col-md-6 d-flex" data-aos="zoom-out" data-aos-delay="200">
                        <div class="service-item position-relative">
                            <div class="icon"><i class="bi bi-people-fill icon"></i></div>
                            <h4><a href="" class="stretched-link">1oT</a></h4>
                            <p>클릭 시 서비스 제작자(1oT)에 관한 페이지로 이동할 예정입니다.</p>
                        </div>
                    </div><!-- End Service Item -->

                    <div class="col-xl-3 col-md-6 d-flex" data-aos="zoom-out" data-aos-delay="400">
                        <div class="service-item position-relative">
                            <div class="icon"><i class="bi bi-question-circle icon"></i></div>
                            <h4><a href="" class="stretched-link">FAQ</a></h4>
                            <p>클릭 시 FAQ(문의, 신고 게시판)으로 이동할 예정입니다.</p>
                        </div>
                    </div><!-- End Service Item -->

                    <div class="col-xl-3 col-md-6 d-flex" data-aos="zoom-out" data-aos-delay="600">
                        <div class="service-item position-relative">
                            <div class="icon"><i class="bi bi-gift-fill icon"></i></div>
                            <h4><a href="" class="stretched-link">EVENT</a></h4>
                            <p>클릭 시 이벤트 관련 페이지로 이동할 예정입니다.</p>
                        </div>
                    </div><!-- End Service Item -->
                </div>
            </div>
        </section><!-- End Featured Services Section -->

        <!-- ======= About Section ======= -->
        <section id="about" class="about">
            <div class="container" data-aos="fade-up">
                <div class="section-header">
                    <h2>Guide</h2>
                    <p>ITTY는 Integration of Technology To You 뜻의 약자로 <br> IT관련 정보를 사용자에게 전달하고 관심을 가지고 있는 사람들을 위한 서비스를 제공하고자 합니다.</p>
                </div>
                <div class="row g-4 g-lg-5" data-aos="fade-up" data-aos-delay="200">
                    <div class="col-lg-5">
                        <div class="about-img">
                            <img src="./img/img-main-guide.png" class="img-fluid" alt="">
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <h3 class="pt-0 pt-lg-5">사이트 이용 가이드 or 돌아가는 효과</h3>
                    </div>
                </div>
            </div>
        </section><!-- End About Section -->

        <!-- ======= Services Section ======= -->
        <section id="services" class="services">
            <div class="container" data-aos="fade-up">
                <div class="section-header">
                    <h2>Our Services</h2>
                    <p>서비스 관련 내용 입력</p>
                </div>
                <div class="row gy-5">
                    <div class="col-xl-4 col-md-6" data-aos="zoom-in" data-aos-delay="200">
                        <div class="service-item">
                            <div class="img">
                                <img src="./img/logo-team.png" class="img-fluid" alt="">
                            </div>
                            <div class="details position-relative">
                                <div class="icon"><i class="bi bi-activity"></i></div>
                                <a href="#" class="stretched-link"><h3>다양한 IT 정보</h3></a>
                                <p>클릭 시 IT정보(전체) 게시판으로 이동할 예정입니다.</p>
                            </div>
                        </div>
                    </div><!-- End Service Item -->
                    <div class="col-xl-4 col-md-6" data-aos="zoom-in" data-aos-delay="300">
                        <div class="service-item">
                            <div class="img">
                                <img src="./img/logo-team.png" class="img-fluid" alt="">
                            </div>
                            <div class="details position-relative">
                                <div class="icon"><i class="bi bi-chat-dots"></i></div>
                                <a href="#" class="stretched-link"><h3>스터디 모집 커뮤니티</h3></a>
                                <p>클릭 시 스터디를 모집하는 커뮤니티가 활성화된 게시판으로 이동할 예정입니다.</p>
                            </div>
                        </div>
                    </div><!-- End Service Item -->
                    <div class="col-xl-4 col-md-6" data-aos="zoom-in" data-aos-delay="400">
                        <div class="service-item">
                            <div class="img">
                                <img src="./img/logo-team.png" class="img-fluid" alt="">
                            </div>
                            <div class="details position-relative">
                                <div class="icon"><i class="bi bi-journal-text"></i></div>
                                <a href="#" class="stretched-link"><h3>경력직 개발자와 커뮤니케이션</h3></a>
                                <p>클릭 시 경력직 개발자와 관련 된 게시판(이름 미정)으로 이동할 예정입니다.</p>
                            </div>
                        </div>
                    </div><!-- End Service Item -->
                </div>
            </div>
        </section><!-- End Services Section -->
    </main><!-- End #main -->
</template>

<script setup>

</script>

<style lang="scss" scoped>

</style>