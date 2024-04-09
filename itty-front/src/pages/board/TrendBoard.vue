<template>
    <MainHeader/>
    <div class="container-wrapper">
        <div id="content">
            <div class="inner">
                <!-- Post -->
                <article class="box post post-excerpt">                    
                    <div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
                                <div class="container">
                                    <div class="carousel-caption text-start">
                                        <h1>Example headline.</h1>
                                        <p class="opacity-75">Some representative placeholder content for the first slide of the carousel.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
                                <div class="container">
                                    <div class="carousel-caption">
                                        <h1>Another example headline.</h1>
                                        <p>Some representative placeholder content for the second slide of the carousel.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
                                <div class="container">
                                    <div class="carousel-caption text-end">
                                        <h1>One more for good measure.</h1>
                                        <p>Some representative placeholder content for the third slide of this carousel.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </article>
                <section class="py-5">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">       
                                <div class="tab-content" id="nav-tabContent">
                                    <div class="tab-pane fade show active" id="nav-all" role="tabpanel" aria-labelledby="nav-all-tab">
                                        <div class="product-grid row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5" style="display: flex; flex-wrap:wrap;">
                                            <div class="col">
                                                <div class="product-item">
                                                    <span class="badge bg-success position-absolute m-1">해시태그</span>
                                                    <a href="#" class="btn-wishlist"><svg width="24" height="24"><use xlink:href="#heart"></use></svg></a>
                                                    <figure>
                                                        <a href="single-product.html" title="Product Title"><img src="@/components/main-content/img/logo-team.png"  class="tab-image"></a>
                                                    </figure>
                                                    <h3>IT이슈 1</h3>
                                                    <span class="qty">앞의 첫째 줄 둘째줄 정도까지</span>
                                                </div>
                                            </div>
                                            <div class="col">
                                                <div class="product-item">
                                                    <span class="badge bg-success position-absolute m-1">해시태그</span>
                                                    <a href="#" class="btn-wishlist"><svg width="24" height="24"><use xlink:href="#heart"></use></svg></a>
                                                    <figure>
                                                    <a href="single-product.html" title="Product Title"><img src="@/components/main-content/img/logo-team.png"  class="tab-image"></a>
                                                    </figure>
                                                    <h3>IT이슈 1</h3>
                                                    <span class="qty">앞의 첫째 줄 둘째줄 정도까지</span>
                                                </div>
                                            </div>
                                            <div class="col">
                                                <div class="product-item">
                                                    <span class="badge bg-success position-absolute m-1">해시태그</span>
                                                    <a href="#" class="btn-wishlist"><svg width="24" height="24"><use xlink:href="#heart"></use></svg></a>
                                                    <figure>
                                                        <a href="single-product.html" title="Product Title"><img src="@/components/main-content/img/logo-team.png"  class="tab-image"></a>
                                                    </figure>
                                                    <h3>IT이슈 1</h3>
                                                    <span class="qty">앞의 첫째 줄 둘째줄 정도까지</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>             
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Pagination -->
                <div class="pagination">
                    <!--<a href="#" class="button previous">Previous Page</a>-->
                    <div class="pages">
                        <a href="#" class="active">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <span>&hellip;</span>
                        <a href="#">20</a>
                    </div>
                    <a href="#" class="button next">Next Page</a>
                </div>
            </div>
        </div>
        <!-- Sidebar -->
        <div id="sidebar">
            <!-- Logo -->
            <h1 id="logo"><a href="#">IT(트렌드) 게시판</a></h1>
                <!-- Nav -->
                <nav id="nav">
                    <ul>
                        <li class="current"><a href="#">전체</a></li>
                        <li><a href="#">백엔드</a></li>
                        <li><a href="#">프론트엔드</a></li>
                        <li><a href="#">데브옵스</a></li>
                        <li><a href="#">AI</a></li>
                    </ul>
                </nav>
                <!-- Search -->
                <section class="box search">
                    <form method="post" action="#">
                        <input type="text" class="text" name="search" placeholder="Search" />
                    </form>
                </section>
                <!-- Calendar -->
                <section class="box calendar">
                    <div class="inner">
                        <table>
                        <caption>July 2014</caption>
                        <thead>
                            <tr>
                                <th scope="col" title="Monday">M</th>
                                <th scope="col" title="Tuesday">T</th>
                                <th scope="col" title="Wednesday">W</th>
                                <th scope="col" title="Thursday">T</th>
                                <th scope="col" title="Friday">F</th>
                                <th scope="col" title="Saturday">S</th>
                                <th scope="col" title="Sunday">S</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan="4" class="pad"><span>&nbsp;</span></td>
                                <td><span>1</span></td>
                                <td><span>2</span></td>
                                <td><span>3</span></td>
                            </tr>
                            <tr>
                                <td><span>4</span></td>
                                <td><span>5</span></td>
                                <td><a href="#">6</a></td>
                                <td><span>7</span></td>
                                <td><span>8</span></td>
                                <td><span>9</span></td>
                                <td><a href="#">10</a></td>
                            </tr>
                            <tr>
                                <td><span>11</span></td>
                                <td><span>12</span></td>
                                <td><span>13</span></td>
                                <td class="today"><a href="#">14</a></td>
                                <td><span>15</span></td>
                                <td><span>16</span></td>
                                <td><span>17</span></td>
                            </tr>
                            <tr>
                                <td><span>18</span></td>
                                <td><span>19</span></td>
                                <td><span>20</span></td>
                                <td><span>21</span></td>
                                <td><span>22</span></td>
                                <td><a href="#">23</a></td>
                                <td><span>24</span></td>
                            </tr>
                            <tr>
                                <td><a href="#">25</a></td>
                                <td><span>26</span></td>
                                <td><span>27</span></td>
                                <td><span>28</span></td>
                                <td class="pad" colspan="3"><span>&nbsp;</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </div>
    <MainFooter/>
