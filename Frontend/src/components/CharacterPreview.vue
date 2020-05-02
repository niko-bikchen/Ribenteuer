<template>
  <div v-if="character.name !== undefined" class="row text-center font-tech">
    <div class="col-12">
      <div class="text-h4">{{ character.name }}</div>
      <div class="text-h6">Level {{ character.level }}</div>
      <div class="text-h6">{{ character.class }}</div>
    </div>
    <div class="col-12 q-my-md">
      <q-img
        :style="`width: ${portraitWidth}%; border: 3px double white;`"
        :src="`statics/portraits/pic${character.portraitId}1.png`"
      ></q-img>
    </div>
    <div class="col-12 text-subtitle1">
      <div class="row">
        <div class="col-6 text-right q-pr-md">Strength</div>
        <div class="col-6 text-left q-pl-xl">
          <q-btn
            :icon="icons.minus"
            round
            outline
            size="xs"
            v-if="showStatsButtons"
            @click="$emit('decreaseStat', 'str')"
          ></q-btn>
          {{ character.stats.str }}
          <q-btn
            :icon="icons.plus"
            round
            outline
            size="xs"
            v-if="showStatsButtons"
            @click="$emit('increaseStat', 'str')"
          ></q-btn>
        </div>
        <div class="col-6 text-right q-pr-md">Dexterity</div>
        <div class="col-6 text-left q-pl-xl">
          <q-btn
            :icon="icons.minus"
            round
            outline
            size="xs"
            v-if="showStatsButtons"
            @click="$emit('decreaseStat', 'dex')"
          ></q-btn>
          {{ character.stats.dex }}
          <q-btn
            :icon="icons.plus"
            round
            outline
            size="xs"
            v-if="showStatsButtons"
            @click="$emit('increaseStat', 'dex')"
          ></q-btn>
        </div>

        <div class="col-6 text-right q-pr-md">Intelligence</div>
        <div class="col-6 text-left q-pl-xl">
          <q-btn
            :icon="icons.minus"
            round
            outline
            size="xs"
            v-if="showStatsButtons"
            @click="$emit('decreaseStat', 'int')"
          ></q-btn>
          {{ character.stats.int }}
          <q-btn
            :icon="icons.plus"
            round
            outline
            size="xs"
            v-if="showStatsButtons"
            @click="$emit('increaseStat', 'int')"
          ></q-btn>
        </div>
      </div>
      <div class="q-my-sm text-center" v-if="showStatsButtons">
        <q-btn outline label="Save Changes" size="sm"></q-btn>
      </div>
    </div>
  </div>
  <div v-else class="font-tech text-center text-h5 q-mt-xl">
    No character picked
  </div>
</template>

<script>
export default {
  name: 'AppCharacterPreview',
  props: {
    character: {
      type: Object,
      required: true
    },
    portraitWidth: {
      type: Number,
      default: 15
    },
    showStatsButtons: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      icons: {}
    };
  },
  created() {
    const icons = this.$store.getters['iconsScope/getIcons'];

    this.icons.plus = icons.plus;
    this.icons.minus = icons.minus;
  }
};
</script>
