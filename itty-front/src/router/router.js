import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/Home.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        /* Main */
        {
            path: '/',
            component: Home
        }
    ]
});

export default router;