</template>

<script setup>
    import MainHeader from '@/components/Header.vue';
    import MainFooter from '@/components/Footer.vue';
</script>

<style scoped>
.container-wrapper {
    display: flex;
    position: relative;
    padding: 120px 0 0;
    width: 100%;
}

.bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
}

@media (min-width: 768px) {
    .bd-placeholder-img-lg {
        font-size: 3.5rem;
    }
}
		
.b-example-divider {
    width: 100%;
    height: 3rem;
    background-color: rgba(0, 0, 0, .1);
    border: solid rgba(0, 0, 0, .15);
    border-width: 1px 0;
    box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}
		
.b-example-vr {
    flex-shrink: 0;
    width: 1.5rem;
    height: 100vh;
}

.bi {
    vertical-align: -.125em;
    fill: currentColor;
}
		
.nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
}

.nav-scroller .nav {
    display: flex;
    flex-wrap: nowrap;
    padding-bottom: 1rem;
    margin-top: -1px;
    overflow-x: auto;
    text-align: center;
    white-space: nowrap;
    -webkit-overflow-scrolling: touch;
}
		
.btn-bd-primary {
    --bd-violet-bg: #712cf9;
    --bd-violet-rgb: 112.520718, 44.062154, 249.437846;
    
    --bs-btn-font-weight: 600;
    --bs-btn-color: var(--bs-white);
    --bs-btn-bg: var(--bd-violet-bg);
    --bs-btn-border-color: var(--bd-violet-bg);
    --bs-btn-hover-color: var(--bs-white);
    --bs-btn-hover-bg: #6528e0;
    --bs-btn-hover-border-color: #6528e0;
    --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
    --bs-btn-active-color: var(--bs-btn-hover-color);
    --bs-btn-active-bg: #5a23c8;
    --bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
    z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
    display: block !important;
}

html, body, div, span, applet, object,
iframe, h1, h2, h3, h4, h5, h6, p, blockquote,
pre, a, abbr, acronym, address, big, cite,
code, del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var, b,
u, i, center, dl, dt, dd, ol, ul, li, fieldset,
form, label, legend, table, caption, tbody,
tfoot, thead, tr, th, td, article, aside,
canvas, details, embed, figure, figcaption,
footer, header, hgroup, menu, nav, output, ruby,
section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav {
	display: block;}

section {
	display: block;
}

/* Preloader */
.preloader-wrapper {
	width: 100%;
	height: 100vh;
	margin: 0 auto;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 111;
	background: #fff;
}

.preloader-wrapper .preloader {
	margin: 20% auto 0;
    transform: translateZ(0);
}

.preloader:before,
.preloader:after {
	content: '';
	position: absolute;
	top: 0;
}

.preloader:before,
.preloader:after,
.preloader {
	border-radius: 50%;
	width: 2em;
	height: 2em;
	animation: animation 1.2s infinite ease-in-out;
}

.preloader {
	animation-delay: -0.16s;
}

.preloader:before {
	left: -3.5em;
	animation-delay: -0.32s;
}

.preloader:after {
	left: 3.5em;
}
	
/* product tabs */
.product-tabs .nav-tabs {
	justify-content: flex-end;
	border: none;
	
	--bs-nav-link-hover-color: #111;
	--bs-nav-link-color: #555;
	--bs-nav-tabs-link-border-color: #fff;
	--bs-nav-tabs-link-hover-border-color: transparent;
	--bs-nav-tabs-link-active-border-color: #fff;
}
.product-tabs .nav-tabs .nav-link.active, 
.product-tabs .nav-tabs .nav-item.show .nav-link {
	/* border: none; */
	border-bottom: 3px solid var(--accent-color);
}

  /* product-grid */
/* .product-grid {
	gap: 25px;
} */

.bg-success {
    background-color: #fec84a;
}

.product-item {
    max-width: 200px;
    position: relative;
    padding: 16px;
    background: #FFFFFF;
    border: 1px solid #FBFBFB;
    box-shadow: 0px 5px 22px rgba(0, 0, 0, 0.04);
    border-radius: 16px;
    margin-bottom: 30px;
    transition: box-shadow 0.3s ease-out;
    }
.product-item:hover {
		box-shadow: 0px 21px 44px rgba(0, 0, 0, 0.08);
}
.product-item h3 {
    display: block;
    width: 100%;
    font-weight: 600;
    font-size: 18px;
    line-height: 25px;
    text-transform: capitalize;
    color: #333333;
    margin: 0;
}
.product-item figure {
    background: #F9F9F9;
    border-radius: 12px;
    text-align: center;
}
.product-item figure img {
    max-height: 100px;
    height: auto;
}
.product-item .btn-wishlist {
    position: absolute;
    top: 15px;
    right: 15px;
    width: 30px;
    height: 30px;
    border-radius: 50px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #fff;
    border: 1px solid #d8d8d8;
    transition: all 0.3s ease-out;
}
.product-item .btn-wishlist:hover {
    background: rgb(0, 0, 0);
    color: #fff;
}
.product-item .qty {
    font-weight: 400;
    font-size: 13px;
    line-height: 18px;
    letter-spacing: 0.02em;
    text-transform: uppercase;
    color: #9D9D9D;
}
.product-item .rating {
    font-weight: 600;
    font-size: 13px;
    line-height: 18px;
    text-transform: capitalize;
    color: #222222;
}
.product-item .rating iconify-icon {
    color: #FFC43F;
}
.product-item .price {
    display: block;
    width: 100%;
    font-weight: 600;
    font-size: 22px;
    line-height: 30px;
    text-transform: capitalize;
    color: #222222;
}
.product-item .product-qty {
    width: 85px;
}
.product-item .btn-link {
    text-decoration: none;
}
.product-item #quantity {
    height: auto;
    width: 28px;
    text-align: center;
    border: none;
    margin: 0;
    padding: 0;
}
.product-item .btn-number {
    width: 26px;
    height: 26px;
    line-height: 1;
    text-align: center;
    background: #FFFFFF;
    border: 1px solid #E2E2E2;
    border-radius: 6px;
    color: #222;
    padding: 0;
}

