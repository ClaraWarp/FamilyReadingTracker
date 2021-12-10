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
      user: this.$store.state.user,
    };
  },
  created() {
    bookService.getBookByUserId(this.user.id).then((response) => {
      if (response.status === 200) {
         this.$store.commit('SET_BOOK', response.data);
      }
    });
  },
  computed: {
    
    books(){
      return this.$store.state.books;
    }
  }
};
</script>

<style>
</style>