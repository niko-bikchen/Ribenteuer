<template>
  <q-form class="q-gutter-sm" @submit="onSubmit">
    <q-input
      v-model="userEmail"
      :rules="validation.email"
      type="text"
      label="Email"
      color="white"
      square
      outlined
    >
      <template v-slot:append=""> <q-icon :name="icons.envelopeSolid"> </q-icon></template>
    </q-input>
    <q-input
      v-model="userPassword"
      :rules="validation.password"
      type="password"
      label="Password"
      color="white"
      square
      outlined
    >
      <template v-slot:append=""> <q-icon :name="icons.asteriskSolid"> </q-icon></template>
    </q-input>
    <div class="text-center">
      <q-btn type="submit" color="white" size="md" outline>Submit</q-btn>
    </div>
  </q-form>
</template>

<script>
export default {
  data() {
    return {
      userEmail: '',
      userPassword: '',
      rememberMe: false,
      validation: {},
      icons: {}
    };
  },
  methods: {
    onSubmit() {
      this.$router.push('characters');
    }
  },
  created() {
    const icons = this.$store.getters['userEntry/getIcons'];

    this.icons.envelopeSolid = icons.envelopeSolid;
    this.icons.asteriskSolid = icons.asteriskSolid;

    const validators = this.$store.getters['userEntry/getValidators'];

    this.validation.email = validators.email;
    this.validation.password = validators.notEmpty;
  }
};
</script>
