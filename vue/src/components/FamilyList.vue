<template>
  <ul>
    <li v-for="(user, i) in familyList" :key="i">{{user.username}}</li>
  </ul>
</template>

<script>
export default {
  props: ["users"],
  computed: {
      familyList() {
          return this.users.filter(user => {
              return user.familyId === this.$store.state.family.id;
          })
      }
  },
  created() {
    this.$emit("RefreshUsers")
  }
};
</script>

<style>
</style>