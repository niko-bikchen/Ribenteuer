import store from '../store/index';

const routes = [
  {
    path: '/',
    component: () => import('layouts/Main.vue'),
    children: [
      {
        path: '',
        component: () => import('pages/UserEntry.vue'),
        beforeEnter: (to, from, next) => {
          if (store.getters['userScope/getAuthenticationStatus']) {
            next('/user/characters');
          } else {
            next();
          }
        }
      },
      {
        path: '/user/characters',
        component: () => import('pages/UserCharacters.vue'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userScope/getAuthenticationStatus']) {
            next('/');
          } else {
            next();
          }
        }
      },
      {
        path: '/user/character-creation',
        component: () => import('pages/CharacterCreation'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userScope/getAuthenticationStatus']) {
            next('/');
          } else {
            next();
          }
        }
      }
    ]
  },
  {
    path: '/user/character/:id',
    component: () => import('layouts/CharacterDashboard.vue'),
    beforeEnter: (to, from, next) => {
      if (!store.getters['userScope/getAuthenticationStatus']) {
        next('/');
      } else {
        next();
      }
    },
    children: [
      {
        path: '',
        component: () => import('pages/CharacterGeneral'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userScope/getAuthenticationStatus']) {
            next('/');
          } else {
            next();
          }
        }
      },
      {
        path: 'items',
        component: () => import('pages/ManageItems'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userScope/getAuthenticationStatus']) {
            next('/');
          } else {
            next();
          }
        }
      },
      {
        path: 'skills',
        component: () => import('pages/ManageSkills'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userScope/getAuthenticationStatus']) {
            next('/');
          } else {
            next();
          }
        }
      }
    ]
  }
];

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  });
}

export default routes;
