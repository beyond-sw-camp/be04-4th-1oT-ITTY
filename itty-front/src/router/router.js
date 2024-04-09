import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/Home.vue';
import TrendBoard from '@/pages/board/TrendBoard.vue';
import Login from '@/pages/Login.vue';
import MyPage from '@/pages/MyPage.vue';
import UserScrap from '@/components/mypage-content/UserScrap.vue';
import UserHistory from '@/components/mypage-content/UserHistory.vue';
import ModifyUserInfo from '@/components/mypage-content/ModifyUserInfo.vue';
import UserSignout from '@/components/mypage-content/UserSignout.vue';

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
        },
        /* Board */
        {
            path: '/trend-board',
            component: TrendBoard
        },
        {
            path: '/modifyuser',
            name: 'ModifyUserInfo',
            component: ModifyUserInfo
        },
        {
            path: '/userhistory',
            name: 'UserHistory',
            component: UserHistory
        },
        {
            path: '/scrap',
            name: 'UserScrap',
            component: UserScrap
        },
        {
            path: '/signout',
            name: 'UserSignout',
            component: UserSignout
        },
    ]
 
});

export default router;