body {
    --bs-link-color: #333;
    --bs-link-hover-color:#333;
    
    --bs-link-color-rgb: 40,40,40;
    --bs-link-hover-color-rgb: 0,0,0;
    
    /* --bs-link-color: #FFC43F;
    --bs-link-hover-color: #FFC43F; */
    
    --bs-light-rgb: 248, 248, 248;
    
    --bs-font-sans-serif: "Open Sans", sans-serif;
    --bs-body-font-family: var(--bs-font-sans-serif);
    --bs-body-font-size: 1rem;
    --bs-body-font-weight: 400;
    --bs-body-line-height: 2;
    --bs-body-color: #747474;
    
    --bs-primary: #FFC43F;
    --bs-primary-rgb: 255, 196, 63;
    
    --bs-success: #ffc710;
    --bs-success-rgb: 163, 190, 76;
    
    --bs-primary-bg-subtle: #FFF9EB;
    --bs-success-bg-subtle: #eef5e5;
    
    --bs-border-color: #F7F7F7;
    
    --bs-secondary-rgb: 230, 243, 251;
    --bs-success-rgb: 255, 204, 78; 
    --bs-danger-rgb: 249, 235, 231;
    --bs-warning-rgb: 255, 249, 235;
    --bs-info-rgb: 230, 243, 250;
    
    line-height: 1;
}

ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
    content: '';
    content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

body {
	-webkit-text-size-adjust: none;
}

mark {
	background-color: transparent;
	color: inherit;
}

input::-moz-focus-inner {
	border: 0;
	padding: 0;
}

input, select, textarea {
	-moz-appearance: none;
	-webkit-appearance: none;
	-ms-appearance: none;
	appearance: none;
}

/* Basic */
html {
    box-sizing: border-box;
}

*, *:before, *:after {
    box-sizing: inherit;
}

body {
    background-color: #e8e8e8;
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
}


body, input, textarea, select {
    font-family: 'Source Sans Pro', sans-serif;
    font-weight: 400;
    color: #565656;
}

a {
    color: #edd96a;
}

strong, b {
    font-weight: 700;
    color: #232323;
}

h2, h3, h4, h5, h6 {
    font-family: 'Open Sans Condensed', sans-serif;
    font-weight: 700;
    color: #232323;
}

h2 a, h4 a, h5 a, h6 a {
    text-decoration: none;
    color: inherit;
}

blockquote {
    border-left: solid 5px #ddd;
    padding: 1em 0 1em 2em;
    font-style: italic;
}

em, i {
    font-style: italic;
}

hr {
    border: 0;
    border-top: solid 1px #ddd;
    padding: 1.5em 0 0 0;
    margin: 1.75em 0 0 0;
}

sub {
    position: relative;
    top: 0.5em;
    font-size: 0.8em;
}

sup {
    position: relative;
    top: -0.5em;
    font-size: 0.8em;
}

br.clear {
    clear: both;
}

p, ul, ol, dl {
    margin-bottom: 1em;
}

/* Table */
table {
    margin-bottom: 1em;
    width: 100%;
}

table tbody tr:nth-child(2n+2) {
    background: #f4f4f4;
}

table td {
    padding: 0.5em 1em 0.5em 1em;
}

table th {
    text-align: left;
    font-weight: 700;
    padding: 0.75em 1em 0.75em 1em;
}

table thead {
    border-bottom: solid 1px #ddd;
}

table tfoot {
    border-top: solid 1px #ddd;
    background: #eee;
}

/* Form */
form label {
    font-family: 'Open Sans Condensed', sans-serif;
    font-weight: 700;
    color: #232323;
    margin: 0 0 0.75em 0;
}

form input[type="text"],
form input[type="email"],
form input[type="password"],
form select,
form textarea {
    display: block;
    border-radius: 0.4em;
    appearance: none;
    border: solid 1px #ddd;
    padding: 0.5em 0.75em;
    width: 100%;
    line-height: 1.25em;
}

form input[type="text"]:focus,
form input[type="email"]:focus,
form input[type="password"]:focus,
form select:focus,
form textarea:focus {
    box-shadow: 0px 0px 2px 2px #ffed62;
}

form ::-webkit-input-placeholder {
    color: #aaa;
}

form :-moz-placeholder {
    color: #aaa;
}

form ::-moz-placeholder {
    color: #aaa;
}

form :-ms-input-placeholder {
    color: #aaa;
}

/* Section/Article */
header {
    margin: 0 0 2em 0;
}

header > p {
    font-family: 'Open Sans Condensed', sans-serif;
    font-weight: 300;
    display: block;
    margin-top: 1em;
    color: #999;
}

section, article {
    margin-bottom: 3em;
}

section > :last-child,
section > .inner > :last-child, section:last-child, article > :last-child,
article > .inner > :last-child, article:last-child {
    margin-bottom: 0;
}

/* Image */
.image {
    display: inline-block;
}

.image img {
    display: block;
    width: 100%;
}

