import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/Home.vue';
import TrendBoard from '@/pages/board/TrendBoard.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        /* Main */
        {
            path: '/',
            component: Home
        },

        /* Board */
        {
            path: '/trend-board',
            component: TrendBoard
        }
    ]
});

export default router;