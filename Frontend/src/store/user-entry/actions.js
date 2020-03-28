import axios from 'axios';

function makeRequest(
  axiosFunction,
  { requestId, successStatus, successMessage, errorMessage, storeRelatedAction }
) {
  return new Promise((resolve, reject) => {
    axiosFunction
      .then(response => {
        if (response.status === successStatus) {
          if (storeRelatedAction) {
            storeRelatedAction(response.data);
          }

          resolve({
            requestId,
            status: response.status,
            message: successMessage,
            customStatus: 'RF-G',
            data: response.data
          });
        } else {
          reject({
            requestId,
            status: response.status,
            message: errorMessage,
            customStatus: 'RF-B'
          });
        }
      })
      .catch(error => {
        reject({
          requestId,
          status: error.response.status,
          message: errorMessage,
          customStatus: 'RNF-E',
          error
        });
      });
  });
}

export function signInUser({ commit }, userData) {
  return makeRequest(axios.post('/api/sign-in', userData), {
    requestId: 'sign-in',
    successStatus: 200,
    successMessage: 'You were successfully signed in! ✨',
    errorMessage: 'Oops 😬. An error occurred during the sign in. Please contact the support',
    storeRelatedAction: () => {
      commit('SET_AUTHENTICATION_STATUS', true);
    }
  });
}

export function signUpUser({ commit }, userData) {
  return makeRequest(axios.post('/api/sign-up', userData), {
    requestId: '/api/sign-up',
    successStatus: 201,
    successMessage: 'You were successfully signed up! ✨',
    errorMessage: 'Oops 😬. An error occurred during the sign up. Please contact the support',
    storeRelatedAction: () => {
      commit('SET_AUTHENTICATION_STATUS', true);
    }
  });
}
