<template>
  <q-form class="q-gutter-sm" @submit="onSubmit">
    <q-input
      v-model="user.nickname"
      :readonly="ajaxActive"
      :rules="validation.nickname"
      type="text"
      color="white"
      label="Nickname"
      outlined
      square
      lazy-rules
    >
      <template v-slot:append> <q-icon :name="icons.idCardSolid"> </q-icon></template>
    </q-input>
    <q-input
      v-model="user.email"
      :readonly="ajaxActive"
      :rules="validation.email"
      type="text"
      color="white"
      label="Email"
      outlined
      square
      lazy-rules
    >
      <template v-slot:append> <q-icon :name="icons.envelopeSolid"> </q-icon></template>
    </q-input>
    <q-input
      v-model="user.password"
      :readonly="ajaxActive"
      :rules="validation.password"
      type="password"
      color="white"
      label="Password"
      outlined
      square
      lazy-rules
    >
      <template v-slot:append=""> <q-icon :name="icons.asteriskSolid"> </q-icon></template>
    </q-input>
    <div class="text-center">
      <q-btn :loading="ajaxActive" type="submit" color="white" size="md" outline>Submit</q-btn>
    </div>
  </q-form>
</template>

<script>
import notifyUtils from '../mixins/notify.js';

export default {
  name: 'AppSignUp',
  mixins: [notifyUtils],
  data() {
    return {
      user: {
        nickname: '',
        password: '',
        email: ''
      },
      validation: {},
      icons: {},
      ajaxActive: false
    };
  },
  methods: {
    onSubmit() {
      const userData = {
        nickname: this.nickname,
        email: this.userEmail,
        password: this.userPassword,
        activeRole: 'ROLE_USER'
      };

      this.ajaxActive = true;
      this.$store
        .dispatch('userScope/signUp', userData)
        .then(response => {
          this.ajaxActive = false;
          if (response.status === 201) {
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
    const validators = this.$store.getters['validationScope/getValidators'];

    this.validation.email = validators.email;
    this.validation.password = validators.password;
    this.validation.nickname = validators.nickname;

    const icons = this.$store.getters['iconsScope/getIcons'];

    this.icons.envelopeSolid = icons.envelopeSolid;
    this.icons.asteriskSolid = icons.asteriskSolid;
    this.icons.idCardSolid = icons.idCardSolid;
  }
};
</script>
