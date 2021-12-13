<template>
  <div class="addNewBook">
      <button class="leftButton" @click="toggleAddBook">Add A New Book</button>
  </div>
</template>

<script>
export default {
  methods: {
    toggleAddBook() {
      this.$emit('toggleAddBook')
    }
  }
};
</script>

<style scoped>

.leftButton {
  color: white;
  background-color: #6939c3;
  border: 1px solid #6939c3;
  border-radius: 5px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 16px;
}

.leftButton:hover {
  color: #6930c3;
  background-color: white;
}
</style>