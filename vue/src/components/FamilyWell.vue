<template>
  <div class="leftbar">
    <create-family />
    <family-summary />
  </div>
</template>

<script>
import CreateFamily from './CreateFamily.vue';
import FamilySummary from './FamilySummary.vue';
export default {
  components: { CreateFamily, FamilySummary },};
</script>

<style scoped>

</style>