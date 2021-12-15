<template>
<table class ="table">
  <thead class="tableHead">
    <tr>
      <th>
        Book(s) In Progress
      </th><br>
    </tr>
  </thead>
  <tbody class="book">
    <tr v-for="book in books" v-bind:key="book.isbn"  class="tableRow">
      <td class="book-covers">
        <!-- <i class="fas fa-book"></i> -->
        <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'"/>
      </td>
      <td class="book-info">Title:&nbsp;{{book.title}}<br>Author:&nbsp;{{book.author}}<br>ISBN:&nbsp;{{book.isbn}}<br>Description:&nbsp;{{book.description}}<br></td>
    <br>
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
.table{
  display: flex;
  flex-direction: column;
  
}
.tableHead{
  display: flex;
  font-size: 1.25em;
  justify-content: center;
  color: #7400B8;
  margin: 30px 0px -30px 0px;
}

.bookForm{
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin: 10px 10px 10px 10px;

}
 .bookview{
   display: flex;
   flex-grow: 1;
   justify-content: space-between;
 }

.tableRow{
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 17px;
  color: purple;
  }
</style>