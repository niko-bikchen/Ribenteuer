export function getValidators(state) {
  return { ...state.validators };
}

export function getIcons(state) {
  return { ...state.icons };
}

export function getUserAuthenticationStatus(state) {
  return state.user.isAuthenticated;
}
