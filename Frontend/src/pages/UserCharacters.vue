<template>
  <q-page>
    <div class="row">
      <div class="col-6">
        <app-character-list
          :characters="characters"
          @characterClicked="showCharacter"
          @createCharacter="createNewCharacter"
        ></app-character-list>
        <div class="text-center" v-if="showProgress">
          <q-circular-progress indeterminate size="50px" color="white" class="q-ma-md" />
        </div>
      </div>
      <div class="col-6 b-l-w">
        <div class="q-mb-lg q-mt-xl">
          <app-character-preview :character="currentCharacter"></app-character-preview>
        </div>
        <div v-if="currentCharacter.id" class="text-center">
          <q-btn
            label="Play"
            class="text-white q-mr-md"
            size="lg"
            @click="enterTheGame"
            :loading="ajaxActive"
            outline
          >
          </q-btn>
          <q-btn
            label="Edit"
            class="text-white"
            size="lg"
            :disable="ajaxActive"
            @click="$router.push(`/user/character/${currentCharacter.id}`)"
            outline
          ></q-btn>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
import CharacterList from '../components/CharacterList.vue';
import CharacterPreview from '../components/CharacterPreview';
import notifyUtils from '../mixins/notify.js';

export default {
  name: 'AppUserCharacters',
  mixins: [notifyUtils],
  components: {
    appCharacterList: CharacterList,
    appCharacterPreview: CharacterPreview
  },
  data() {
    return {
      characters: [],
      currentCharacter: {},
      charactersListHeight: 0,
      showProgress: true,
      ajaxActive: false
    };
  },
  methods: {
    showCharacter(character) {
      this.currentCharacter = { ...character };
    },
    createNewCharacter() {
      this.$router.push('character-creation');
    },
    enterTheGame() {
      this.ajaxActive = true;
      this.$store
        .dispatch('gameCharacterScope/fetchCharacterData', this.currentCharacter.id)
        .then(response => {
          this.ajaxActive = false;
          if (response.status === 200) {
            this.$router.push('/game');
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
    this.$store
      .dispatch('userScope/fetchCharacters')
      .then(response => {
        if (response.status === 200) {
          this.showProgress = false;
          this.characters = this.$store.getters['userScope/getCharacters'];
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
