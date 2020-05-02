<template>
  <q-layout view="hHh LpR fFf">
    <q-header class="bg-black bb-w font-tech">
      <q-toolbar>
        <q-toolbar-title>
          <div class="text-h4 font-bitmgothic q-mb-sm q-mt-md">
            Ribenteuer
          </div>
        </q-toolbar-title>
        <div class="text-weight-bolder text-yellow-8 absolute-center">
          <div style="display: inline-block">
            Stats Points: {{ freeStatPoints }}
            <br />
            Skill Points: {{ freeSkillPoints }}
          </div>
        </div>
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
export default {
  name: 'appCharacterDashboard',
  computed: {
    freeStatPoints() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].freeStatPoints;
    },
    freeSkillPoints() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].freeSkillPoints;
    },
    characterName() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].name;
    }
  }
};
</script>
