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
            <q-tab name="Weapon" label="Weapons" />
            <q-tab name="Armour" label="Armour" />
            <q-tab name="Consumable" label="Consumables" />
          </q-tabs>
        </div>
        <q-separator />
        <q-tab-panels v-model="currentTab" animated transition-prev="fade" transition-next="fade">
          <q-tab-panel
            :name="tabName"
            class="q-pa-none"
            v-for="tabName in ['All', 'Weapon', 'Armour', 'Consumable']"
            :key="tabName"
          >
            <app-full-height-column column-header-id="items-list-filters" :bottom-offset="2">
              <q-list separator>
                <q-item>
                  <q-item-section>
                    <q-item-label class="text-grey">Name</q-item-label>
                  </q-item-section>
                  <q-item-section side>
                    <q-item-label class="text-grey">Quantity | Equiped</q-item-label>
                  </q-item-section>
                </q-item>
                <q-item
                  clickable
                  v-for="item in characterXItems(tabName)"
                  :key="item.id"
                  @click="showItem(item)"
                >
                  <q-item-section>
                    <q-item-label>{{ item.name }}</q-item-label>
                    <q-item-label caption>{{ item.category }}</q-item-label>
                  </q-item-section>
                  <q-item-section side>
                    <q-item-label>
                      {{ item.quantity }} |
                      <span v-if="item.equiped !== undefined">{{
                        item.equiped ? 'Yes' : 'No'
                      }}</span>
                      <span v-else-if="item.category === 'Consumable'">Yes</span>
                      <span v-else>N/A</span>
                    </q-item-label>
                  </q-item-section>
                </q-item>
              </q-list>
            </app-full-height-column>
          </q-tab-panel>
        </q-tab-panels>
      </div>
      <div class="col-6 relative-position">
        <div class="q-pt-lg q-px-md" v-if="clickedItem.name !== undefined">
          <div class="text-center">
            <div class="text-h4">
              {{ clickedItem.name }}
            </div>
            <div class="text-subtitle2">
              {{ clickedItem.category }}
            </div>
          </div>
          <div class="row q-mt-lg">
            <div class="col-6 text-right">Quantity:</div>
            <div class="col-6 q-pl-lg">
              {{ clickedItem.quantity }}
            </div>
            <div class="col-6 text-right">Cost:</div>
            <div class="col-6 q-pl-lg">{{ clickedItem.cost }} G.</div>
          </div>
          <div class="q-mt-lg">
            <div v-if="clickedItem.stats" class="q-mb-md">
              <div class="text-caption q-mb-xs">Stats:</div>
              <div>{{ listStats(clickedItem) }}</div>
            </div>
            <div class="text-caption q-mb-xs">
              Description
            </div>
            <p>
              {{ clickedItem.description }}
            </p>
          </div>
          <div
            v-if="clickedItem.category === 'Weapon' || clickedItem.category === 'Armour'"
            class="q-mb-lg text-center absolute-bottom"
          >
            <q-btn
              v-if="clickedItem.equiped"
              label="Unequip"
              outline
              size="lg"
              color="dark"
              class="text-white"
              @click="equipUnequipItem('unequip')"
            ></q-btn>
            <q-btn
              v-else
              label="Equip"
              outline
              color="dark"
              size="lg"
              class="text-white"
              @click="equipUnequipItem('equip')"
            ></q-btn>
          </div>
          <div v-else-if="clickedItem.category === 'Consumable'">
            <div class="q-mb-lg text-h6 text-center absolute-bottom">
              Can Be Used Only in Battle
            </div>
          </div>
        </div>
        <div v-else>
          <div class="q-mt-lg text-center text-h4">Pick an Item</div>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
import FullHeightColumn from '../components/FullHeightColumn';
import notifyUtils from '../mixins/notify';

export default {
  name: 'appManageItems',
  mixins: [notifyUtils],
  components: {
    appFullHeightColumn: FullHeightColumn
  },
  data() {
    return {
      characterData: {},
      columnsHeight: 0,
      currentTab: 'All',
      clickedItem: {}
    };
  },
  methods: {
    characterXItems(category) {
      const items = [...this.characterData.items].sort((itemA, itemB) =>
        itemA.name.localeCompare(itemB.name)
      );

      if (category !== 'All') {
        return items.filter(item => item.category === category);
      }
      return items;
    },
    showItem(item) {
      this.clickedItem = item;
    },
    listStats(item) {
      const { stats } = item;
      const res = [];

      Object.entries(stats).forEach(([name, value]) => res.push(`${name.toUpperCase()}: ${value}`));

      return res.sort().join(' | ');
    },
    equipUnequipItem(action) {
      this.$store
        .dispatch(`gameCharacterScope/${action}Item`, {
          characterId: this.characterData.id,
          itemId: this.clickedItem.id
        })
        .then(response => {
          if (response.status === 200) {
            this.notifySuccess(`${response.message}: ${this.clickedItem.name}`);
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
