import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getBook(isbn){
        return http.get(`/books/${isbn}`);
    },

    addBook(book){
        return http.post('/books', book);
    }


}