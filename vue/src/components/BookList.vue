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
.table{
  display: flex;
  flex-direction: column;
  
}
.tableHead{
  display: flex;
  font-size: 1.5em;
  justify-content: center;
  color: #7400B8;
  padding: 15px 0px 0px 0px;
}
.header{
  display: flex;
  background-color: white;
}
.bookForm{
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  margin: 10px 10px 10px 10px;

}
 .bookview{
   display: flex;
   flex-grow: 1;
   justify-content: space-between;
 }
/* .fas {
  font-size: 25px;
} */
/* .book{
  display: flex;
  justify-content: space-between;
  flex-wrap: nowrap;
  font-size: 20px;
} */
.tableRow{
  display: flex;
  font-size: 25px;
  
}
 .book-covers{
  display: flex;
  flex-wrap: nowrap;
  font-size: 25px;
  justify-content: space-;
}
.book-info{
  display: flex;
  flex-wrap: nowrap;
  font-size: 25px;
  justify-content: space-;
}
</style>