<template>
  <form class="book-form" v-on:submit.prevent="saveBook">
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
    <router-link to="/books/:isbn">Add Book to Reading List</router-link><br>
  </form>
</template>

<script>
import bookService from "@/services/BookService";

export default {
  name: "book",
  data() {
    return {
      book: {
        title: "",
        author: "",
        isbn: "",
      },
    };
  },
  methods: {
    saveBook() {
      const addedBook = this.$router.push({ name: "book" });
      this.$store.commit("SAVE_BOOK", addedBook);
      this.book = {
        title: "",
        author: "",
        isbn: "",
      };
    },
  },
  created() {
    bookService.getBook().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_BOOK", response.data);
      }
    });
  },
};
</script>

<style>
</style>