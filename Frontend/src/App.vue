<template>
  <div id="q-app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  created() {
    this.$q.loadingBar.setDefaults({
      color: 'light-blue-6',
      size: '5px',
      position: 'top'
    });
  }
};
</script>
