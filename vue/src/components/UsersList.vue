<template>
  <div>
    <p id="instructions">Select 'Parent' or 'Child' and enter person's full username below:</p>
    <form @submit.prevent="addUserToFamily">
      <input type="text" v-model="chosenUser" />
      <br />
      <input type="radio" name="isParent" value="true" id="isParent-true" v-model="isParent" />
      <label for="isParent-true">As Parent</label>
      <input type="radio" name="isParent" value="false" id="isParent-false" v-model="isParent" />
      <label for="isParent-false">As Child</label>
      <button>Add User</button>
    </form>
    <ul>
      <li
        v-for="(user, i) in slicedFilteredList"
        :key="i"
        :class="{ disabled: user.familyId != 0 }"
      >
        {{ user.username }}
      </li>
      <li>...</li>
    </ul>
    <button @click="toggleUserList">Back></button>
  </div>
</template>

<script>
import familiesService from "@/services/FamiliesService";
export default {
  data() {
    return {
      chosenUser: "",
      userIdToAdd: null,
      isParent: null,
      filteredUsers: []
    };
  },
  props: ["users"],
  computed: {
    filteredList() {
      let filteredUsers = this.users;
      filteredUsers.reverse();
      if (this.chosenUser != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username.toLowerCase().includes(this.chosenUser.toLowerCase())
        );
      }
      return filteredUsers;
    },
    slicedFilteredList() {
      return this.filteredList.slice(0, 3);
    }
  },
  methods: {
    toggleUserList() {
      this.$emit("toggleUserList");
    },
    addUserToFamily() {
      let chosenUserSum = this.users.find((user) => {
        return (user.username.toLowerCase() == this.chosenUser.toLowerCase());
      });
      let instructions = document.getElementById('instructions');
      if (chosenUserSum != undefined && chosenUserSum.familyId === 0 && this.isParent != null) {
        familiesService
          .addUserToFamily(
            this.$store.state.user.id,
            chosenUserSum.id,
            this.isParent
          )
          .then((response) => {
            if (response.status === 200) {
              this.$emit("toggleUserList");
            }
          });
      } else if (this.isParent != null) {
        instructions.innerHTML = '*** That user is already in a family! ***';
      } else {
        instructions.innerHTML = '*** Please add them as a Parent or a Child ***'
      }
    },
  },
};
</script>

<style scoped>
.disabled {
  text-decoration: line-through;
}
</style>