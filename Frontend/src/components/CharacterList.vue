<template>
  <q-list>
    <q-item-label header id="character-list__header">Character List</q-item-label>

    <app-full-height-column column-header-id="character-list__header">
      <q-item
        v-for="character in characters"
        :key="character.id"
        clickable
        dark
        @click="$emit('characterClicked', character)"
      >
        <q-item-section avatar>
          <q-avatar>
            <q-img :src="`statics/portraits/pic${character.portraitId}1.png`"></q-img>
          </q-avatar>
        </q-item-section>

        <q-item-section>
          <q-item-label>{{ character.name }}</q-item-label>
          <q-item-label caption lines="1">
            {{ character.class }}, Level {{ character.level }}
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
    </app-full-height-column>
  </q-list>
</template>

<script>
import FullHeightColumn from './FullHeightColumn';

export default {
  name: 'AppCharacterList',
  components: {
    appFullHeightColumn: FullHeightColumn
  },
  props: {
    characters: {
      type: Array,
      required: true
    }
  }
};
</script>
