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

    import {ref, onBeforeMount , onMounted} from 'vue';
    import { useRouter } from 'vue-router';

    const router = useRouter();

/**
* Template Name: HeroBiz
* Template URL: https://bootstrapmade.com/herobiz-bootstrap-business-template/
* Updated: Mar 17 2024 with Bootstrap v5.3.3
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/

document.addEventListener('DOMContentLoaded', () => {
    "use strict";

    /**
     * Preloader
     */
    const preloader = document.querySelector('#preloader');
    if (preloader) {
        window.addEventListener('load', () => {
            preloader.remove();
        });
    }

    /**
     * Sticky header on scroll
     */
    const selectHeader = document.querySelector('#header');
    if (selectHeader) {
        document.addEventListener('scroll', () => {
        window.scrollY > 100 ? selectHeader.classList.add('sticked') : selectHeader.classList.remove('sticked');
    });
    }

    /**
     * Navbar links active state on scroll
     */
    let navbarlinks = document.querySelectorAll('#navbar .scrollto');

    function navbarlinksActive() {
        navbarlinks.forEach(navbarlink => {
            if (!navbarlink.hash) return;

            let section = document.querySelector(navbarlink.hash);
            if (!section) return;
            
            let position = window.scrollY;
            if (navbarlink.hash != '#header') position += 200;

            if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
                navbarlink.classList.add('active');
            } else {
                navbarlink.classList.remove('active');
            }
        })
    }
    
    window.addEventListener('load', navbarlinksActive);
    document.addEventListener('scroll', navbarlinksActive);

    /**
     * Function to scroll to an element with top ofset
     */
    function scrollto(el) {
        const selectHeader = document.querySelector('#header');
        let offset = 0;

        if (selectHeader.classList.contains('sticked')) {
            offset = document.querySelector('#header.sticked').offsetHeight;
        } else if (selectHeader.hasAttribute('data-scrollto-offset')) {
            offset = selectHeader.offsetHeight - parseInt(selectHeader.getAttribute('data-scrollto-offset'));
        }
        window.scrollTo({
            top: document.querySelector(el).offsetTop - offset,
            behavior: 'smooth'
        });
    }

    /**
     * Fires the scrollto function on click to links .scrollto
     */
    let selectScrollto = document.querySelectorAll('.scrollto');
    selectScrollto.forEach(el => el.addEventListener('click', function(event) {
        if (document.querySelector(this.hash)) {
            event.preventDefault();

            let mobileNavActive = document.querySelector('.mobile-nav-active');
            if (mobileNavActive) {
                mobileNavActive.classList.remove('mobile-nav-active');

                let navbarToggle = document.querySelector('.mobile-nav-toggle');
                navbarToggle.classList.toggle('bi-list');
                navbarToggle.classList.toggle('bi-x');
            }
        scrollto(this.hash);
        }
    }));

    /**
     * Scroll with ofset on page load with hash links in the url
     */
    window.addEventListener('load', () => {
        if (window.location.hash) {
            if (document.querySelector(window.location.hash)) {
                scrollto(window.location.hash);
            }
        }
    });

    /**
     * Mobile nav toggle
     */
    const mobileNavToogle = document.querySelector('.mobile-nav-toggle');
    if (mobileNavToogle) {
        mobileNavToogle.addEventListener('click', function(event) {
            event.preventDefault();

            document.querySelector('body').classList.toggle('mobile-nav-active');

            this.classList.toggle('bi-list');
            this.classList.toggle('bi-x');
        });
    }

    /**
     * Toggle mobile nav dropdowns
     */
    const navDropdowns = document.querySelectorAll('.navbar .dropdown > a');

    navDropdowns.forEach(el => {
        el.addEventListener('click', function(event) {
            if (document.querySelector('.mobile-nav-active')) {
                event.preventDefault();
                this.classList.toggle('active');
                this.nextElementSibling.classList.toggle('dropdown-active');

                let dropDownIndicator = this.querySelector('.dropdown-indicator');
                dropDownIndicator.classList.toggle('bi-chevron-up');
                dropDownIndicator.classList.toggle('bi-chevron-down');
            }
        })
    });

    /**
     * Auto generate the hero carousel indicators
     */
    let heroCarouselIndicators = document.querySelector('#hero .carousel-indicators');
    if (heroCarouselIndicators) {
        let heroCarouselItems = document.querySelectorAll('#hero .carousel-item')

        heroCarouselItems.forEach((item, index) => {
            if (index === 0) {
                heroCarouselIndicators.innerHTML += `<li data-bs-target="#hero" data-bs-slide-to="${index}" class="active"></li>`;
            } else {
                heroCarouselIndicators.innerHTML += `<li data-bs-target="#hero" data-bs-slide-to="${index}"></li>`;
            }
        });
    }

    /**
     * Scroll top button
     */
    const scrollTop = document.querySelector('.scroll-top');
    if (scrollTop) {
        const togglescrollTop = function() {
            window.scrollY > 100 ? scrollTop.classList.add('active') : scrollTop.classList.remove('active');
        }
        window.addEventListener('load', togglescrollTop);
        document.addEventListener('scroll', togglescrollTop);
        scrollTop.addEventListener('click', window.scrollTo({
            top: 0,
            behavior: 'smooth'
        }));
    }

    /**
     * Initiate glightbox
     */
    const glightbox = GLightbox({
        selector: '.glightbox'
    });

    /**
     * Porfolio isotope and filter
     */
    let portfolionIsotope = document.querySelector('.portfolio-isotope');

    if (portfolionIsotope) {
        let portfolioFilter = portfolionIsotope.getAttribute('data-portfolio-filter') ? portfolionIsotope.getAttribute('data-portfolio-filter') : '*';
        let portfolioLayout = portfolionIsotope.getAttribute('data-portfolio-layout') ? portfolionIsotope.getAttribute('data-portfolio-layout') : 'masonry';
        let portfolioSort = portfolionIsotope.getAttribute('data-portfolio-sort') ? portfolionIsotope.getAttribute('data-portfolio-sort') : 'original-order';

        window.addEventListener('load', () => {
            let portfolioIsotope = new Isotope(document.querySelector('.portfolio-container'), {
                itemSelector: '.portfolio-item',
                layoutMode: portfolioLayout,
                filter: portfolioFilter,
                sortBy: portfolioSort
            });

            let menuFilters = document.querySelectorAll('.portfolio-isotope .portfolio-flters li');
            menuFilters.forEach(function(el) {
                el.addEventListener('click', function() {
                    document.querySelector('.portfolio-isotope .portfolio-flters .filter-active').classList.remove('filter-active');
                    this.classList.add('filter-active');
                    
                    portfolioIsotope.arrange({
                        filter: this.getAttribute('data-filter')
                    });
                    
                    if (typeof aos_init === 'function') {
                        aos_init();
                    }
                }, false);
            });
        });
    }

    /**
     * Clients Slider
     */
    new Swiper('.clients-slider', {
        speed: 400,
        loop: true,
        autoplay: {
            delay: 5000,
            disableOnInteraction: false
        },
        slidesPerView: 'auto',
        breakpoints: {
            320: {
                slidesPerView: 2,
                spaceBetween: 40
            },
            480: {
                slidesPerView: 3,
                spaceBetween: 60
            },
            640: {
                slidesPerView: 4,
                spaceBetween: 80
            },
            992: {
                slidesPerView: 6,
                spaceBetween: 120
            }
        }
    });

    /**
     * Testimonials Slider
     */
    new Swiper('.testimonials-slider', {
        speed: 600,
        loop: true,
        autoplay: {
            delay: 5000,
            disableOnInteraction: false
        },
        slidesPerView: 'auto',
        pagination: {
            el: '.swiper-pagination',
            type: 'bullets',
            clickable: true
        }
    });

    /**
     * Testimonials Slider
     */
    new Swiper('.portfolio-details-slider', {
        speed: 600,
        loop: true,
        autoplay: {
            delay: 5000,
            disableOnInteraction: false
        },
        slidesPerView: 'auto',
        pagination: {
            el: '.swiper-pagination',
            type: 'bullets',
            clickable: true
        }
    });

    /**
     * Animation on scroll function and init
     */
    function aos_init() {
        AOS.init({
            duration: 1000,
            easing: 'ease-in-out',
            once: true,
            mirror: false
        });
    }

    window.addEventListener('load', () => {
        aos_init();
    });

});

</script>

<style scoped>
    @import './css/main.css';
</style>