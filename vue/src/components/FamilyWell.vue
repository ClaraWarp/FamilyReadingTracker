<template>
  <div class="leftbar">
    <create-family 
    v-if="createFamilyToggle && !isInFamily" 
    @toggleCreateFamily="createFamilyToggle = false" 
    />
    <no-family-summary 
    v-if="!createFamilyToggle && !isInFamily" 
    @toggleCreateFamily="createFamilyToggle = true"
    />
  </div>
</template>

<script>
import familiesService from "@/services/FamiliesService";
import CreateFamily from "./CreateFamily.vue";
import NoFamilySummary from "./NoFamilySummary.vue";
export default {
  components: { CreateFamily, NoFamilySummary },
  data() {
    return {
      createFamilyToggle: false,
    }
  },
  computed: {
    isInFamily() {
      return this.$store.state.family.name != null ? true : false;
    }
  },
  beforeMount() {
    familiesService.getFamilyByUser(this.$store.state.user.id).then(
      (response) => {
        if (response.status === 200) {
          if (response.data.familyName != null) {
            this.$store.commit("ADD_FAMILY", response.data.familyName);
            this.$store.commit("ADD_FAMILY_ROLE", response.data.familyRole)
          }
        }
      }
    )
  }
};
</script>

<style scoped>
</style>