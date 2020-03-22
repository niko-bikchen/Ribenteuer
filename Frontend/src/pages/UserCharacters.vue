<template>
  <q-page>
    <div class="row">
      <div class="col-6">
        <app-character-list
          :charactersPreviews="charactersPreviews"
          :listHeight="characterPreviewsListHeight"
        ></app-character-list>
      </div>
      <div class="col-6">World</div>
    </div>
  </q-page>
</template>

<script>
import CharacterList from 'components/CharacterList.vue';
import notifyUtils from '../mixins/notify.js';

export default {
  name: 'AppUserCharacters',
  mixins: [notifyUtils],
  components: {
    appCharacterList: CharacterList
  },
  data() {
    return {
      charactersPreviews: [],
      characterPreviewsListHeight: 0
    };
  },
  created() {
    this.$q.loadingBar.start();
    this.$store
      .dispatch('userCharacters/fetchCharactersPreviews')
      .then(response => {
        this.$q.loadingBar.stop();

        if (response.status === 200) {
          const header = document.getElementsByTagName('header')[0];
          const footer = document.getElementsByTagName('footer')[0];
          const listHeader = document.getElementById('character-list__header');
          const app = document.getElementById('q-app');

          this.charactersPreviews = this.$store.getters['userCharacters/getUserCharactersPreviews'];

          this.characterPreviewsListHeight =
            app.offsetHeight -
            (header.offsetHeight + footer.offsetHeight + listHeader.offsetHeight);
        } else {
          this.notifyError(response.message);
        }
      })
      .catch(error => {
        this.$q.loadingBar.stop();

        this.notifyError(error.message);
      });
  }
};
</script>
