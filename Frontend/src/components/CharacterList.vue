<template>
  <q-list>
    <q-item>
      <q-item-section avatar>
        <q-avatar>
          <img :src="`https://cdn.quasar.dev/img/${contact.avatar}`" />
        </q-avatar>
      </q-item-section>

      <q-item-section>
        <q-item-label>{{ contact.name }}</q-item-label>
        <q-item-label caption lines="1">{{ contact.email }}</q-item-label>
      </q-item-section>

      <q-item-section side>
        <q-icon name="chat_bubble" color="grey" />
      </q-item-section>
    </q-item>
  </q-list>
</template>

<script>
export default {
  name: 'AppCharacterList',
  data() {
    return {};
  }
};
</script>
