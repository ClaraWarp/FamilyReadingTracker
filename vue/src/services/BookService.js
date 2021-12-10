import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getBook(isbn){
        return http.get(`/api/v1/books/${isbn}`);
    },

    addBook(book){
        return http.post('/api/v1/books', book);
    },

    getBookByUserId(id){
        return http.get(`/api/v1/${id}/books`);
    }


}