.image.fit {
    display: block;
    width: 100%;
}

.image.featured {
    display: block;
    width: 100%;
    margin: 0 0 2em 0;
}

.image.left {
    float: left;
    margin: 0 2em 2em 0;
}

.image.centered {
    display: block;
    margin: 0 0 2em 0;
}

.image.centered img {
    margin: 0 auto;
    width: auto;
}

/* Button */
input[type="button"],
input[type="submit"],
input[type="reset"],
button,
.button {
    cursor: pointer;
    background-color: #d4d4d4;
    border-radius: 0.4em;
    text-align: center;
    box-shadow: inset 0px 0px 0px 1px rgba(255, 255, 255, 0.15);
    color: #000000;
    font-family: 'Open Sans Condensed', sans-serif;
    font-weight: 700;
    text-decoration: none;
    -moz-transition: background-color .25s ease-in-out, color .25s ease-in-out;
    -webkit-transition: background-color .25s ease-in-out, color .25s ease-in-out;
    -ms-transition: background-color .25s ease-in-out, color .25s ease-in-out;
    transition: background-color .25s ease-in-out, color .25s ease-in-out;
}

input[type="button"]:disabled, input[type="button"].disabled,
input[type="submit"]:disabled,
input[type="submit"].disabled,
input[type="reset"]:disabled,
input[type="reset"].disabled,
button:disabled,
button.disabled,
.button:disabled,
.button.disabled {
    opacity: 0.35;
    cursor: default;
}

input[type="button"]:hover,
input[type="submit"]:hover,
input[type="reset"]:hover,
button:hover,
.button:hover {
    background-color: #fffa70;
}

input[type="button"]:active,
input[type="submit"]:active,
input[type="reset"]:active,
button:active,
.button:active {
    background-color: #ffe771;
}

input[type="button"].alt,
input[type="submit"].alt,
input[type="reset"].alt,
button.alt,
.button.alt {
    background-color: #364050;
}

input[type="button"].alt:hover,
input[type="submit"].alt:hover,
input[type="reset"].alt:hover,
button.alt:hover,
.button.alt:hover {
    background-color: #465060;
}

input[type="button"].alt:active,
input[type="submit"].alt:active,
input[type="reset"].alt:active,
button.alt:active,
.button.alt:active {
    background-color: #263040;
}

/* List */
ul {
    list-style: disc;
    padding-left: 1em;
}

ul li {
    padding-left: 0.5em;
}

ol {
    list-style: decimal;
    padding-left: 1.25em;
}

ol li {
    padding-left: 0.25em;
}

/* Pagination */
.pagination .pages {
    display: inline-block;
    font-family: 'Open Sans Condensed', sans-serif;
    font-weight: 700;
}

.pagination .pages span {
    display: inline-block;
    width: 1.5em;
    text-align: center;
    margin: 0 0.4em 0 0;
}

.pagination .pages a {
    cursor: pointer;
    display: inline-block;
    text-align: center;
    text-decoration: none;
    color: inherit;
    background-color: #e8e8e8;
    color: #565656;
    margin: 0 0.4em 0 0;
    border-radius: 0.4em;
    -moz-transition: background-color .25s ease-in-out;
    -webkit-transition: background-color .25s ease-in-out;
    -ms-transition: background-color .25s ease-in-out;
    transition: background-color .25s ease-in-out;
    box-shadow: inset 0 0.075em 0.25em 0 rgba(0, 0, 0, 0.1);
}

.pagination .pages a:hover {
    background-color: #dadada;
}

.pagination .pages a.active {
    background-color: #364050;
    color: #000000;
    box-shadow: none;
    text-shadow: -1px -1px 0px rgba(0, 0, 0, 0.5);
}

/* Box */
.box.calendar .inner {
    position: relative;
    background-color: rgba(0, 0, 0, 0.15);
    border-radius: 0.4em;
    padding: 0.75em 0.5em 0.75em 0.5em;
    box-shadow: 0 0 0 1px rgba(255, 255, 255, 0.05), inset 0 0 0.25em 0 rgba(0, 0, 0, 0.25);
}

.box.calendar caption {
    font-weight: 700;
    color: #fff;
    margin: 0 0 0.25em 0;
}

.box.calendar tbody tr:nth-child(2n+2) {
    background: transparent;
}

.box.calendar table {
    margin: 0 auto;
}

.box.calendar td {
    cursor: default;
    padding: 0.35em 0 0.35em 0;
    border-top: solid 1px rgba(0, 0, 0, 0.25);
    box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.075);
    text-align: center;
}

.box.calendar th {
    cursor: default;
    padding: 0.35em 0 0.35em 0;
    border-top: solid 1px rgba(0, 0, 0, 0.25);
    box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.075);
    font-weight: 700;
    color: #fff;
    text-align: center;
}

.box.calendar td a, .box.calendar td span {
    display: block;
    margin: 0 auto;
    width: 1.5em;
    height: 1.5em;
    text-align: center;
    line-height: 1.4em;
    border-radius: 0.4em;
    -moz-transition: background-color .25s ease-in-out;
    -webkit-transition: background-color .25s ease-in-out;
    -ms-transition: background-color .25s ease-in-out;
    transition: background-color .25s ease-in-out;
    text-decoration: none;
}

.box.calendar td a {
    color: #fff;
    font-weight: 700;
}

    .box.calendar td a:hover {
        background-color: rgba(200, 225, 255, 0.1);
        color: #fff;
    }

.box.calendar td.today a {
    background-color: #ffde69;
    background-image: url("images/bg01.png");
    box-shadow: inset 0px 0px 0px 1px rgba(255, 255, 255, 0.15), 0 0.025em 0.15em 0em rgba(0, 0, 0, 0.25);
    color: #fff !important;
}

