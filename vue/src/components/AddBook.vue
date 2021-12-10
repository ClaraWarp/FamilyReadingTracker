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
    <input
      class="description-input"
      type="text"
      placeholder="DESCRIPTION"
      v-model="book.description"
    /><br />
    <button type="submit" v-on:click="saveBook()">Add Book</button>
  </form>
</template>

<script>
import bookService from '@/services/BookService'

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
    };
  },
  methods: {
    saveBook() {
      bookService.addBook(this.book).then(response => {
        if(response.status === 201){
          this.$router.push("/books")
        }
      })
    },
  },
 
};
</script>

<style>
</style>