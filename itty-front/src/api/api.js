import axios from "axios";

const baseUri = 'http://localhost:8888/';
const endpoint = {
    // login
    healthCheck: 'health_check',
    login: 'login',
    regist: 'regist',
    withdrawal: 'user/withdrawal',

    // user
    user: 'user/',
    userModify: 'user/modify',
    getFollowersEndpoint: function(userCode) {
        return `follow/${userCode}/followers`;
    },
    getFollowingsEndpoint: function(userCode) {
        return `follow/${userCode}/followings`
    }
}

function getApiUri(apiEndpoint) {
    return baseUri + apiEndpoint;
}

function sendGetRequest(apiUri, responseCallback, errorCallback) {
    axios.get(apiUri).then(responseCallback).catch(errorCallback);
}

function sendPostRequest(apiUri, data, responseCallback, errorCallback) {
    axios.post(apiUri, data).then(responseCallback).catch(errorCallback);
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
    // const newUserInfo = {
    //     userCodePk: 32,
    //     userNickname: "하이하이",
    //     userIntroduction: "안녕하시오."
    // }

    const uri = getApiUri(endpoint.userModify);
    sendPostRequest(uri, newUserInfo, responseCallback, errorCallback);
}

export function getFollowersByUserCode(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getFollowersEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

export function getFollowingsByUserCode(userCode, responseCallback, errorCallback) {
    const uri = getApiUri(endpoint.getFollowingsEndpoint(userCode));
    sendGetRequest(uri, responseCallback, errorCallback);
}

