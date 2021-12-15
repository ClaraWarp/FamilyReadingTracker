<template>
  <form class="book-form" v-on:submit="resetForm">
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
    <textarea rows="5" cols="20"
      class="description-input"
      type="text"
      placeholder="Description"
      v-model="book.description"
    /><br />
    <button class="addBook" type="submit" v-on:click="saveBook">Add Book</button>&nbsp;
    <button class="closeForm" type="button" @click="toggleAddBook">Close Form</button>
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
      user: this.$store.state.user,
    };
  },
  methods: {
    toggleAddBook() {
      this.$emit("toggleAddBook");
    },
    saveBook() {
      bookService.addBook(this.book, this.user.id).then((response) => {
        if (response.status === 201) {
          this.$store.commit("SET_CURRENT_BOOK", this.book, this.user.id);
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

.addBook, .closeForm{
  color: white;
  background-color: #6939c3;
  border: 1px solid #6939c3;
  border-radius: 15px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 12px;
}

.addBook:hover,.closeForm:hover {
  color: #6930c3;
  background-color: white;
}

.description-input{
  margin: 20px 0px 0px 0px ;
  max-width: 165px;
  max-height: 150px;
  min-height: 17px;
}
</style>