<template>
  <q-list>
    <q-item-label header v-if="listHeader">
      {{ this.listHeader }}
    </q-item-label>
    <div v-for="(item, number) in itemsList" :key="`${item.id}${item.ownerId}`">
      <q-item>
        <q-item-section>
          <q-item-label>
            {{ number + 1 }}. {{ item.name.charAt(0).toUpperCase() + item.name.substring(1)
            }}<span v-if="item.level">. Level {{ item.level }}</span>
          </q-item-label>
          <q-item-label caption>{{ item.description }}</q-item-label>
          <q-item-label caption v-if="item.stats">
            {{ itemStats(item) }}
          </q-item-label>
        </q-item-section>
      </q-item>
    </div>
  </q-list>
</template>

<script>
export default {
  name: 'appItemsList',
  props: {
    itemsList: {
      required: true
    },
    listHeader: {
      type: String,
      required: false,
      default: ''
    }
  },
  methods: {
    itemStats(item) {
      const stats = [];

      Object.entries(item.stats).forEach(stat => {
        stats.push(`${String(stat[0]).toUpperCase()}: ${stat[1]}`);
      });

      return stats.sort().join(' | ');
    }
  }
};
</script>
