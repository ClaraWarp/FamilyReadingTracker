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
      @AddedUser="markUserUnavailable"
      @toggleUserList="toggleUserList" 
      :users="users"
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
      userListToggle: false, 
      users: []
    }
  },
  computed: {
    isInFamily() {
      return this.$store.state.family.name != null ? true : false;
    }
  },
  methods: {
    markUserUnavailable(userId) {
      this.users.forEach(user => {
        if (userId === user.id) {
          user.familyId = 1;
          // 1 is just a placeholder family
        }
      })
    },
    toggleCreateFamily() {
      this.createFamilyToggle = !this.createFamilyToggle;
    },
    toggleFamilySummary() {
      this.familySummaryToggle = true;
      this.createFamilyToggle = false;
    },
    toggleUserList() {
      this.userListToggle = !this.userListToggle;
      this.$emit("toggleBookSection")
    }
  },
  created() {
    familiesService.getUsers().then((response) => {
      if (response.status === 200) {
        let tempUsers = response.data;
        tempUsers.forEach((user) => {
          familiesService.getFamilyByUser(user.id).then((response) => {
            if (response.status === 200) {
              user.familyId = response.data.familyId;
            }
          });
        });
        this.users = tempUsers;
      }
    });
  },
  beforeMount() {
    familiesService.getFamilyByUser(this.$store.state.user.id).then(
      (response) => {
        if (response.status === 200) {
          if (response.data.familyName != null) {
            this.$store.commit("ADD_FAMILY", response.data.familyName);
            this.$store.commit("ADD_FAMILY_ROLE", response.data.familyRole);
            this.$store.commit("ADD_FAMILY_ID", response.data.familyId);
          }
        }
      }
    )
  }
};
</script>

<style scoped>
</style>