<template>
  <div class="bookview">
    <add-book 
    v-if="toggle" 
    @toggleAddBook="toggle = false" 
    />
    <book-form
    v-if="!toggle" 
    @toggleAddBook="toggle = true"/>
  </div>
</template>

<script>
import AddBook from '../components/AddBook.vue';
import BookForm from '../components/BookForm.vue';

export default {
  components: {AddBook, BookForm  },
  data() {
    return {
      toggle: false
    }
  }
};
</script>

<style scoped>

</style>