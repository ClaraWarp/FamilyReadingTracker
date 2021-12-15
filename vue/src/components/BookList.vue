<template>
  <table class="table">
    <thead class="tableHead">
      <tr>
        <th>Book(s) List</th>
        <br />
      </tr>
    </thead>
    <tbody class="book">
      <tr
        v-for="book in books"
        v-bind:key="book.isbn"
        v-bind:book="book.isbn"
        class="tableRow"
      >
        <td class="book-covers">
          <!-- <i class="fas fa-book"></i> -->
          <img
            v-if="book.isbn"
            v-bind:src="
              'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
            "
          />
        </td>
        <td class="book-info">
          <br /><strong>Title:&nbsp;</strong>{{ book.title }}<br /><strong
            >Author:&nbsp;</strong
          >{{ book.author }}<br /><strong>ISBN:&nbsp;</strong>{{ book.isbn
          }}<br /><strong>Description:&nbsp;</strong>{{ book.description
          }}<br />

          <button
            class="mark-read"
            v-if="!book.read"
            v-bind:book="book.read"
            v-on:click="toggle(book)"
          >
            Mark Read
          </button>
          <button
            class="mark-unread"
            v-if="book.read"
            v-bind:book="book.read"
            v-on:click="toggle(book)"
          >
            Mark Unread
          </button>
        </td>
        <br />
      </tr>
    </tbody>
  </table>
</template>

<script>
import bookService from "@/services/BookService";

export default {
  name: "book-list",
  props: {book: Object,},

  data() {
    return {
      user: this.$store.state.user,

    };
  },
  methods: {
    toggle(book) {
      book.read = !book.read;
      bookService.updateReadStatus(book).then((response) => {
        if(response.status === 200){
          this.$store.commit("UPDATE_BOOK_STATUS", book);
        }
      });
    },
    
  },
  created() {
    bookService.getBookByUserId(this.user.id).then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_BOOK", response.data);
      }
    });
  },
  computed: {
    books() {
      return this.$store.state.books;
    },
  },
};
</script>

<style>
.table {
  display: flex;
  flex-direction: column;
}
.tableHead {
  display: flex;
  font-size: 1.25em;
  justify-content: center;
  color: #7400b8;
  margin: 30px 0px -30px 0px;
}

.bookForm {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin: 10px 10px 10px 10px;
}
.bookview {
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
}

.tableRow {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 15px;
  color: purple;
}
</style>