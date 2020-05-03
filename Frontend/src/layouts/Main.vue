<template>
  <q-layout view="hHh LpR fFf">
    <q-header class="bg-black bb-w font-tech relative-position">
      <q-toolbar>
        <q-toolbar-title>
          <div class="text-h4 font-bitmgothic q-mb-sm q-mt-md">
            Ribenteuer
          </div>
        </q-toolbar-title>
        <div class="text-subtitle1 absolute-center" v-if="userAuthenticated">
          {{ randomGreeting }}
        </div>
        <q-btn
          color="dark"
          class="text-white"
          outline
          label="Log Out"
          :icon-right="icons.doorOpen"
          v-if="userAuthenticated"
          @click="logOut"
        ></q-btn>
      </q-toolbar>
    </q-header>
    <q-page-container class="font-tech">
      <router-view></router-view>
    </q-page-container>
    <q-footer class="bg-black bt-w">
      <q-toolbar>
        <div class="full-width text-center font-tech">
          Ribenteuer 2020
        </div>
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script>
import notifyUtils from '../mixins/notify';

export default {
  name: 'appMainLayout',
  mixins: [notifyUtils],
  data() {
    return {
      icons: {},
      greetings: [
        "what's poppin'?",
        "what's cooking?",
        "what's the haps?",
        'salutations',
        'hola',
        'greetings',
        "What's in the bag?",
        'wassap?',
        "what's happening?",
        "what's the dizzle?",
        'good day',
        "what's the rumpus?"
      ]
    };
  },
  computed: {
    userNickname() {
      return this.$store.getters['userScope/getUserData'].nickname;
    },
    randomGreeting() {
      let greeting = this.greetings[Math.floor(Math.random() * this.greetings.length)];

      if (greeting.indexOf('?') > 0) {
        greeting = `${greeting.replace('?', '')}, ${this.userNickname}?`;
      } else {
        greeting = `${greeting}, ${this.userNickname}`;
      }

      return greeting.charAt(0).toUpperCase() + greeting.substring(1);
    },
    userAuthenticated() {
      return this.$store.getters['userScope/getAuthenticationStatus'];
    }
  },
  methods: {
    logOut() {
      this.$store
        .dispatch('userScope/signOut')
        .then(response => {
          if (response.status === 200) {
            this.notifySuccess(response.message);
            this.$router.push('/');
          }
        })
        .catch(error => {
          this.notifyError(error.message);
        });
    }
  },
  created() {
    this.$q.dark.set(true);
    const icons = this.$store.getters['iconsScope/getIcons'];
    this.icons.doorOpen = icons.doorOpen;
  }
};
</script>

<style lang="scss">
.ba-w {
  border: 1px solid white !important;
}

.bt-w {
  border-top: 1px solid white !important;
}

.bb-w {
  border-bottom: 1px solid white !important;
}

.bl-w {
  border-left: 1px solid white !important;
}
</style>
