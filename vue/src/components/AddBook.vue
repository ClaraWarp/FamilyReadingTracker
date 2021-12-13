<template>
  <form class="book-form" v-on:submit.prevent="resetForm">
    <input
      class="title-input"
      type="text"
      placeholder="Title"
      v-model="book.title"
    /><br />
    <input
      class="author-input"
      type="text"
      placeholder="Author"
      v-model="book.author"
    /><br />
    <input
      class="isbn-input"
      type="text"
      placeholder="ISBN"
      v-model="book.isbn"
    /><br />
    <input
      class="description-input"
      type="text"
      placeholder="Description"
      v-model="book.description"
    /><br />
    <button type="submit" v-on:click="saveBook">Add Book</button>&nbsp;
    <button type="button" @click="toggleAddBook">Back</button>
  </form>
</template>

<script>
import bookService from "@/services/BookService";

export default {
  name: "AddBook",

  data() {
    return {
      book: {
        title: "",
        author: "",
        isbn: "",
        description: "",
      },
      showForm: false,
    };
  },
  methods: {
    toggleAddBook() {
      this.$emit("toggleAddBook");
    },
    saveBook() {
      bookService.addBook(this.book).then((response) => {
        if (response.status === 201) {
          this.$router.push("/books");
          this.resetForm();
        }
      });
    },
     resetForm() {
      this.book = {};
      this.showForm = false;
    },
  },
};
</script>

<style>
</style>