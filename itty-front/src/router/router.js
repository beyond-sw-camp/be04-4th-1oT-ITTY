import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/Home.vue';
import Login from '@/pages/Login.vue';

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
        }
    ]
});

export default router;