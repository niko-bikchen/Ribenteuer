<template>
  <q-layout view="hHh LpR fFf">
    <q-header class="bg-black bb-w font-tech q-py-xs">
      <q-toolbar>
        <q-toolbar-title>
          <div class="text-h4 font-bitmgothic q-mb-sm q-mt-md">
            Ribenteuer
          </div>
        </q-toolbar-title>
        <div class="text-weight-bolder absolute-center text-center">
          <div style="display: inline-block">
            <span :class="{ 'text-light-blue-5': freeStatPoints > 0 }">
              Stats Points: {{ freeStatPoints }}
            </span>
            <br />
            <span :class="{ 'text-light-blue-5': freeSkillPoints > 0 }">
              Skill Points: {{ freeSkillPoints }}
            </span>
            <br />
            <span> Gold: {{ characterGold }} </span>
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
  name: 'appCharacterDashboardLayout',
  computed: {
    freeStatPoints() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].freeStatPoints;
    },
    freeSkillPoints() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].freeSkillPoints;
    },
    characterName() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].name;
    },
    characterGold() {
      return this.$store.getters['gameCharacterScope/getCharacterData'].gold;
    }
  }
};
</script>