.box.post {
    position: relative;
}

.box.post .info .stats {
    margin: 0;
    cursor: default;
}

.box.post .info .stats a {
    font-size: 0.8em;
    text-decoration: none;
    color: #232323;
    font-weight: 700;
    line-height: 1em;
}

.box.recent-posts ul {
    list-style: none;
    padding-left: 0;
}

.box.recent-posts li {
    border-top: solid 1px rgba(0, 0, 0, 0.25);
    box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.075);
    padding: 0.5em 0 0.5em 0;
}

.box.recent-posts li:first-child {
    border-top: 0;
    box-shadow: none;
    padding-top: 0;
}

.box.recent-posts li:last-child {
    padding-bottom: 0;
}

.box.recent-comments ul {
    list-style: none;
    padding-left: 0;
}

.box.recent-comments li {
    border-top: solid 1px rgba(0, 0, 0, 0.25);
    box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.075);
    padding: 0.5em 0 0.5em 0;
}

.box.recent-comments li:first-child {
    border-top: 0;
    box-shadow: none;
    padding-top: 0;
}

.box.recent-comments li:last-child {
    padding-bottom: 0;
}

.box.search form {
    position: relative;
}

.box.search form input {
    position: relative;
    padding-right: 34px;
}

.box.search form:before {
    text-decoration: none;
    display: inline-block;
    font-family: 'Font Awesome 5 Free';
    font-size: 18px;
    font-weight: 900;
    text-decoration: none;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    content: '\f002';
    filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=0, mirror=1);
    -moz-transform: scale(-1, 1);
    -webkit-transform: scale(-1, 1);
    -ms-transform: scale(-1, 1);
    transform: scale(-1, 1);
    position: absolute;
    right: 0.5em;
    top: 0.25em;
    z-index: 1;
    text-shadow: none;
    color: #c8ccce;
}

.box.search form:before:before {
    -moz-osx-font-smoothing: grayscale;
    -webkit-font-smoothing: antialiased;
    display: inline-block;
    font-style: normal;
    font-variant: normal;
    text-rendering: auto;
    line-height: 1;
    text-transform: none;
    font-family: 'Font Awesome 5 Free';
    font-weight: 900;
}

.box.text-style1 .inner {
    position: relative;
    background-color: rgba(0, 0, 0, 0.15);
    border-radius: 0.4em;
    padding: 1.25em;
    box-shadow: 0 0 0 1px rgba(255, 255, 255, 0.05), inset 0 0 0.25em 0 rgba(0, 0, 0, 0.25);
}

/* Icons */
.icon {
    text-decoration: none;
    text-decoration: none;
}

.icon:before {
    -moz-osx-font-smoothing: grayscale;
    -webkit-font-smoothing: antialiased;
    display: inline-block;
    font-style: normal;
    font-variant: normal;
    text-rendering: auto;
    line-height: 1;
    text-transform: none;
    font-family: 'Font Awesome 5 Free';
    font-weight: 400;
}

.icon:before {
    line-height: normal;
}

.icon > .label {
    display: none;
}

.icon.solid:before {
    font-weight: 900;
}

.icon.brands:before {
    font-family: 'Font Awesome 5 Brands';
}

/* Nav */
#nav > ul > li > ul {
    display: none;
}

#nav ul {
    margin: 0;
    list-style: none;
    padding-left: 0;
}

#nav li {
    border-top: solid 1px rgba(0, 0, 0, 0.25);
    box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.075);
    padding: 0.5em 0 0.5em 0;
}

#nav li:first-child {
    border: 0;
    box-shadow: none;
    padding-top: 0;
}

#nav li:last-child {
    padding-bottom: 0;
}

#nav li a {
    display: block;
    padding: 0.4em 1em 0.4em 1em;
    text-decoration: none;
    border-radius: 0.4em;
    outline: 0;
    -moz-transition: background-color .25s ease-in-out, color .25s ease-in-out;
    -webkit-transition: background-color .25s ease-in-out, color .25s ease-in-out;
    -ms-transition: background-color .25s ease-in-out, color .25s ease-in-out;
    transition: background-color .25s ease-in-out, color .25s ease-in-out;
}

#nav li.current a {
    background-color: rgba(0, 0, 0, 0.15) !important;
    box-shadow: 0 0 0 1px rgba(255, 255, 255, 0.05), inset 0 0 0.25em 0 rgba(0, 0, 0, 0.25);
    font-weight: 700;
    color: #fff;
}

#nav li:hover a {
    background-color: rgba(255, 255, 255, 0.1);
    color: #fff;
}

/* Sidebar */
#titleBar {
    -moz-backface-visibility: hidden;
    -webkit-backface-visibility: hidden;
    -ms-backface-visibility: hidden;
    backface-visibility: hidden;
    -moz-transition: -moz-transform 0.5s ease;
    -webkit-transition: -webkit-transform 0.5s ease;
    -ms-transition: -ms-transform 0.5s ease;
    transition: transform 0.5s ease;
    display: none;
    height: 44px;
    left: 0;
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 10001;
    background: #364050 url("images/bg01.png");
}

#titleBar .title {
    display: block;
    color: #fff;
    line-height: 44px;
    font-size: 1.25em;
    font-family: 'Open Sans Condensed', sans-serif;
    font-weight: 700;
    letter-spacing: 0.1em;
    text-shadow: -1px -1px 0px rgba(0, 0, 0, 0.5);
    box-shadow: 0px 1px 4px 0px rgba(0, 0, 0, 0.25);
    text-align: center;
}

#titleBar .title a {
    color: inherit;
    text-decoration: none;
}

