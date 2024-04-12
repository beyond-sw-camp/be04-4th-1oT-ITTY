import axios from "axios";

const baseUri = 'http://localhost:8888/';
const endpoint = {
    // login
    healthCheck: 'health_check',
    regist: 'regist',

    // user
    user: 'user/',
    userModify: 'user/modify',
    userFollower: `user/${userCode}/follower`
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

    // axios.get(getApiUri(endpoint.healthCheck))
        // .then((response) => {
            // console.log(response);
        // }).catch((error) => {
            // console.log(error);
        // });
}

export function regist() {
    // test user object
    const userInfo = {
        userEmail: "test013@example.com",
        userPassword: "test",
        userName: "testname",
        userPhoneNumber: "010-1234-1234",
        userNickname: "test"
    }

    axios.post(
        getApiUri(endpoint.regist),
        userInfo
    ).then((response) => {
        console.log(response);
    }).catch((error) => {
        console.log(error);
    });
}

/**
 * User
 */
export function findUserByUserCode(userCode, responseCallback, errorCallback) {
    // const uri = getApiUri(endpoint.user + userCode);
    // getRequest(uri, responseCallback, errorCallback);

    axios.get(getApiUri(endpoint.user + userCode))
        .then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
}

export function modifyUserInfo() {
    const newUserInfo = {
        userCodePk: 32,
        userNickname: "하이하이",
        userIntroduction: "안녕하시오."
    }

    axios.post(
        getApiUri(endpoint.userModify),
        newUserInfo
    ).then((response) => {
        console.log(response);
    }).catch((error) => {
        console.log(error);
    });
}

// export function 