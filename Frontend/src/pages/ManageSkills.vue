<template>
  <q-page>
    <div class="row">
      <div class="col-6 b-r-w">
        <div id="items-list-filters">
          <q-tabs
            v-model="currentTab"
            dense
            class="text-grey"
            active-color="white"
            indicator-color="white"
            align="justify"
            narrow-indicator
          >
            <q-tab name="All" label="All" />
            <q-tab name="Damage" label="Damage" />
            <q-tab name="Heal" label="Heal" />
          </q-tabs>
        </div>
        <q-separator />
        <q-tab-panels v-model="currentTab" animated transition-prev="fade" transition-next="fade">
          <q-tab-panel
            :name="tabName"
            class="q-pa-none"
            v-for="tabName in ['All', 'Damage', 'Heal']"
            :key="tabName"
          >
            <app-full-height-column column-header-id="items-list-filters" :bottom-offset="2">
              <q-list separator>
                <q-item>
                  <q-item-section>
                    <q-item-label class="text-grey">Name</q-item-label>
                  </q-item-section>
                </q-item>
                <q-item
                  clickable
                  v-for="skill in characterXSkills(tabName)"
                  :key="skill.id"
                  @click="showSkill(skill)"
                >
                  <q-item-section>
                    <q-item-label>{{ skill.name }}</q-item-label>
                    <q-item-label caption>{{ skill.category }}</q-item-label>
                  </q-item-section>
                </q-item>
              </q-list>
            </app-full-height-column>
          </q-tab-panel>
        </q-tab-panels>
      </div>
      <div class="col-6 relative-position">
        <div class="q-pt-lg q-px-md" v-if="clickedSkill.name !== undefined">
          <div class="text-center">
            <div class="text-h4">
              {{ clickedSkill.name }}
            </div>
            <div class="text-subtitle2">
              {{ clickedSkill.category }}
            </div>
          </div>
          <div class="row q-mt-lg">
            <div class="col-6 text-right">Upgrade Cost:</div>
            <div class="col-6 q-pl-lg">{{ clickedSkill.cost }} Skill Points</div>
          </div>
          <div class="q-mt-lg">
            <div class="text-caption q-mb-xs">
              Description
            </div>
            <p>
              {{ clickedSkill.description }}
            </p>
          </div>
          <div class="q-mb-lg text-center absolute-bottom">
            <q-btn label="Upgrade" outline size="lg" color="dark" class="text-white"></q-btn>
          </div>
        </div>
        <div v-else>
          <div class="q-mt-lg text-center text-h4">Pick a Skill</div>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
import FullHeightColumn from '../components/FullHeightColumn';

export default {
  name: 'appManageSkills',
  components: {
    appFullHeightColumn: FullHeightColumn
  },
  data() {
    return {
      characterData: {},
      columnsHeight: 0,
      currentTab: 'All',
      clickedSkill: {}
    };
  },
  methods: {
    characterXSkills(category) {
      const skills = [...this.characterData.skills].sort((skillA, skillB) =>
        skillA.name.localeCompare(skillB.name)
      );

      if (category !== 'All') {
        return skills.filter(skill => skill.category === category);
      }
      return skills;
    },
    showSkill(skill) {
      this.clickedSkill = skill;
    }
  },
  created() {
    this.characterData = this.$store.getters['gameCharacterScope/getCharacterData'];

    const header = document.getElementsByTagName('header')[0];
    const footer = document.getElementsByTagName('footer')[0];
    const app = document.getElementById('q-app');

    this.columnsHeight = app.offsetHeight - (header.offsetHeight + footer.offsetHeight) - 100;
  }
};
</script>
