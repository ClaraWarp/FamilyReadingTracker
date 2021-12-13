<template>
  <div>
      <button class="leftButton" @click="toggleCreatePrize">Create a New Prize</button>
  </div>
</template>

<script>
export default {
  methods: {
    toggleCreatePrize() {
      this.$emit('toggleCreatePrize')
    }
  }
};
</script>

<style scoped>

.leftButton {
  color: white;
  background-color: #353535;
  border: 1px solid #353535;
  border-radius: 5px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 16px;
  
}

.leftButton:hover {
  color: #353535;
  background-color: white;
}
</style>