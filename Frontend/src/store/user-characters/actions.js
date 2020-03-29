import axios from 'axios';

function makeRequest(
  axiosFunction,
  { requestId, successStatus, successMessage, errorMessage, storeRelatedAction }
) {
  return new Promise((resolve, reject) => {
    axiosFunction
      .then(response => {
        if (response.status === successStatus) {
          storeRelatedAction(response.data);

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

export function fetchCharactersPreviews({ commit }) {
  return makeRequest(axios.get('/api/get-characters-descriptions'), {
    requestId: 'fetch-characters-previews',
    successStatus: 200,
    successMessage: '',
    errorMessage:
      'Oops 😬. An error occurred while fetching your characters from the server. Please contact the support',
    storeRelatedAction: data => {
      commit('SET_USER_CHARACTERS_DESCRIPTIONS', data.characterDescriptions);
    }
  });
}

export function fetchClassesDescriptions({ commit }) {
  return makeRequest(axios.get('/api/get-classes-descriptions'), {
    requestId: 'fetch-classes-descriptions',
    successStatus: 200,
    successMessage: '',
    errorMessage:
      'Oops 😬. An error occurred while fetching character classes from the server. Please contact the support',
    storeRelatedAction: data => {
      commit('SET_CLASSES_DESCRIPTIONS', data.classesDescriptions);
    }
  });
}

export function fetchClasses({ commit }) {
  return makeRequest(axios.get('/api/get-classes'), {
    requestId: 'fetch-classes',
    successStatus: 200,
    successMessage: '',
    errorMessage:
      'Oops 😬. An error occurred while fetching classes from the server. Please contact the support',
    storeRelatedAction: data => {
      commit('SET_CLASSES', data.classes);
    }
  });
}
