export function getCharacters(state) {
  return [...state.userCharacters];
}

export function getAuthenticationStatus(state) {
  return state.isAuthenticated;
}
