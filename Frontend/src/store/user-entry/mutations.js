export function SET_USER_DATA(state, userData) {
  state.user = { ...state.user, ...userData };
}

export function SET_AUTHENTICATION_STATUS(state, status) {
  state.user.isAuthenticated = status;
}
