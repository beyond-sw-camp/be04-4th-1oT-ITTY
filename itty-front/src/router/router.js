import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/Home.vue';
import TrendBoard from '@/pages/board/TrendBoard.vue';
import FreeBoard from '@/pages/board/FreeBoard.vue';
import NewArticle from '@/pages/board/NewArticle.vue';
import EventBoard from '@/pages/board/EventBoard.vue';
import Login from '@/pages/Login.vue';
import MyPage from '@/pages/MyPage.vue';
import UserInfo from '@/components/mypage-content/UserInfo.vue';
import UserScrap from '@/components/mypage-content/UserScrap.vue';
import UserHistory from '@/components/mypage-content/UserHistory.vue';
import UserQnA from '@/components/mypage-content/UserQnA.vue';
import ModifyUserInfo from '@/components/mypage-content/ModifyUserInfo.vue';
import UserSignout from '@/components/mypage-content/UserSignout.vue';
import SelectArticle from '@/pages/board/SelectArticle.vue';


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
            component: MyPage,
            children: [
                {
                path: '',
                component: UserInfo
                },
                {
                path: 'userscrap',
                component: UserScrap
                },
                {
                path: 'modifyuserinfo',
                component: ModifyUserInfo
                },
                {
                path: 'userhistory',
                component: UserHistory
                },
                {
                path: 'userqna',
                component: UserQnA
                },
                {
                path: 'usersignout',
                component: UserSignout
                },     
        ]
        },
        /* Board */
        {
            path: '/trend-board',
            component: TrendBoard
        },
        {
            path: '/free-board',
            component: FreeBoard,
        },
        {
            path: '/event-board',
            component: EventBoard
        },
        {
            path: '/free-board/new',
            component: NewArticle
        },
        {
            path: '/newArticle/',
            component: SelectArticle
        }
    ]
 
});

export default router;