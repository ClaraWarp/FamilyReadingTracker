<template>
  <div class="leftbar">
    <create-family 
    v-if="createFamilyToggle" 
    @toggleCreateFamily="createFamilyToggle = false" 
    />
    <family-summary 
    v-if="!createFamilyToggle" 
    @toggleCreateFamily="createFamilyToggle = true"
    />
  </div>
</template>

<script>
import CreateFamily from "./CreateFamily.vue";
import FamilySummary from "./FamilySummary.vue";
export default {
  components: { CreateFamily, FamilySummary },
  data() {
    return {
      createFamilyToggle: false
    }
  },
  created() {
    
  }
};
</script>

<style scoped>
</style>