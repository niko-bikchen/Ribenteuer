import axios from 'axios';

function makeRequest(
  axiosFunction,
  { requestId, successStatus, successMessage, errorMessage, storeRelatedAction }
) {
  return new Promise((resolve, reject) => {
    axiosFunction
      .then(response => {
        if (response.status === successStatus) {
          storeRelatedAction(response);

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

export function fetchCharacterData({ commit }, characterId) {
  return makeRequest(axios.get(`/api/user/characters/${characterId}`), {
    requestId: 'fetch-character',
    successStatus: 200,
    successMessage: 'Successfully fetched character',
    errorMessage: 'Failed to fetch character',
    storeRelatedAction(response) {
      const { characterData } = response.data;
      characterData.class = characterData.characterClass;
      delete characterData.characterClass;

      commit('SET_CHARACTER_DATA', characterData);
    }
  });
}

export function updateCharacterData({ commit }, characterData) {
  return makeRequest(axios.put(`/api/user/characters/${characterData.id}`, characterData), {
    requestId: 'update-character',
    successStatus: 200,
    successMessage: 'Successfully updated character',
    errorMessage: 'Failed to update character',
    storeRelatedAction(response) {
      const character = response.data.characterData;
      character.class = character.characterClass;
      delete character.characterClass;

      commit('SET_CHARACTER_DATA', character);
    }
  });
}

export function updateCharacterSkill({ commit }, { characterId, skillData }) {
  return makeRequest(axios.put(`/api/user/characters/${characterId}/skills/`, skillData), {
    requestId: 'update-skill',
    successStatus: 200,
    successMessage: 'Successfully updated skill',
    errorMessage: 'Failed to update skill',
    storeRelatedAction(response) {
      commit('UPDATE_SKILL', { skillData: response.data.skillData, oldSkillName: skillData.name });
    }
  });
}

export function equipItem({ commit }, { characterId, itemId }) {
  return makeRequest(axios.put(`/api/user/characters/${characterId}/items/equip/${itemId}`), {
    requestId: 'equip-item',
    successStatus: 200,
    successMessage: 'Successfully equipped item',
    errorMessage: 'Failed to equip item',
    storeRelatedAction() {
      commit('EQUIP_ITEM', itemId);
    }
  });
}

export function unequipItem({ commit }, { characterId, itemId }) {
  return makeRequest(axios.put(`/api/user/characters/${characterId}/items/unequip/${itemId}`), {
    requestId: 'unequip-item',
    successStatus: 200,
    successMessage: 'Successfully unequipped item',
    errorMessage: 'Failed to unequip item',
    storeRelatedAction() {
      commit('UNEQUIP_ITEM', itemId);
    }
  });
}
