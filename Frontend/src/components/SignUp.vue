<template>
  <q-form class="q-gutter-sm" @submit="onSubmit">
    <q-input
      v-model="user.nickname"
      :rules="validation.nickname"
      :readonly="ajaxActive"
      type="text"
      color="white"
      label="Nickname"
      outlined
      square
      lazy-rules
    >
      <template v-slot:append=""> <q-icon :name="icons.idCardSolid"> </q-icon></template>
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
      <template v-slot:append=""> <q-icon :name="icons.envelopeSolid"> </q-icon></template>
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
export default {
  name: 'AppSignUp',
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
        password: this.userPassword
      };

      this.ajaxActive = true;
      this.$q.loadingBar.start();
      this.$store
        .dispatch('userEntry/signUpUser', userData)
        .then(response => {
          this.ajaxActive = false;
          this.$q.loadingBar.stop();

          if (response.status === 201) {
            this.$q.notify({
              color: 'green-5',
              textColor: 'white',
              icon: this.icons.checkSolid,
              message: response.message,
              position: 'top'
            });
            this.$router.push('characters');
          }
        })
        .catch(error => {
          this.ajaxActive = false;
          this.$q.loadingBar.stop();

          this.$q.notify({
            color: 'red-5',
            textColor: 'white',
            icon: this.icons.exclamationTriangleSolid,
            message: error.message,
            position: 'top'
          });
        });
    }
  },
  created() {
    const validators = this.$store.getters['userEntry/getValidators'];

    this.validation.email = validators.email;
    this.validation.password = validators.passwordNew;
    this.validation.nickname = validators.nickname;

    const icons = this.$store.getters['userEntry/getIcons'];

    this.icons.envelopeSolid = icons.envelopeSolid;
    this.icons.asteriskSolid = icons.asteriskSolid;
    this.icons.idCardSolid = icons.idCardSolid;
  }
};
</script>
