export function CLEAR_DATA(state) {
  state.characterData = {};
  state.characterInGame = false;
}

export function SET_CHARACTER_DATA(state, characterData) {
  state.characterData = { ...characterData };
}

export function UPDATE_SKILL(state, { skillData, oldSkillName }) {
  const { skills } = state.characterData;
  for (let i = 0; i < skills.length; i += 1) {
    if (skills[i].name === oldSkillName) {
      state.characterData.freeSkillPoints -= skills[i].cost;
      skills[i] = skillData;
    }
  }
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

export function EQUIP_ITEM(state, itemId) {
  const { items } = state.characterData;
  for (let i = 0; i < items.length; i += 1) {
    if (items[i].id === itemId) {
      items[i].equiped = true;
    }
  }
}

export function UNEQUIP_ITEM(state, itemId) {
  const { items } = state.characterData;
  for (let i = 0; i < items.length; i += 1) {
    if (items[i].id === itemId) {
      items[i].equiped = false;
    }
  }
}
