<template>
  <q-form class="q-gutter-sm" @submit="onSubmit">
    <q-input
      v-model="user.nickname"
      :rules="validation.nickname"
      color="white"
      type="text"
      label="Nickname"
      outlined
      square
    >
      <template v-slot:append=""> <q-icon :name="icons.idCardSolid"> </q-icon></template>
    </q-input>
    <q-input
      v-model="user.email"
      :rules="validation.email"
      color="white"
      type="text"
      label="Email"
      outlined
      square
    >
      <template v-slot:append=""> <q-icon :name="icons.envelopeSolid"> </q-icon></template>
    </q-input>
    <q-input
      v-model="user.password"
      :rules="validation.password"
      color="white"
      type="password"
      label="Password"
      outlined
      square
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
      user: {
        nickname: '',
        password: '',
        email: ''
      },
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
