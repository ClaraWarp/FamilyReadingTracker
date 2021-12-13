import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    books: [],
    bookIsbn: null,
    prizes: [],
    family: {
      name: null,
      role: null,
      id: null
    },
    currentBook: null,

    token: currentToken || '',
    user: currentUser || {}
  },
  mutations: {
    CLEAR_FAMILY(state) {
      state.family.name = null;
      state.family.role = null;
    },
    ADD_FAMILY(state, familyName) {
      state.family.name = familyName;
      state.family.role = true;
    },
    ADD_FAMILY_ROLE(state, familyRole) {
      state.family.role = familyRole
    },
    ADD_FAMILY_ID(state, familyId) {
      state.family.id = familyId;
    },
    SET_BOOK(state, books){
      state.books = books;
    },
    SET_BOOK_ISBN(state, bookIsbn){
      state.bookIsbn = bookIsbn;
    },
    ADD_CURRENT_BOOK(state, currentBook){
      state.currentBook = currentBook;
    },
    SET_PRIZE(state, prizes) {
      state.prizes = prizes;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
