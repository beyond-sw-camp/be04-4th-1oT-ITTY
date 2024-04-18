<template>
    <!-- ======= Footer ======= -->
    <footer id="footer" class="footer">

    <div class="footer-content">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="footer-info">
                        <h3>ITTY</h3>
                        <p>서울특별시 동작구 보라매로 87<br>우편번호 : 07060 신이빌딩<br>지번 : 서울특별시 동작구 신대방동 344-4<br><br>
                            <strong>Phone:</strong> +82 1234-5678<br>
                            <strong>Email:</strong> email@example.com<br>
                        </p>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 footer-links">
                    <h4>Useful Links</h4>
                    <ul>
                        <li><i class="bi bi-chevron-right"></i> <a href="#">Home</a></li>
                        <li><i class="bi bi-chevron-right"></i> <a href="#">Guide</a></li>
                        <li><i class="bi bi-chevron-right"></i> <a href="#">Services</a></li>
                        <li><i class="bi bi-chevron-right"></i> <a href="#">Terms of service</a></li>
                        <li><i class="bi bi-chevron-right"></i> <a href="#">Privacy policy</a></li>
                    </ul>
                </div>
                <div class="col-lg-4 col-md-6 footer-newsletter">
                    <h4>검색창</h4>
                    <p>검색창으로 사용 예정입니다.</p>
                    <form action="" method="post">
                        <input type="email" name="email"><input type="submit" value="Subscribe">
                    </form>
                </div>
            </div>
        </div>
    </div>

    </footer><!-- End Footer -->
    
    <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
    
    <div id="preloader"></div>
</template>

<script setup>
    import {ref, onMounted} from 'vue';
    
    onMounted(() => {
        /**
        * Preloader
        */
        const preloader = document.querySelector('#preloader');
        if (preloader) {
            preloader.remove();
        }
    });
</script>

<style scoped>
    @import './main-content/css/main.css';
</style>