<template>
  <div class="row">
    <q-card
      class="col-12 offset-sm-0 col-sm-8 offset-sm-2 col-md-6 offset-md-3 q-my-lg ba-w font-tech"
    >
      <q-tabs
        v-model="tab"
        dense
        class="text-grey"
        active-color="white"
        align="justify"
        indicator-color="white"
      >
        <q-tab name="sign-in" label="Sign In" />
        <q-tab name="sign-up" label="Sign Up" />
      </q-tabs>

      <q-separator />

      <q-tab-panels v-model="tab" animated>
        <q-tab-panel name="sign-in">
          <app-sign-in></app-sign-in>
        </q-tab-panel>

        <q-tab-panel name="sign-up">
          <app-sign-up></app-sign-up>
        </q-tab-panel>
      </q-tab-panels>
    </q-card>
  </div>
</template>

<script>
import signIn from 'components/SignIn.vue';
import signUp from 'components/SignUp';

export default {
  data() {
    return {
      tab: 'sign-in'
    };
  },
  components: {
    appSignIn: signIn,
    appSignUp: signUp
  }
};
</script>
