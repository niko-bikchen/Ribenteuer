<template>
  <q-list class="font-tech">
    <q-item-label header id="character-list__header">Character List</q-item-label>

    <q-scroll-area :style="`height: ${listHeight}px;`">
      <q-item
        v-for="characterPreview in charactersPreviews"
        :key="characterPreview.id"
        clickable
        dark
        @click="$emit('characterClicked', characterPreview)"
      >
        <q-item-section avatar>
          <q-avatar>
            <q-img :src="`statics/portraits/${characterPreview.portraitId}.jpg`"></q-img>
          </q-avatar>
        </q-item-section>

        <q-item-section>
          <q-item-label>{{ characterPreview.name }}</q-item-label>
          <q-item-label caption lines="1">
            {{ characterPreview.class }}, Level {{ characterPreview.level }}
          </q-item-label>
        </q-item-section>
      </q-item>

      <q-item clickable dark @click="$emit('createCharacter')">
        <q-item-section avatar>
          <q-avatar>
            +
          </q-avatar>
        </q-item-section>

        <q-item-section>
          <q-item-label>Add New Character</q-item-label>
        </q-item-section>
      </q-item>
    </q-scroll-area>
  </q-list>
</template>

<script>
export default {
  name: 'AppCharacterList',
  props: {
    charactersPreviews: {
      type: Array,
      required: true
    },
    listHeight: {
      type: Number,
      required: true
    }
  }
};
</script>
