<template>
  <div v-if="character.id !== undefined" class="text-center font-tech row full-height q-mt-md">
    <div class="col-12">
      <div class="text-h4">{{ character.name }}</div>
      <div class="text-h6">Level {{ character.level }}</div>
      <div class="text-h6">{{ character.class }}</div>
    </div>
    <div class="col-12">
      <q-img
        style="width: 25%; border: 3px double white;"
        :src="`statics/portraits/${character.portraitId}.jpg`"
      ></q-img>
    </div>
    <div class="col-12 text-subtitle1">
      <div class="row">
        <div class="col-6 text-right q-pr-md">Strength</div>
        <div class="col-6 text-left q-pl-xl">{{ character.stats.str }}</div>

        <div class="col-6 text-right q-pr-md">Dexterity</div>
        <div class="col-6 text-left q-pl-xl">{{ character.stats.dex }}</div>

        <div class="col-6 text-right q-pr-md">Intelligence</div>
        <div class="col-6 text-left q-pl-xl">{{ character.stats.int }}</div>
      </div>
    </div>
    <div class="col-12 q-mb-lg">
      <q-btn label="Play" class="text-white q-mr-md" size="lg" outline> </q-btn>
      <q-btn label="Edit" class="text-white" size="lg" outline> </q-btn>
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
    }
  },
  data() {
    return {};
  }
};
</script>
