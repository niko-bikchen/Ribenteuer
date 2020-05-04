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
            storeRelatedAction(response);
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

export function signIn({ commit }, userData) {
  return makeRequest(axios.post('/api/auth/sign-in', userData), {
    requestId: 'sign-in',
    successStatus: 200,
    successMessage: 'You were successfully signed in! ✨',
    errorMessage: 'Oops 😬. An error occurred during the sign in. Please contact the support',
    storeRelatedAction(response) {
      commit('SET_AUTHENTICATION_STATUS', true);
      commit('SET_USER_DATA', response.data.userData);
      axios.defaults.headers.common.Authorization = response.headers.authorization;
    }
  });
}

export function signUp({ commit }, userData) {
  return makeRequest(axios.post('/api/auth/sign-up', userData), {
    requestId: 'sign-up',
    successStatus: 201,
    successMessage: 'You were successfully signed up! ✨',
    errorMessage: 'Oops 😬. An error occurred during the sign up. Please contact the support',
    storeRelatedAction(response) {
      commit('SET_AUTHENTICATION_STATUS', true);
      commit('SET_USER_DATA', response.data.userData);
      axios.defaults.headers.common.Authorization = response.headers.authorization;
    }
  });
}

export function signOut({ commit }) {
  return makeRequest(axios.post('/api/auth/sign-out'), {
    requestId: 'sign-out',
    successStatus: 200,
    successMessage: 'Successfully logged out',
    errorMessage: 'Failed to log out',
    storeRelatedAction() {
      commit('CLEAR_DATA');
      commit('gameCharacterScope/CLEAR_DATA', { root: true });
      commit('gameWorldScope/CLEAR_DATA', { root: true });
      axios.defaults.headers.common.Authorization = '';
    }
  });
}

export function fetchCharacters({ commit }) {
  return makeRequest(axios.get('/api/user/characters'), {
    requestId: 'fetch-characters',
    successStatus: 200,
    successMessage: 'Successfully fetched user characters',
    errorMessage: 'Failed to fetch user characters',
    storeRelatedAction(response) {
      const charactersData = response.data.userCharacters;
      for (let i = 0; i < charactersData.length; i += 1) {
        charactersData[i].class = charactersData[i].characterClass;
        delete charactersData[i].characterClass;
      }

      commit('SET_USER_CHARACTERS', charactersData);
    }
  });
}

export function createCharacter({ commit }, characterData) {
  return makeRequest(axios.post('/api/user/characters', characterData), {
    requestId: 'create-character',
    successStatus: 201,
    successMessage: 'Successfully created new character',
    errorMessage: 'Failed to create new character',
    storeRelatedAction(response) {
      const charactersData = response.data.userCharacters;
      for (let i = 0; i < charactersData.length; i += 1) {
        charactersData[i].class = charactersData[i].characterClass;
        delete charactersData[i].characterClass;
      }

      commit('SET_USER_CHARACTERS', charactersData);
    }
  });
}

export function deleteCharacter({ commit }, characterId) {
  return makeRequest(axios.delete(`/api/user/characters/${characterId}`), {
    requestId: 'delete-character',
    successStatus: 200,
    successMessage: 'Successfully deleted character',
    errorMessage: 'Failed to delete the character',
    storeRelatedAction(response) {
      const charactersData = response.data.userCharacters;
      for (let i = 0; i < charactersData.length; i += 1) {
        charactersData[i].class = charactersData[i].characterClass;
        delete charactersData[i].characterClass;
      }

      commit('SET_USER_CHARACTERS', charactersData);
    }
  });
}
