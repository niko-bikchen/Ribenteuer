import Vue from 'vue';
import Vuex from 'vuex';

import userEntry from './user-entry';
import userCharacters from './user-characters';
import globalStore from './global';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    userEntry,
    userCharacters,
    globalStore
  },

  strict: process.env.DEV
});
