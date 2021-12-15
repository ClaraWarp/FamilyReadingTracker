<template>
  <div>
      <button class="logActivityButton" @click="toggleCreateActivity">Log Activity</button>
  </div>
</template>

<script>
export default {
  methods: {
    toggleCreateActivity() {
      this.$emit('toggleCreateActivity')
    }
  }
};
</script>

<style scoped>

.logActivityButton {
  color: white;
  background-color: #353535;
  border: 1px solid #353535;
  /* border-radius: 5px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 16px; */
}

</style>