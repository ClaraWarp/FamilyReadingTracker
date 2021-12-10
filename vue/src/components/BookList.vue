<template>
<table>
  <thead>
    <tr>
      <th>
        Book In Progress
      </th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="book in books" v-bind:key="book.isbn"  class="book">
      <!-- <router-link v-bind:to="{ name: 'books', params: {isbn: book.isbn}}">
        {{book.title}}
      </router-link> -->
      <td class="book-font">
        <i class="fas fa-book"></i>
      </td>
      <td class="book-info">{{book.title}}<br>{{book.author}}<br>{{book.isbn}}<br>{{book.description}}</td>
    </tr>
  </tbody>
</table>
</template>

<script>
import bookService from "@/services/BookService";

export default {
  name: "book-list",
  
  data() {
    return {
      books: this.$store.state.books,
    };
  },
  // methods: {
  //   bookInfo(isbn){
  //     this.$router.push(`/books/${isbn}`);
  //   }
  // },
  created() {
    bookService.getBook("ILTOV").then((response) => {
      if (response.status === 200) {
         this.$store.commit('SET_BOOK', response.data);
      }
    });
  },
};
</script>

<style>
</style>