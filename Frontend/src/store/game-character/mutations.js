export function SET_CHARACTER_DATA(state, characterData) {
  state.characterData = { ...characterData };
}

export function INCREASE_STAT_POINTS(state) {
  state.characterData.freeStatPoints += 1;
}

export function DECREASE_STAT_POINTS(state) {
  state.characterData.freeStatPoints -= 1;
}

export function INCREASE_STAT(state, stat) {
  state.characterData.stats[stat] += 1;
}

export function DECREASE_STAT(state, stat) {
  state.characterData.stats[stat] -= 1;
}
