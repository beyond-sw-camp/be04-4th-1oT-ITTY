import axios from "axios";

const baseUri = 'http://localhost:30001/';
const endpoint = {
    // login
    healthCheck: 'health_check',
    regist: 'regist',

    // user
    user: 'user/',
    userModify: 'user/modify',

    // article
    article: 'article/bulletin',
    reply: 'reply'
}

function getApiUri(apiEndpoint) {
    return baseUri + apiEndpoint;
}

function getRequest(apiUri, responseCallback, errorCallback) {
    axios.get(apiUri).then(responseCallback).catch(errorCallback);
}

function postRequest(apiUri, data, responseCallback, errorCallback) {
    axios.post(apiUri, data).then(responseCallback).catch(errorCallback);
}

/**
 * Login
 */
export function healthCheck(responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.healthCheck);
    getRequest(uri, responseCallback, errorCallback);
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
    postRequest(uri, userInfo, responseCallback, errorCallback);
}

/**
 * User
 */
export function findUserByUserCode(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.user + userCode);
    getRequest(uri, responseCallback, errorCallback);
}

export function modifyUserInfo(newUserInfo, responseCallback, errorCallback) {

    const uri = getApiUri(endpoint.userModify);
    postRequest(uri, newUserInfo, responseCallback, errorCallback);
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
    const uri = `http://localhost:30001/reply`; // 백엔드 엔드포인트 주소 확인 필요
    return axios.post(uri, commentData)
        .then(response => response.data)
        .catch(error => {
            console.error('Error adding comment:', error);
            throw error;
        });
}