#titleBar .toggle {
    text-decoration: none;
    width: 80px;
    height: 60px;
    position: absolute;
    top: 0;
    left: 0;
}

#titleBar .toggle:before {
    -moz-osx-font-smoothing: grayscale;
    -webkit-font-smoothing: antialiased;
    display: inline-block;
    font-style: normal;
    font-variant: normal;
    text-rendering: auto;
    line-height: 1;
    text-transform: none;
    font-family: 'Font Awesome 5 Free';
    font-weight: 900;
}

#titleBar .toggle:before {
    text-decoration: none;
    content: '\f0c9';
    display: block;
    position: absolute;
    top: 7px;
    font-size: 14px;
    width: 50px;
    height: 30px;
    line-height: 30px;
    background: #ffe96e url("images/bg01.png");
    border-radius: 5px;
    color: #fff;
    text-align: center;
    box-shadow: inset 0px 0px 0px 1px rgba(255, 255, 255, 0.15), 0 0.025em 0.15em 0em rgba(0, 0, 0, 0.25);
    text-shadow: -1px -1px 0px rgba(0, 0, 0, 0.5);
    left: 7px;
}

#titleBar .toggle:active:before {
    background-color: #d95673;
}

#sidebar {
    color: rgba(255, 255, 255, 0.55);
    width: 14em;
    padding: 3em 1.35em 1em 1.15em;
    background: #364050 url("images/bg01.png");
    overflow-y: auto;
    left: 0;
    box-shadow: inset -0.1em 0em 0.35em 0em rgba(0, 0, 0, 0.15);
    -moz-order: -1;
    -webkit-order: -1;
    -ms-order: -1;
    order: -1;
    -moz-flex-grow: 0;
    -webkit-flex-grow: 0;
    -ms-flex-grow: 0;
    flex-grow: 0;
    -moz-flex-shrink: 0;
    -webkit-flex-shrink: 0;
    -ms-flex-shrink: 0;
    flex-shrink: 0;
}

#sidebar form input, #sidebar form select, #sidebar form textarea {
    border: 0;
}

#sidebar section, #sidebar nav {
    position: relative;
    margin: 2em 0 0 0;
    font-size: 0.9em;
}

    #sidebar section:before, #sidebar nav:before {
        content: '';
        border-top: solid 1px;
        border-bottom: solid 1px;
        border-color: rgba(0, 0, 0, 0.25);
        box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.075), 0px 1px 0px 0px rgba(255, 255, 255, 0.075);
        display: block;
        height: 0.5em;
        margin: 0 0 2em 0;
    }

#sidebar strong, #sidebar b {
    color: #fff;
}

#sidebar a {
    color: #d4dde0;
}

#sidebar h2, #sidebar h3, #sidebar h4, #sidebar h5, #sidebar h6 {
    color: #fff;
}

#sidebar header {
    margin: 0 0 1.25em 0;
}

/* Content */
#content {
    position: relative;
    background-color: #fff;
    width: 100%;
    -moz-flex-grow: 1;
    -webkit-flex-grow: 1;
    -ms-flex-grow: 1;
    flex-grow: 1;
    -moz-flex-shrink: 1;
    -webkit-flex-shrink: 1;
    -ms-flex-shrink: 1;
    flex-shrink: 1;
}

#content > .inner {
    position: relative;
    z-index: 1;
}

/* Desktop */
@media screen and (min-width: 737px) {

    /* Basic */
    body {
        height: 100%;
        line-height: 1.75em;
    }

    input, textarea, select {
        line-height: 1.75em;
    }

    h2 {
        font-size: 1.2em;
    }

    h3, h4, h5, h6 {
        font-size: 1em;
    }

    /* Button */
    input[type="button"],
    input[type="submit"],
    input[type="reset"],
    .button,
    button {
        display: inline-block;
        padding: 0.5em 2em 0.5em 2em;
    }

    input[type="button"].small,
    input[type="submit"].small,
    input[type="reset"].small,
    .button.small,
    button.small {
        font-size: 0.85em;
        padding: 0.35em 1.5em 0.35em 1.5em;
    }

    input[type="button"].big,
    input[type="submit"].big,
    input[type="reset"].big,
    .button.big,
    button.big {
        font-size: 1.25em;
        padding: 0.75em 2em 0.75em 2em;
    }

    input[type="button"].huge,
    input[type="submit"].huge,
    input[type="reset"].huge,
    .button.huge,
    button.huge {
        font-size: 1.5em;
        padding: 0.75em 2em 0.75em 2em;
    }

    /* Pagination */
    .pagination {
        padding: 3em 0 0 0;
    }

    .pagination .previous {
        margin-right: 0.6em;
    }

    .pagination .next {
        margin-left: 0.2em;
    }

    .pagination .pages a {
        width: 2.75em;
        height: 2.75em;
        line-height: 2.75em;
    }

    .pagination .button {
        height: 2.75em;
        padding-top: 0;
        padding-bottom: 0;
        line-height: 2.75em;
    }

    /* Box */
    .box.post .info .stats {
        list-style: none;
        padding-left: 0;
    }

    .box.post .info .stats li {
        padding-left: 0;
    }

    .box.post .info .stats li a {
        border-radius: 0.4em;
        opacity: 0.5;
        -moz-transition: opacity .25s ease-in-out, background-color .25s ease-in-out;
        -webkit-transition: opacity .25s ease-in-out, background-color .25s ease-in-out;
        -ms-transition: opacity .25s ease-in-out, background-color .25s ease-in-out;
        transition: opacity .25s ease-in-out, background-color .25s ease-in-out;
    }

    .box.post .info .stats li:hover a {
        background-color: #f4f4f4;
        opacity: 1.0;
    }

    /* Logo */
    #logo {
        font-family: 'Open Sans Condensed', sans-serif;
        font-weight: 700;
        font-size: 2em;
        letter-spacing: 0.1em;
    }

    #logo a {
        display: block;
        background-color: #f1da71;

        padding: 0.875em 0.25em;
        border-radius: 0.2em;
        text-align: center;
        box-shadow: inset 0px 0px 0px 1px rgba(255, 255, 255, 0.15), 0 0.025em 0.15em 0em rgba(0, 0, 0, 0.25);
        text-decoration: none;
        color: #000000;
    }

    /* Content */
    #content {
        box-shadow: 0 0 0.25em 0em rgba(0, 0, 0, 0.25);
    }

    #content > .inner {

        /*
                    This sets an upper limit on your page content to prevent it
                    from looking insane on really wide displays. It's currently set
                    to the width of the sample post images, but you can change it to
                    whatever you like (or remove it entirely).
                */

        max-width: 1038px;
    }

    /* Copyright */
    #copyright {
        margin: 2em 0 0 0;
        text-align: center;
    }

    #copyright p {
        font-size: 0.8em;
        line-height: 2em;
    }

    #copyright:before {
        height: 0.5em;
        margin: 0 0 2em 0;
    }
}

