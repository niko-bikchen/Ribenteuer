<template>
  <q-form class="q-gutter-sm" @submit="onSubmit">
    <q-input
      v-model="userEmail"
      :readonly="ajaxActive"
      :rules="validation.email"
      type="text"
      label="Email"
      color="white"
      square
      outlined
      lazy-rules
    >
      <template v-slot:append> <q-icon :name="icons.envelopeSolid"> </q-icon></template>
    </q-input>
    <q-input
      v-model="userPassword"
      :readonly="ajaxActive"
      :rules="validation.password"
      type="password"
      label="Password"
      color="white"
      square
      outlined
      lazy-rules
    >
      <template v-slot:append> <q-icon :name="icons.asteriskSolid"> </q-icon></template>
    </q-input>
    <div class="text-center">
      <q-btn :loading="ajaxActive" type="submit" color="white" size="md" outline>Submit</q-btn>
    </div>
  </q-form>
</template>

<script>
import notifyUtils from '../mixins/notify.js';

export default {
  name: 'AppSignIn',
  mixins: [notifyUtils],
  data() {
    return {
      userEmail: '',
      userPassword: '',
      rememberMe: false,
      validation: {},
      icons: {},
      ajaxActive: false
    };
  },
  methods: {
    onSubmit() {
      const userData = {
        email: this.userEmail,
        password: this.userPassword,
        activeRole: 'ROLE_USER'
      };

      this.ajaxActive = true;
      this.$store
        .dispatch('userScope/signIn', userData)
        .then(response => {
          this.ajaxActive = false;

          if (response.status === 200) {
            this.notifySuccess(response.message);
            this.$router.push('user/characters');
          }
        })
        .catch(error => {
          this.ajaxActive = false;
          this.notifyError(error.message);
        });
    }
  },
  created() {
    const icons = this.$store.getters['iconsScope/getIcons'];

    this.icons.envelopeSolid = icons.envelopeSolid;
    this.icons.asteriskSolid = icons.asteriskSolid;

    const validators = this.$store.getters['validationScope/getValidators'];

    this.validation.email = validators.email;
    this.validation.password = validators.notEmpty;
  }
};
</script>
