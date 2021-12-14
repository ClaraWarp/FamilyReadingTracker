<template>
  <div>
    <form @submit.prevent="">
      <input type="text" v-model="chosenUser" />
      <button>Add User</button>
      <br />
      <input type="radio" name="isParent" value="true" id="isParent-true" />
      <label for="isParent-true">As Parent</label>
      <input type="radio" name="isParent" value="false" id="isParent-false" />
      <label for="isParent-false">As Child</label>
    </form>
    <ul>
      <li
        v-for="(user, i) in filteredList"
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
// import familiesService from "@/services/FamiliesService";
export default {
  data() {
    return {
      chosenUser: ""
    };
  },
  props: ['users'],
  computed: {
    filteredList() {
      let filteredUsers = this.users;
      filteredUsers.reverse();
      if (this.chosenUser != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username.toLowerCase().includes(this.chosenUser.toLowerCase())
        );
      }
      return filteredUsers.slice(0, 3);
    },
  },
  methods: {
    toggleUserList() {
      this.$emit("toggleUserList");
    },
    addUserToFamily() {
      // use familesService to add to relational table
    },
    disablingUsers() {},
  }
};
</script>

<style scoped>
.disabled {
  text-decoration: line-through;
}
</style>