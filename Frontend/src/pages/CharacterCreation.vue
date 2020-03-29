<template>
  <q-page padding class="font-tech">
    <q-stepper v-model="step" color="primary" header-nav animated>
      <q-step
        :name="1"
        title="General character information"
        :icon="icons.userCircleSolid"
        :active-icon="icons.userCircleSolid"
        :active-color="'white'"
        :done="step > 1"
        :done-icon="icons.checkSolid"
        :done-color="'white'"
      >
        <div class="row q-gutter-lg">
          <div class="col-6 offset-3">
            <q-input
              v-model="newCharacterData.name"
              ref="nameInput"
              type="text"
              label="Character name"
              :rules="validation.characterName"
              :readonly="ajaxActive"
              color="white"
              outlined
            ></q-input>
          </div>
          <div class="col-6 offset-3">
            <div class="text-subtitle1 text-grey-5 text-center">
              Character portrait
            </div>
            <q-carousel
              animated
              v-model="newCharacterData.portraitId"
              :arrows="!ajaxActive"
              infinite
            >
              <q-carousel-slide v-for="i in 3" :key="i" :name="i">
                <div class="text-center">
                  <q-img
                    :src="`statics/portraits/${i}.jpg`"
                    style="width: 40%; border: 3px double white"
                  ></q-img>
                </div>
              </q-carousel-slide>
            </q-carousel>
          </div>
        </div>
        <q-stepper-navigation class="text-right">
          <q-btn
            @click="$router.push('/characters')"
            color="dark"
            class="text-white q-mr-md"
            label="Exit"
            :disable="ajaxActive"
            flat
          ></q-btn>
          <q-btn
            @click="checkCharacterData"
            color="dark"
            class="text-white"
            label="Continue"
            type="submit"
            :loading="ajaxActive"
            outline
          ></q-btn>
        </q-stepper-navigation>
      </q-step>

      <q-step
        :name="2"
        title="Character class"
        :icon="icons.usersSolid"
        :active-icon="icons.usersSolid"
        :active-color="'white'"
        :done="step > 2"
        :done-icon="icons.checkSolid"
        :done-color="'white'"
      >
        <div class="row">
          <div class="col-6">
            <q-list dark class="full-height b-r-w">
              <q-item-label header>Character class</q-item-label>
              <q-item
                :clickable="!ajaxActive"
                dark
                v-for="(characterClass, index) in classesDescriptions"
                :key="index"
                @click="classPicked(characterClass)"
                :active="characterClass.name === featuredClassDescription.name"
                active-class="bg-white text-black text-bold"
              >
                <q-item-section>{{ characterClass.name }}</q-item-section>
              </q-item>
            </q-list>
          </div>
          <div class="col-6 q-gutter-md">
            <div v-if="Object.keys(featuredClassDescription).length !== 0" class="full-height">
              <div class="text-center text-h5">
                {{ featuredClassDescription.name }}
              </div>
              <div class="q-pa-md">
                {{ featuredClassDescription.description }}
              </div>
            </div>
            <div v-else>
              <div class="text-center text-h4 q-mt-lg">Pick a class</div>
            </div>
          </div>
        </div>
        <q-stepper-navigation class="text-right">
          <q-btn
            flat
            @click="step = 1"
            :disable="ajaxActive"
            color="dark"
            label="Back"
            class="q-ml-sm text-white"
          ></q-btn>
          <q-btn
            @click="checkClass"
            color="dark"
            class="text-white"
            label="Continue"
            :loading="ajaxActive"
            outline
          ></q-btn>
        </q-stepper-navigation>
      </q-step>

      <q-step
        :name="3"
        title="Character stats"
        :icon="icons.fistRaisedSolid"
        :active-icon="icons.fistRaisedSolid"
        :active-color="'white'"
        :done-icon="icons.checkSolid"
        :done-color="'white'"
      >
        <div v-if="Object.keys(featuredClass).length !== 0" class="row">
          <div class="col-12 text-h5">Points left: {{ pointsToWaste }}</div>
          <div class="col-12">
            <div class="row">
              <template v-for="stat in Object.keys(featuredClass.baseStats)">
                <div class="col-12 q-my-md" :key="stat">
                  <div class="row">
                    <div class="col-6 text-right q-pr-lg text-h6">{{ statToString(stat) }}:</div>
                    <div class="col-6 text-left q-pl-lg text-h6">
                      <q-btn
                        round
                        outline
                        size="sm"
                        :icon="icons.minus"
                        @click="removePoint(stat)"
                      ></q-btn>
                      <div style="display: inline-block; width: 50px; text-align: center">
                        {{ newCharacterData.stats[stat] }}
                      </div>
                      <q-btn
                        round
                        outline
                        size="sm"
                        :icon="icons.plus"
                        @click="addPoint(stat)"
                      ></q-btn>
                    </div>
                  </div>
                </div>
              </template>
            </div>
          </div>
        </div>
        <q-stepper-navigation class="text-right">
          <q-btn
            flat
            @click="step = 2"
            color="dark"
            label="Back"
            class="q-ml-sm text-white"
          ></q-btn>
          <q-btn @click="step = 4" color="dark" outline class="text-white" label="Continue"></q-btn>
        </q-stepper-navigation>
      </q-step>

      <q-step
        :name="4"
        title="Summary"
        :icon="icons.idCard"
        :active-icon="icons.idCard"
        :active-color="'white'"
        :done-icon="icons.checkSolid"
        :done-color="'white'"
      >
        Try out different ad text to see what brings in the most customers, and learn how to enhance
        your ads using features like ad extensions. If you run into any problems with your ads, find
        out how to tell if they're running and how to resolve approval issues.

        <q-stepper-navigation>
          <q-btn color="primary" label="Finish" />
          <q-btn flat @click="step = 2" color="primary" label="Back" class="q-ml-sm" />
        </q-stepper-navigation>
      </q-step>
    </q-stepper>
  </q-page>
