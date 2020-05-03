export function CLEAR_DATA(state) {
  state.characterClasses = [];
  state.locations = [];
}

export function SET_CLASSES(state, characterClasses) {
  state.characterClasses = [...characterClasses];
}

export function SET_LOCATIONS(state, locationsData) {
  state.locations = [...locationsData];
}