/* Wide */
@media screen and (min-width: 1201px) {

    /* Basic */
    body {
        min-width: 1200px;
        font-size: 12pt;
    }

    input, textarea, select {
        font-size: 12pt;
    }

    /* Box */
    .box.post h2 {
        font-size: 3.25em;
        line-height: 1.25em;
    }

    .box.post header {
        padding: 2.75em 0 0 0;
        margin: 0 0 3em 0;
    }

    .box.post header > p {
        font-size: 2.25em;
        line-height: 1.5em;
        position: relative;
        top: -0.65em;
        margin-bottom: -0.65em;
    }

    .box.post .info {
        position: absolute;
        width: 5.5em;
        overflow: hidden;
        background-color: #fff;

        left: -10.5em;
        top: 0;
        padding: 1.5em 1em 1.5em 1em;
        border-top-left-radius: 0.4em;
        border-bottom-left-radius: 0.4em;
        box-shadow: 0.25em 0 0 0 #fbfbfb, 0 0 0.25em 0em rgba(0, 0, 0, 0.25);
    }

    .box.post .info .date {
        position: relative;
        z-index: 1;
        font-family: 'Open Sans Condensed', sans-serif;
        font-weight: 400;
        text-align: center;
        display: block;
        font-size: 1.5em;
        color: #999;
        border-bottom: solid 1px #ddd;
        padding: 0 0 1em 0;
        margin: 0 0 0.75em 0;
    }

    .box.post .info .date .year,
    .box.post .info .date .month span {
        display: none;
    }

    .box.post .info .date .day {
        display: block;
        margin: 0.25em 0 0 0;
        font-size: 1.5em;
        font-weight: 700;
        color: #1b252a;
    }

    .box.post .info .stats {
        position: relative;
        z-index: 1;
    }

    .box.post .info .stats li {
        margin: 1.25em 0 0 0;
    }

    .box.post .info .stats li a {
        position: relative;
        display: block;
        text-align: right;
        padding: 0 0.5em 0 0.5em;
    }

    .box.post .info .stats li a:before {
        position: absolute;
        left: 0;
        top: 50%;
        margin-top: -0.5em;
        font-size: 16px;
        width: 1.5em;
        text-align: center;
        opacity: 0.35;
    }

    /* Content */
    #content {
        padding: 3em 5em 8em 5em;
    }
}

/* Narrow */
@media screen and (min-width: 737px) and (max-width: 1200px) {

    /* Basic */
    body {
        min-width: 1000px;
        font-size: 11pt;
    }

    input, textarea, select {
        font-size: 11pt;
    }

    /* Box */
    .box.post h2 {
        font-size: 3.25em;
        line-height: 1.25em;
    }

    .box.post header {
        padding: 1.5em 0 0 0;
        margin: 0 0 3em 0;
    }

    .box.post header > p {
        font-size: 1.75em;
        line-height: 1.5em;
        position: relative;
        top: -0.75em;
        margin-bottom: -0.75em;
    }

    .box.post .info {
        width: 100%;
        padding: 1em 0 0 0;
        position: relative;
        top: -2em;
    }

    .box.post .info .date {
        display: inline;
    }

    .box.post .info .stats {
        display: inline;
        border-left: solid 1px #ddd;
        margin-left: 1em;
        padding-left: 1em;
    }

    .box.post .info .stats li {
        display: inline-block;
        margin-left: 0.25em;
    }

    .box.post .info .stats li a {
        display: inline-block;
        padding-right: 0.5em;
    }

    .box.post .info .stats li a:before {
        position: relative;
        width: 1.75em;
        text-align: center;
        margin-right: 0.35em;
        opacity: 0.35;
    }

    /* Content */
    #content {
        padding: 2em 3em 6em 3em;
    }

}

/* Narrower */
@media screen and (min-width: 737px) and (max-width: 1000px) {

    /* Basic */
    body {
        min-width: 641px;
        font-size: 14pt;
    }

    input, textarea, select {
        font-size: 14pt;
    }

    /* Logo */
    #logo {
        display: none;
    }

    /* Nav */
    #nav {
        margin-top: 0 !important;
    }

    #nav:before {
        display: none !important;
    }

    #nav li:hover a {
        background: none;
    }

    /* Sidebar */
    #sidebar {
        padding: 30px 20px 30px 20px;
    }

}

