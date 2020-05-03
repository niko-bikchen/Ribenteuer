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
          <div class="row q-mt-lg text-light-blue-5">
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
            <div
              v-if="characterData.freeSkillPoints < clickedSkill.cost"
              class="q-mb-sm text-yellow-8"
            >
              You have not enough skill points to upgrade this skill
            </div>
            <q-btn
              label="Upgrade"
              outline
              size="lg"
              color="dark"
              class="text-white"
              :disable="characterData.freeSkillPoints < clickedSkill.cost"
              @click="showConfirm = true"
            >
            </q-btn>
          </div>
        </div>
        <div v-else>
          <div class="q-mt-lg text-center text-h4">Pick a Skill</div>
        </div>
      </div>
    </div>
    <q-dialog v-model="showConfirm" persistent>
      <q-card class="font-tech">
        <q-card-section class="row items-center">
          <span class="q-ml-sm">Are you sure you sure ?</span>
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="No" color="dark" class="text-white" v-close-popup />
          <q-btn
            label="Yeah"
            color="dark"
            class="text-white"
            outline
            v-close-popup
            @click="upgradeSkill"
          />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </q-page>
</template>

<script>
import FullHeightColumn from '../components/FullHeightColumn';
import notifyUtils from '../mixins/notify';

export default {
  name: 'appManageSkills',
  mixins: [notifyUtils],
  components: {
    appFullHeightColumn: FullHeightColumn
  },
  data() {
    return {
      characterData: {},
      columnsHeight: 0,
      currentTab: 'All',
      clickedSkill: {},
      showConfirm: false
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
    },
    upgradeSkill() {
      this.$store
        .dispatch('gameCharacterScope/updateCharacterSkill', {
          characterId: this.characterData.id,
          skillData: this.clickedSkill
        })
        .then(response => {
          if (response.status === 200) {
            this.notifySuccess(response.message);
            this.characterData.skills = this.$store.getters[
              'gameCharacterScope/getCharacterData'
            ].skills;
            this.clickedSkill = response.data.skillData;
          } else {
            this.notifyError(response.message);
          }
        })
        .catch(error => {
          this.notifyError(error.message);
        });
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
