<template>
  <q-layout view="hHh LpR fFf">
    <q-header class="bg-transparent bb-w">
      <q-toolbar>
        <q-toolbar-title>
          <div class="text-h4 font-bitmgothic q-mb-sm q-mt-md">
            Ribenteuer
          </div>
        </q-toolbar-title>
      </q-toolbar>
    </q-header>
    <q-page-container>
      <router-view></router-view>
    </q-page-container>
    <q-footer class="bg-transparent bt-w">
      <q-toolbar>
        <div class="full-width text-center font-tech">
          Ribenteuer 2020
        </div>
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script>
import { laUserSolid } from '@quasar/extras/line-awesome';

export default {
  name: 'AppMainLayout',
  created() {
    this.$q.dark.set(true);

    this.userSolid = laUserSolid;
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
