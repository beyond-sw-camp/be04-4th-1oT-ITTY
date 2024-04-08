import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/Home.vue';
import TrendBoard from '@/pages/board/TrendBoard.vue';
import Login from '@/pages/Login.vue';
import MyPage from '@/pages/MyPage.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        /* Main */
        {
            path: '/',
            component: Home
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/mypage',
            component: MyPage
        }
s
        /* Board */
        {
            path: '/trend-board',
            component: TrendBoard
        },
    ]
});

export default router;