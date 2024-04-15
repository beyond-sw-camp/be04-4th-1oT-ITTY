import axios from "axios";

const baseUri = 'http://localhost:30001/';
const endpoint = {
    // login
    healthCheck: 'health_check',
    regist: 'regist',

    // user
    user: 'user/',
    userModify: 'user/modify',

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
    // const newUserInfo = {
    //     userCodePk: 32,
    //     userNickname: "하이하이",
    //     userIntroduction: "안녕하시오."
    // }

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
