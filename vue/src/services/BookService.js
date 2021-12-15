import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getBook(bookID){
        return http.get(`/api/v1/books/${bookID}`);
    },

    addBook(book, userID){
        return http.post(`/api/v1/books/${userID}`, book);
    },

    getBookByUserId(id){
        return http.get(`/api/v1/${id}/books`);
    },

    updateReadStatus(book){
        return http.put(`/api/v1/books/${book.bookID}`, book);
    }

}