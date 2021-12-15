<template>
  <div class="bookview">
    <div class="openLibrary">
    <a
      href="https://openlibrary.org/collections/k-12"
      class="button"
      target="_blank"
      >View K- 12 Books on the Open Library</a>
    </div>

    <add-book v-if="toggle" @toggleAddBook="toggle = false" />
    <book-form v-if="!toggle" @toggleAddBook="toggle = true" />
    <br>
  </div>
</template>

<script>
import AddBook from "../components/AddBook.vue";
import BookForm from "../components/BookForm.vue";

export default {
  components: { AddBook, BookForm },
  data() {
    return {
      toggle: false,
    };
  },
};
</script>

<style scoped>

.button {
  display: flex;
  flex-wrap: nowrap;
  font-size: 20px;
  padding: 20px 3px;
  text-align: center;
  text-decoration: none;
  background-color: #5390d9;
  border-radius: 15px;
  outline: none;
  color: #ffffff;
}
</style>