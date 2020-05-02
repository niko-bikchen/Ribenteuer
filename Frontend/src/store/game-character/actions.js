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

export function fetchCharacterData({ commit }, characterId) {
  return makeRequest(axios.get(`/api/user/characters/${characterId}`), {
    requestId: 'fetch-character',
    successStatus: 200,
    successMessage: 'Successfully fetched character',
    errorMessage: 'Failed to fetch character',
    storeRelatedAction(response) {
      commit('SET_CHARACTER_DATA', response.data.characterData);
    }
  });
}

export function updateCharacterData({ commit }, characterData) {
  return makeRequest(axios.put(`/api/user/characters/${characterData.id}`, characterData), {
    requestId: 'update-character',
    successStatus: 200,
    successMessage: 'Successfully updated character',
    errorMessage: 'Failed to update character',
    storeRelatedAction(response) {
      commit('SET_CHARACTER_DATA', response.data.characterData);
    }
  });
}
