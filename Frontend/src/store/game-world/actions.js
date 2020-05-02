import axios from 'axios';

function makeRequest(
  axiosFunction,
  { requestId, successStatus, successMessage, errorMessage, storeRelatedAction }
) {
  return new Promise((resolve, reject) => {
    axiosFunction
      .then(response => {
        if (response.status === successStatus) {
          storeRelatedAction(response);

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

export function fetchCharacterClasses({ commit }) {
  return makeRequest(axios.get('/api/game/classes'), {
    requestId: 'fetch-classes',
    successStatus: 200,
    successMessage: 'Successfully fetched character classes from the server',
    errorMessage: 'Failed to fetch character classes from the server.',
    storeRelatedAction(response) {
      commit('SET_CLASSES', response.data.characterClasses);
    }
  });
}
