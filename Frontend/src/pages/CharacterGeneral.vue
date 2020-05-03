<template>
  <q-page>
    <div class="row">
      <div class="col-4">
        <div
          id="items-col-header"
          class="list-title q-pa-md text-center text-subtitle1 text-uppercase b-b-w"
        >
          Equipped Items
        </div>
        <div class="text-center" v-if="showProgress">
          <q-circular-progress indeterminate size="50px" color="white" class="q-ma-md" />
        </div>
        <app-full-height-column :bottom-offset="100" column-header-id="items-col-header">
          <app-items-list
            :list-header="'Weapon'"
            :items-list="getItemsOfACategory('Weapon')"
          ></app-items-list>
          <app-items-list
            :list-header="'Armour'"
            :items-list="getItemsOfACategory('Armour')"
          ></app-items-list>
        </app-full-height-column>
        <div style="height: 100px;" class="text-center q-py-lg">
          <q-btn
            label="Edit"
            size="lg"
            color="dark"
            class="text-white"
            :to="`/user/character/${$route.params.id}/items`"
            outline
          ></q-btn>
        </div>
      </div>
      <div class="col-4 b-l-w b-r-w">
        <p
          id="char-col-header"
          class="q-pa-md q-mb-none text-center text-subtitle1 text-uppercase b-b-w"
        >
          Character Info & Stats
        </p>
        <app-full-height-column column-header-id="char-col-header" class="q-pt-sm">
          <div class="text-center" v-if="showProgress">
            <q-circular-progress indeterminate size="50px" color="white" class="q-ma-md" />
          </div>
          <app-character-preview
            :character="characterData"
            :portrait-width="20"
            :show-stats-buttons="hasFreePoints"
            @increaseStat="increaseStat"
            @decreaseStat="decreaseStat"
          ></app-character-preview>
          <div class="q-my-sm text-center" v-if="hasFreePoints" @click="showConfirm = true">
            <q-btn outline label="Save Changes" size="sm"></q-btn>
          </div>
          <div>
            <div>
              <div class="q-mt-lg text-center text-caption">
                Health
              </div>
              <q-linear-progress
                size="25px"
                :value="characterData.currentHealth / characterData.maxHealth"
                color="red"
              >
                <div class="absolute-full flex flex-center">
                  <q-badge
                    color="black"
                    text-color="white"
                    :label="`${characterData.currentHealth} / ${characterData.maxHealth}`"
                  ></q-badge>
                </div>
              </q-linear-progress>
            </div>
            <div>
              <div class="q-mt-sm text-center text-caption">
                Level progress
              </div>
              <q-linear-progress
                size="25px"
                :value="characterData.currentExp / characterData.expToNextLevel"
                color="white"
              >
                <div class="absolute-full flex flex-center">
                  <q-badge
                    color="black"
                    text-color="white"
                    :label="`${characterData.currentExp} / ${characterData.expToNextLevel}`"
                  ></q-badge>
                </div>
              </q-linear-progress>
            </div>
          </div>
        </app-full-height-column>
      </div>
      <div class="col-4">
        <div
          id="skills-col-header"
          class="list-title q-pa-md text-center text-subtitle1 text-uppercase b-b-w"
        >
          Skills
        </div>
        <div class="text-center" v-if="showProgress">
          <q-circular-progress indeterminate size="50px" color="white" class="q-ma-md" />
        </div>
        <app-full-height-column :bottom-offset="100" column-header-id="skills-col-header">
          <app-items-list class="q-mt-sm" :items-list="characterData.skills"></app-items-list>
        </app-full-height-column>
        <div style="height: 100px;" class="text-center q-py-lg">
          <q-btn
            label="Edit"
            size="lg"
            color="dark"
            class="text-white"
            :to="`/user/character/${$route.params.id}/skills`"
            outline
          ></q-btn>
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
            @click="saveChanges"
          />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </q-page>
</template>

<script>
import notifyUtils from '../mixins/notify';
import ItemsList from '../components/ItemsList';
import CharacterPreview from '../components/CharacterPreview';
import FullHeightColumn from '../components/FullHeightColumn';

export default {
  name: 'appCharacterDashboard',
  mixins: [notifyUtils],
  components: {
    appItemsList: ItemsList,
    appCharacterPreview: CharacterPreview,
    appFullHeightColumn: FullHeightColumn
  },
  data() {
    return {
      beginStats: {},
      characterData: {},
      listsHeight: 0,
      showProgress: true,
      hasFreePoints: false,
      showConfirm: false
    };
  },
  methods: {
    getItemsOfACategory(category) {
      if (this.characterData.items) {
        return this.characterData.items.filter(item => item.category === category && item.equiped);
      }
      return [];
    },
    itemStats(item) {
      const stats = [];

      Object.entries(item.stats).forEach(stat => {
        stats.push(`${String(stat[0]).toUpperCase()}: ${stat[1]}`);
      });

      return stats.sort().join('|');
    },
    increaseStat(stat) {
      if (this.characterData.freeStatPoints > 0) {
        this.characterData.freeStatPoints -= 1;
        this.$store.commit('gameCharacterScope/INCREASE_STAT', stat);
        this.$store.commit('gameCharacterScope/DECREASE_STAT_POINTS');
      }
    },
    decreaseStat(stat) {
      if (this.characterData.stats[stat] > this.beginStats[stat]) {
        this.characterData.freeStatPoints += 1;
        this.$store.commit('gameCharacterScope/DECREASE_STAT', stat);
        this.$store.commit('gameCharacterScope/INCREASE_STAT_POINTS');
      }
    },
    saveChanges() {
      this.$store
        .dispatch('gameCharacterScope/updateCharacterData', this.characterData)
        .then(response => {
          if (response.status === 200) {
            this.notifySuccess(response.message);
            this.characterData = this.$store.getters['gameCharacterScope/getCharacterData'];
            this.beginStats = { ...this.characterData.stats };
            this.hasFreePoints = this.characterData.freeStatPoints > 0;
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
    this.$store
      .dispatch('gameCharacterScope/fetchCharacterData', this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.showProgress = false;
          this.characterData = this.$store.getters['gameCharacterScope/getCharacterData'];
          this.beginStats = { ...this.characterData.stats };
          this.hasFreePoints = this.characterData.freeStatPoints > 0;
        } else {
          this.notifyError(response.message);
        }
      })
      .catch(error => {
        this.notifyError(error.message);
      });
  }
};
</script>
