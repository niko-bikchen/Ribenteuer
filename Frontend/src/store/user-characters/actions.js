import axios from 'axios';

export function fetchCharactersPreviews({ commit }) {
  return new Promise((resolve, reject) => {
    axios
      .get('/api/get-characters-previews')
      .then(response => {
        if (response.status === 200) {
          commit('SET_USER_CHARACTERS', response.data);

          resolve({
            process: 'fetch-characters',
            status: response.status,
            fetched: true
          });
        } else {
          reject({
            process: 'fetch-characters',
            status: response.status,
            fetched: false
          });
        }
      })
      .catch(error => {
        reject({
          process: 'fetch-characters',
          status: error.response.status,
          fetched: false,
          message:
            'Oops 😬. An error occured while fetching your characters from the server. Please contact the support',
          error
        });
      });
  });
}
