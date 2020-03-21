import Vue from 'vue';
import Vuex from 'vuex';
import userEntry from './user-entry';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    userEntry
  },

  strict: process.env.DEV
});
