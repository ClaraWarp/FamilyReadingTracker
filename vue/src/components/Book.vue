<template>
  <div>
      



  </div>
</template>

<script>
import bookService from "@/services/BookService";

export default {
  name: "book",
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