</template>

<script>
import notifyUtils from '../mixins/notify';

export default {
  name: 'AppCharacterCreation',
  mixins: [notifyUtils],
  data() {
    return {
      step: 1,
      icons: {},
      validation: {},
      ajaxActive: false,
      classesDescriptions: [],
      featuredClassDescription: {},
      featuredClass: {},
      pointsToWaste: 10,
      newCharacterData: {
        level: 1,
        name: '',
        portraitId: '',
        class: '',
        stats: {},
        skills: []
      }
    };
  },
  methods: {
    checkCharacterData() {
      if (!this.$refs.nameInput.validate()) {
        this.notifyError("Character name you've entered contains errors. Please, correct them");
      } else if (!this.newCharacterData.portraitId) {
        this.notifyError("You haven't picked a portrait for your character");
      } else {
        this.ajaxActive = true;
        this.$store
          .dispatch('userCharacters/fetchClassesDescriptions')
          .then(response => {
            this.ajaxActive = false;
            if (response.status === 200) {
              this.step += 1;
              this.classesDescriptions = this.$store.getters[
                'userCharacters/getClassesDescriptions'
              ];
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
    classPicked(classDescription) {
      this.featuredClassDescription = classDescription;
      this.newCharacterData.class = classDescription.name;
    },
    checkClass() {
      if (this.featuredClassDescription.name === undefined) {
        this.notifyError('Please, pick a class for your character');
      } else {
        this.ajaxActive = true;
        this.$store
          .dispatch('userCharacters/fetchClasses')
          .then(response => {
            this.ajaxActive = false;
            if (response.status === 200) {
              this.step += 1;
              this.pointsToWaste = 10;
              const classes = this.$store.getters['userCharacters/getClasses'];

              for (let i = 0; i < classes.length; i += 1) {
                if (classes[i].name === this.newCharacterData.class) {
                  this.featuredClass = { ...classes[i] };
                  this.newCharacterData.stats = { ...classes[i].baseStats };
                  this.newCharacterData.skills = [...classes[i].skills];
                }
              }
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
    addPoint(stat) {
      if (this.pointsToWaste !== 0) {
        this.newCharacterData.stats[stat] += 1;
        this.pointsToWaste -= 1;
      }
    },
    removePoint(stat) {
      if (this.featuredClass.baseStats[stat] < this.newCharacterData.stats[stat]) {
        this.newCharacterData.stats[stat] -= 1;
        this.pointsToWaste += 1;
      }
    },
    statToString(stat) {
      switch (stat) {
        case 'str':
          return 'Strength';
        case 'dex':
          return 'Dexterity';
        case 'int':
          return 'Intelligence';
        default:
          return '';
      }
    }
  },
  created() {
    const icons = this.$store.getters['globalStore/getIcons'];

    this.icons.fistRaisedSolid = icons.fistRaisedSolid;
    this.icons.checkSolid = icons.checkSolid;
    this.icons.userCircleSolid = icons.userCircleSolid;
    this.icons.usersSolid = icons.usersSolid;
    this.icons.idCard = icons.idCard;
    this.icons.plus = icons.plus;
    this.icons.minus = icons.minus;

    const validators = this.$store.getters['globalStore/getValidators'];

    this.validation.characterName = validators.characterName;
  }
};
</script>
