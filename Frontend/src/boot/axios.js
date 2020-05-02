import Vue from 'vue';
import axios from 'axios';

axios.defaults.baseURL = 'https://a7cefdc5-869a-49e8-af10-e2e7db3fd142.mock.pstmn.io';

Vue.prototype.$axios = axios;
