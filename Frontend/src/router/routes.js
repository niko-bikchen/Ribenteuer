import store from '../store/index';

const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        component: () => import('pages/UserEntry.vue'),
        beforeEnter: (to, from, next) => {
          if (store.getters['userEntry/getUserAuthenticationStatus']) {
            next('/characters');
          } else {
            next();
          }
        }
      },
      {
        path: 'characters',
        component: () => import('pages/UserCharacters.vue'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userEntry/getUserAuthenticationStatus']) {
            next('/');
          } else {
            next();
          }
        }
      },
      {
        path: 'character-creation',
        component: () => import('pages/CharacterCreation'),
        beforeEnter: (to, from, next) => {
          if (!store.getters['userEntry/getUserAuthenticationStatus']) {
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