/* Mobile */
@media screen and (max-width: 736px) {

    /* Basic */
    body, input, textarea, select {
        line-height: 1.75em;
        font-size: 11pt;
        letter-spacing: 0;
    }

    h2, h3, h4, h5, h6 {
        font-size: 1.5em;
    }

    /* Section/Article */
    section, article {
        clear: both;
    }

    /* Button */
    input[type="button"],
    input[type="submit"],
    input[type="reset"],
    button,
    .button {
        display: block;
        width: 100%;
        font-size: 1.25em;
        padding: 0.75em 0 0.75em 0;
        margin: 0.5em 0 0.5em 0;
    }

    /* Pagination */
    .pagination .pages {
        display: none;
    }

    /* Box */
    .box.post {
        padding-bottom: 5em;
        margin-bottom: 4em;
    }

    .box.post header > p {
        font-size: 1em;
        font-family: 'Source Sans Pro', sans-serif;
        line-height: 1.5em;
    }

    .box.post .info {
        width: 100%;
        position: absolute;
        bottom: 0;
        left: 0;
        border-top: solid 1px #ddd;
        padding-top: 0.5em;
    }

    .box.post .info .date {
        display: inline;
    }

    .box.post .info .date .year, .box.post .info .date .month span {
        display: none;
    }

    .box.post .info .stats {
        display: inline;
        border-left: solid 1px #ddd;
        margin-left: 0.75em;
        padding-left: 0.75em;
    }

    .box.post .info .stats li {
        display: inline-block;
        margin-right: 0.85em;
    }

    .box.post .info .stats li a {
        display: inline-block;
        opacity: 0.5;
    }

    .box.post .info .stats li a:before {
        position: relative;
        top: 0.1em;
        margin-right: 0.5em;
        opacity: 0.35;
    }

    .box.post .info .stats li a:active {
        opacity: 1.0;
    }

    /* Logo */
    #logo {
        display: none;
    }

    /* Nav */
    #nav {
        margin-top: 0 !important;
    }

    #nav:before {
        display: none !important;
    }

    #nav li:hover a {
        background: none;
    }

    /* Content */
    #content {
        margin-top: 44px;
        padding: 3em 20px 2em 20px;
    }

    /* Sidebar */
    #sidebar {
        padding: 20px 12px 20px 10px;
        box-shadow: inset -1px 0 0 0 rgba(255, 255, 255, 0.15), inset -0.1em 0 0.5em 0 rgba(0, 0, 0, 0.25);
    }
}

/* Off-Canvas Sidebar */
@media screen and (max-width: 1000px) {

    /* Basic */
    html, body {
        overflow-x: hidden;
    }

    /* Content */
    #content {
        -moz-backface-visibility: hidden;
        -webkit-backface-visibility: hidden;
        -ms-backface-visibility: hidden;
        backface-visibility: hidden;
        -moz-transition: -moz-transform 0.5s ease;
        -webkit-transition: -webkit-transform 0.5s ease;
        -ms-transition: -ms-transform 0.5s ease;
        transition: transform 0.5s ease;
        margin-top: 44px;
        margin-left: 0;
        margin-right: 0;
        min-height: 0 !important;
    }

    /* Sidebar */
    #titleBar {
        display: block;
    }

    #sidebar {
        -moz-backface-visibility: hidden;
        -webkit-backface-visibility: hidden;
        -ms-backface-visibility: hidden;
        backface-visibility: hidden;
        -moz-transition: -moz-transform 0.5s ease;
        -webkit-transition: -webkit-transform 0.5s ease;
        -ms-transition: -ms-transform 0.5s ease;
        transition: transform 0.5s ease;
        display: block;
        height: 100% !important;
        min-height: 0 !important;
        overflow-y: auto;
        position: fixed;
        top: 0;
        z-index: 10002;
        -moz-transform: translateX(-14em);
        -webkit-transform: translateX(-14em);
        -ms-transform: translateX(-14em);
        transform: translateX(-14em);
    }

    body.sidebar-visible #content, body.sidebar-visible #titleBar {
        -moz-transform: translateX(14em);
        -webkit-transform: translateX(14em);
        -ms-transform: translateX(14em);
        transform: translateX(14em);
    }

    body.sidebar-visible #sidebar {
        -moz-transform: translateX(0);
        -webkit-transform: translateX(0);
        -ms-transform: translateX(0);
        transform: translateX(0);
    }


	/* GLOBAL STYLES
    -------------------------------------------------- */
    /* Padding below the footer and lighter body text */


    /* CUSTOMIZE THE CAROUSEL
    -------------------------------------------------- */

    /* Carousel base class */
    .carousel {
        margin-bottom: 4rem;
    }
    /* Since positioning the image, we need to help out the caption */
    .carousel-caption {
        bottom: 3rem;
        z-index: 10;
    }

    /* Declare heights because of positioning of img element */
    .carousel-item {
        height: 32rem;
    }

    carousel-control-next, .carousel-control-prev {
        position: absolute;
        top: 0;
        bottom: 0;
        z-index: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        width: 50px;
        padding: 0;
        color: #fff;
        text-align: center;
        background: 0 0;
        border: 0;
        opacity: .5;
        transition: opacity .15s ease;
    }

    /* RESPONSIVE CSS
    -------------------------------------------------- */

    @media (min-width: 40em) {
        /* Bump up size of carousel content */
        .carousel-caption p {
            margin-bottom: 1.25rem;
            font-size: 1.25rem;
            line-height: 1.4;
        }

        .featurette-heading {
            font-size: 50px;
        }
    }

    @media (min-width: 62em) {
        .featurette-heading {
            margin-top: 7rem;
        }
    }
}

</style>