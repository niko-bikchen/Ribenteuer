<template>
  <q-page padding>
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
              type="text"
              label="Character name"
              outlined
            ></q-input>
          </div>
          <div class="col-6 offset-3">
            <div>
              Character portrait
            </div>
            <q-carousel animated v-model="newCharacterData.portraitId" arrows navigation infinite>
              <q-carousel-slide v-for="i in 3" :key="i" :name="i">
                <div class="text-center">
                  <q-img :src="`statics/portraits/${i}.jpg`" style="width: 40%"></q-img>
                </div>
              </q-carousel-slide>
            </q-carousel>
          </div>
        </div>
        <q-stepper-navigation>
          <q-btn @click="step = 2" color="dark" class="text-white" outline label="Continue" />
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
        An ad group contains one or more ads which target a shared set of keywords.

        <q-stepper-navigation>
          <q-btn @click="step = 3" color="primary" label="Continue" />
          <q-btn flat @click="step = 1" color="primary" label="Back" class="q-ml-sm" />
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
        This step won't show up because it is disabled.
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
export default {
  name: 'AppCharacterCreation',
  data() {
    return {
      step: 1,
      icons: {},
      newCharacterData: {
        name: '',
        portraitId: '1'
      }
    };
  },
  created() {
    const icons = this.$store.getters['globalStore/getIcons'];

    this.icons.fistRaisedSolid = icons.fistRaisedSolid;
    this.icons.checkSolid = icons.checkSolid;
    this.icons.userCircleSolid = icons.userCircleSolid;
    this.icons.usersSolid = icons.usersSolid;
    this.icons.idCard = icons.idCard;
  }
};
</script>
