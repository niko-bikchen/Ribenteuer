import axios from 'axios';

export function signInUser({ commit }, userData) {
  return new Promise((resolve, reject) => {
    axios
      .post('/api/sign-in', {
        email: userData.email,
        password: userData.password
      })
      .then(response => {
        if (response.status === 200) {
          commit('SET_AUTHENTICATION_STATUS', true);

          resolve({
            process: 'sign-in',
            status: response.status,
            message: 'You were successfully signed in! ✨'
          });
        } else {
          reject({
            process: 'sign-in',
            status: response.status,
            message: 'Oops 😬. An error occured during the sign in. Please contact the support'
          });
        }
      })
      .catch(error => {
        reject({
          process: 'sign-in',
          status: error.response.status,
          message: 'Oops 😬. An error occured during the sign in. Please contact the support',
          error
        });
      });
  });
}

export function signUpUser({ commit }, userData) {
  return new Promise((resolve, reject) => {
    axios
      .post('/api/sign-up', {
        email: userData.email,
        password: userData.password
      })
      .then(response => {
        if (response.status === 201) {
          commit('SET_AUTHENTICATION_STATUS', true);

          resolve({
            process: 'sign-up',
            status: response.status,
            message: 'You were successfully signed up! ✨'
          });
        } else {
          reject({
            process: 'sign-up',
            status: response.status,
            message: 'Oops 😬. An error occured during the sign up. Please contact the support'
          });
        }
      })
      .catch(error => {
        reject({
          process: 'sign-up',
          status: error.response.status,
          message: 'Oops 😬. An error occured during the sign up. Please contact the support',
          error
        });
      });
  });
}
