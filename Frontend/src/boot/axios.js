import Vue from 'vue';
import axios from 'axios';

axios.defaults.baseURL = 'https://244d2cdf-986e-4b13-8121-209685c5ddaf.mock.pstmn.io';

Vue.prototype.$axios = axios;
