import Vue from 'vue';
import Vuex from 'vuex';

import userScope from './user';
import gameWorldScope from './game-world';
import gameCharacterScope from './game-character';
import gameEncountersScope from './game-encounters';
import iconsScope from './icons';
import validationScope from './validation';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    userScope,
    gameWorldScope,
    gameCharacterScope,
    gameEncountersScope,
    iconsScope,
    validationScope
  },

  strict: process.env.DEV
});
