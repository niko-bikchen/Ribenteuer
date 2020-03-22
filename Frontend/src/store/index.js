import Vue from 'vue';
import Vuex from 'vuex';

import userEntry from './user-entry';
import userCharacters from './user-characters';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    userEntry,
    userCharacters
  },

  strict: process.env.DEV
});
