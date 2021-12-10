<template>
  <div class="book-list">
    <div v-for="book in $store.state.book" v-bind:key="book.isbn" class="book">
      <router-link v-bind:to="{ name: 'books', params: { isbn: book.isbn}}">
      {{book.title}} {{book.author}}
      </router-link>
    </div>
  </div>
</template>

<script>
import bookService from "@/services/BookService";

export default {
  name: "book-list",
  
  data() {
    return {
      books: [],
    };
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