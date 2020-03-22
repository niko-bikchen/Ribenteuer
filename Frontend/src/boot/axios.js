import Vue from 'vue';
import axios from 'axios';

if (process.env.NODE_ENV !== 'development') {
  axios.defaults.baseURL = window.location.origin;
} else {
  axios.defaults.baseURL = 'https://d199c1a7-b3ad-4604-955d-bb5c0ac7e42d.mock.pstmn.io';
}

Vue.prototype.$axios = axios;
