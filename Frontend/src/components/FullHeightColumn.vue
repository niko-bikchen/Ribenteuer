<template>
  <q-scroll-area :style="`height: ${height}px;`">
    <slot></slot>
  </q-scroll-area>
</template>

<script>
export default {
  name: 'appFullHeightColumn',
  props: {
    bottomOffset: {
      type: Number,
      default: 0
    },
    columnHeaderId: {
      type: String,
      default: ''
    },
    columnHeight: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      height: 0
    };
  },
  mounted() {
    if (!this.columnHeight) {
      const header = document.getElementsByTagName('header')[0];
      const footer = document.getElementsByTagName('footer')[0];
      const app = document.getElementById('q-app');

      const columnHeader = this.columnHeaderId
        ? document.getElementById(this.columnHeaderId)
        : undefined;

      this.height =
        app.offsetHeight -
        (header.offsetHeight +
          footer.offsetHeight +
          (columnHeader ? columnHeader.offsetHeight : 0));

      this.height -= this.bottomOffset;
    } else {
      this.height = this.columnHeight;
    }
  }
};
</script>
