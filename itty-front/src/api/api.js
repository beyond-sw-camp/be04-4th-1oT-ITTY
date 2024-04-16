import axios from "axios";

const baseUri = 'http://localhost:30001/';
const endpoint = {
    // login
    healthCheck: 'health_check',
    login: 'login',
    regist: 'regist',
    withdrawal: 'user/withdrawal',

    // user
    user: 'user/',
    userModify: 'user/modify',
    getUserLikeListEndpoint: function(userCode) {
        return `user/${userCode}/likes`;
    },
    getUserReplyListEndpoint: function(userCode) {
        return `user/${userCode}/replies`;
    },
    getUserArticleListEndpoint: function(userCode) {
        return `user/${userCode}/articles`;
    },
    getFollowersEndpoint: function(userCode) {
        return `follow/${userCode}/followers`;
    },
    getFollowingsEndpoint: function(userCode) {
        return `follow/${userCode}/followings`
    },

    // article
    article: 'article/bulletin',
    reply: 'reply',

}

function getApiUri(apiEndpoint) {
    return baseUri + apiEndpoint;
}

function sendGetRequest(apiUri, responseCallback, errorCallback) {
    axios.get(apiUri).then(responseCallback).catch(errorCallback);
}

function sendPostRequest(apiUri, data, responseCallback, errorCallback) {
    axios.post(apiUri, data, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(responseCallback)
    .catch(errorCallback);
}

function sendPutRequest(apiUri, data, responseCallback, errorCallback) {
    axios.put(apiUri, data).then(responseCallback).catch(errorCallback);
}

/**
 * Login
 */
export function healthCheck(responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.healthCheck);
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function login(userInfo, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.login);
    sendPostRequest(uri, userInfo, responseCallback, errorCallback);
}

export function regist(userInfo, responseCallback, errorCallback) {
    // const userInfo = {
    //     userEmail: "test013@example.com",
    //     userPassword: "test",
    //     userName: "testname",
    //     userPhoneNumber: "010-1234-1234",
    //     userNickname: "test"
    // }

    const uri = getApiUri(endpoint.regist);
    sendPostRequest(uri, userInfo, responseCallback, errorCallback);
}

export function withdrawal(userInfo, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.withdrawal);
    sendPostRequest(uri, userInfo, responseCallback, errorCallback);
}

/**
 * User
 */
export function findUserByUserCode(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.user + userCode);
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function modifyUserInfo(newUserInfo, responseCallback, errorCallback) {

    const uri = getApiUri(endpoint.userModify);
    sendPostRequest(uri, newUserInfo, responseCallback, errorCallback);
}

export function getUserLikeList(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getUserLikeListEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function getUserReplyList(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getUserReplyListEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function getUserArticleList(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getUserArticleListEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function getFollowersByUserCode(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getFollowersEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function getFollowingsByUserCode(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getFollowingsEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function getFollowers(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(`follow/${userCode}/followers`);
    getRequest(uri, responseCallback, errorCallback);
}

export function getFollowings(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(`follow/${userCode}/followings`);
    getRequest(uri, responseCallback, errorCallback);
}

export function article(articleData) {
    const uri = getApiUri(endpoint.article);
    return axios.post(uri, articleData, {
        headers: {
            'Content-Type': 'application/json' // JSON 형식 명시
        }
    });
}

export function fetchAllArticles() {
    const uri = getApiUri('article/bulletin');
    return axios.get(uri);
}

export function fetchArticleById(articleCodePk) {
   const uri = getApiUri(`article/bulletin/${articleCodePk}`); // API 엔드포인트 경로를 확인하고 맞춰주세요
    return axios.get(uri)
        .then(response => response.data)
        .catch(error => {
            console.error('Fetching article failed:', error);
            throw error; // 에러를 다시 던져 상위에서 처리할 수 있도록 함
        });
}

export function addCommentAPI(commentData) {
    const uri = baseUri + 'reply'; // 백엔드 엔드포인트 주소 확인 필요
    return axios.post(uri, commentData)
        .then(response => response.data)
        .catch(error => {
            console.error('Error adding comment:', error);
            throw error;
        });
}

export function addArticleLike(articleCode, userCode) {
    const uri = baseUri + 'article/bulletin/like';
    const data = {
        articleCode: articleCode,
        userCode: userCode
    };
    return axios.post(uri, data)
        .then(response => response.data)
        .catch(error => {
            console.error('Error adding article like:', error);
            throw error;
        });
}

export function deleteArticleLike(articleCode, userCode) {
    const uri = baseUri + 'article/bulletin/like';
    return axios.delete(uri, { data: { articleCode, userCode } })
        .then(response => response.data)
        .catch(error => {
            console.error('Error deleting article like:', error);
            throw error;
        });
}

export function fetchArticlesLikedByUser(userCode) {
    const uri = baseUri + `user/${userCode}`;
    return axios.get(uri)
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching liked articles:', error);
            throw error;
        });
}

export function fetchAllTrendArticles() {
    return axios.get(baseUri + `article/trend`)
        .then(response => response.data)  // 서버에서 받은 데이터를 반환
        .catch(error => {
            console.error('Failed to fetch trend articles:', error);
            throw error;  // 오류를 재발생시켜 호출 측에서 처리할 수 있도록 함
        });
}