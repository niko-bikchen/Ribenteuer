export function SET_USER_DATA(state, userData) {
  state.userData = { ...userData };
}

export function SET_AUTHENTICATION_STATUS(state, status) {
  state.isAuthenticated = status;
}

export function SET_USER_CHARACTERS(state, userCharacters) {
  state.userCharacters = [...userCharacters];
}

export function CLEAR_DATA(state) {
  state.isAuthenticated = false;
  state.userData = {};
}
