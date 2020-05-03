<template>
  <q-page>
    <div class="row">
      <div class="col-6 b-r-w">
        <div
          id="locations-col-header"
          class="list-title q-pa-md text-center text-subtitle1 text-uppercase b-b-w"
        >
          Locations
        </div>
        <app-full-height-column column-header-id="locations-col-header">
          <q-list separator>
            <q-item
              clickable
              v-for="location in locations"
              :key="location.name"
              @click="currentLocation = location"
            >
              <q-item-section>{{ location.name }}</q-item-section>
            </q-item>
          </q-list>
        </app-full-height-column>
      </div>
      <div class="col-6 relative-position">
        <div v-if="currentLocation.name" class="text-center">
          <div class="q-mt-xl text-h4 font-bitmgothic">
            {{ currentLocation.name }}
          </div>
          <div class="q-mt-md text-center">
            <q-img
              :src="`statics/locations/${currentLocation.name.toLowerCase()}.png`"
              :style="{
                width: '50%',
                height: 'auto',
                border: '3px double white'
              }"
            ></q-img>
          </div>
          <div class="q-mt-md q-px-md text-center">
            {{ currentLocation.description }}
          </div>
          <div class="absolute-bottom q-mb-lg" v-if="currentLocation.name === 'Dungeon'">
            <q-btn outline color="dark" class="text-white" label="Let's Go" to="/game/dungeon">
            </q-btn>
          </div>
          <div class="absolute-bottom q-mb-lg text-yellow-8 text-h6" v-else>
            Location is under construction
          </div>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
import FullHeightColumn from '../components/FullHeightColumn';

export default {
  name: 'appLocationsList',
  data() {
    return {
      locations: [],
      characterData: {},
      currentLocation: {}
    };
  },
  components: {
    appFullHeightColumn: FullHeightColumn
  },
  methods: {
    enterTheDungeon() {}
  },
  created() {
    this.$store
      .dispatch('gameWorldScope/fetchLocations')
      .then(response => {
        if (response.status === 200) {
          this.locations = this.$store.getters['gameWorldScope/getLocations'];
          this.characterData = this.$store.getters['gameCharacterScope/getCharacterData'];
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
