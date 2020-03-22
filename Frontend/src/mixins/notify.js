const notifyUtils = {
  data() {
    return {
      icons: {}
    };
  },
  methods: {
    notifySuccess(message) {
      this.$q.notify({
        color: 'green-5',
        textColor: 'white',
        icon: this.icons.checkSolid,
        message,
        position: 'top',
        progress: true,
        timeout: 1500
      });
    },
    notifyError(message) {
      this.$q.notify({
        color: 'green-5',
        textColor: 'white',
        icon: this.icons.exclamationTriangleSolid,
        message,
        position: 'top',
        progress: true,
        timeout: 1500
      });
    }
  },
  created() {
    const icons = this.$store.getters['userEntry/getIcons'];

    this.icons.checkSolid = icons.checkSolid;
    this.icons.exclamationTriangleSolid = icons.exclamationTriangleSolid;
  }
};

export default notifyUtils;
