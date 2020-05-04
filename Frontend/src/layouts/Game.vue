<template>
  <q-layout view="hHh LpR fFf">
    <q-header class="bg-black bb-w q-py-xs">
      <q-toolbar class="font-tech">
        <q-toolbar-title>
          <div class="text-h4 font-bitmgothic q-mb-sm q-mt-md">
            Ribenteuer
          </div>
        </q-toolbar-title>
        <q-btn
          class="q-ml-md"
          label="Inventory"
          outline
          :icon-right="icons.boxes"
          :to="`/user/character/${characterData.id}`"
        >
        </q-btn>
        <q-btn class="q-ml-md" label="Log Out" outline :icon-right="icons.doorOpen" @click="logOut">
        </q-btn>
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
  name: 'appGameLayout',
  mixins: [notifyUtils],
  data() {
    return {
      icons: {}
    };
  },
  computed: {
    userNickname() {
      return this.$store.getters['userScope/getUserData'].nickname;
    },
    characterData() {
      return this.$store.getters['gameCharacterScope/getCharacterData'];
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
    const icons = this.$store.getters['iconsScope/getIcons'];

    this.icons.doorOpen = icons.doorOpen;
    this.icons.boxes = icons.boxes;
  }
};
</script>
