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
    <button type="submit" v-on:click="saveBook(book.isbn)">Add Book</button>
  </form>
</template>

<script>

export default {
  name: "AddBook",
 
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
    saveBook(isbn) {
      
      const addedBook = this.$router.push(`/books/${isbn}`);
      this.$store.commit("SET_BOOK", addedBook);
      this.book = {
        title: "",
        author: "",
        isbn: "",
      }
    },
  },
 
};
</script>

<style>
</style>