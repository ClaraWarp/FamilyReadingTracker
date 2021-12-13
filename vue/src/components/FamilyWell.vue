<template>
  <div class="leftbar">
    <no-family-summary 
    v-if="!createFamilyToggle && !isInFamily" 
    @toggleCreateFamily="toggleCreateFamily"
    />
    <create-family 
    v-if="createFamilyToggle && !isInFamily" 
    @toggleCreateFamily="toggleCreateFamily" 
    @toggleFamilySummary="toggleFamilySummary"
    />
    <family-summary v-if="familySummaryToggle || isInFamily" 
      @toggleUserList="toggleUserList"
    />
    <users-list v-if="userListToggle"
      @toggleUserList="toggleUserList"
    />
  </div>
</template>

<script>
import familiesService from "@/services/FamiliesService";
import CreateFamily from "./CreateFamily.vue";
import NoFamilySummary from "./NoFamilySummary.vue";
import FamilySummary from './FamilySummary.vue';
import UsersList from './UsersList.vue';
export default {
  components: { CreateFamily, NoFamilySummary, FamilySummary, UsersList },
  data() {
    return {
      createFamilyToggle: false,
      familySummaryToggle: false,
      userListToggle: false
    }
  },
  computed: {
    isInFamily() {
      return this.$store.state.family.name != null ? true : false;
    }
  },
  methods: {
    toggleCreateFamily() {
      this.createFamilyToggle = !this.createFamilyToggle;
    },
    toggleFamilySummary() {
      this.familySummaryToggle = true;
      this.createFamilyToggle = false;
    },
    toggleUserList() {
      this.userListToggle = !this.userListToggle
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