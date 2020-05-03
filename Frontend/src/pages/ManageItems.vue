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
                  :active="item.equiped || item.category === 'Consumable'"
                  active-class="text-green-13"
                >
                  <q-item-section>
                    <q-item-label>{{ item.name }}</q-item-label>
                    <q-item-label caption
                      >{{ item.category }}
                      <span v-if="item.type">| {{ item.type }}</span></q-item-label
                    >
                  </q-item-section>
                  <q-item-section side>
                    <q-item-label>
                      {{ item.quantity }} |
                      <span
                        v-if="item.equiped !== undefined"
                        :class="{ 'text-green-13': item.equiped }"
                      >
                        {{ item.equiped ? 'Yes' : 'No' }}
                      </span>
                      <span v-else-if="item.category === 'Consumable'" class="text-green-13">
                        Yes
                      </span>
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
            <div class="text-h5">
              {{ clickedItem.name }}
            </div>
            <div class="text-subtitle2">
              {{ clickedItem.category }}
              <span v-if="clickedItem.type">| {{ clickedItem.type }}</span>
            </div>
          </div>
          <div class="q-mt-sm text-center">
            <q-img
              v-if="clickedItem.category !== 'Consumable'"
              :src="
                `statics/${clickedItem.category.toLowerCase()}/${clickedItem.name
                  .replace('’', '')
                  .split(' ')
                  .join('_')}.png`
              "
              style="width: 10%; height: auto; border: 3px double white"
            ></q-img>
          </div>
          <div class="row q-mt-sm">
            <div class="col-6 text-right">Quantity:</div>
            <div class="col-6 q-pl-lg">
              {{ clickedItem.quantity }}
            </div>
            <div class="col-6 text-right">Cost:</div>
            <div class="col-6 q-pl-lg">{{ clickedItem.cost }} G.</div>
          </div>
          <div class="q-mt-md">
            <div v-if="clickedItem.requirements" class="q-mb-sm">
              <div class="q-mb-xs text-weight-bolder">Requirements:</div>
              <div>Class: {{ clickedItem.ownerClass }}</div>
              <div>{{ listRequirements(clickedItem) }}</div>
            </div>
            <div v-if="clickedItem.stats" class="q-mb-sm">
              <div class="q-mb-xs text-weight-bolder">Stats:</div>
              <div>{{ listStats(clickedItem) }}</div>
            </div>
            <div class="q-mb-xs text-weight-bolder">
              Description:
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
              color="dark"
              class="text-white"
              :loading="ajaxActive"
              @click="equipUnequipItem('unequip')"
            ></q-btn>
            <div v-else>
              <q-btn
                v-if="!constrainsSatisfied"
                label="Equip"
                outline
                color="dark"
                class="text-white"
                :loading="ajaxActive"
                @click="equipUnequipItem('equip')"
              ></q-btn>
              <div v-else class="text-h6">
                {{ constrainsSatisfied }}
              </div>
            </div>
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
      clickedItem: {},
      ajaxActive: false
    };
  },
  computed: {
    constrainsSatisfied() {
      if (this.characterData.class !== this.clickedItem.ownerClass) {
        return `You have to be a ${this.clickedItem.ownerClass} to wear this`;
      }

      if (this.clickedItem.requirements) {
        const requirements = Object.keys(this.clickedItem.requirements);
        for (let i = 0; i < requirements.length; i += 1) {
          if (
            this.characterData.stats[requirements[i]] < this.clickedItem.requirements[requirements]
          ) {
            return `Your ${requirements[i].toUpperCase()} is lower than required`;
          }
        }
      }

      const items = this.characterXItems(this.clickedItem.category);

      for (let i = 0; i < items.length; i += 1) {
        if (
          items[i].category === this.clickedItem.category &&
          items[i].name !== this.clickedItem.name &&
          items[i].equiped
        ) {
          if (items[i].type === this.clickedItem.type) {
            return 'You cannot wear two items of the same type';
          }
          if (items[i].type !== this.clickedItem.type) {
            return '';
          }
          return 'You cannot wear two items of the same category';
        }
      }

      return '';
    }
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
    listRequirements(item) {
      const { requirements } = item;
      const res = [];

      Object.entries(requirements).forEach(([name, value]) =>
        res.push(`${name.toUpperCase()}: ${value}`)
      );

      return res.sort().join(' | ');
    },
    equipUnequipItem(action) {
      this.ajaxActive = true;
      this.$store
        .dispatch(`gameCharacterScope/${action}Item`, {
          characterId: this.characterData.id,
          itemId: this.clickedItem.id
        })
        .then(response => {
          this.ajaxActive = false;
          if (response.status === 200) {
            this.notifySuccess(`${response.message}: ${this.clickedItem.name}`);
          } else {
            this.notifyError(response.message);
          }
        })
        .catch(error => {
          this.ajaxActive = false;
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
