package com.techelevator.services;

import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {

    private BookDao bookDao;

    public BookService (BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book newBook, int userID) {
        bookDao.addBook(newBook, userID);
    }

    public Book getBookByID(int bookID){
        return bookDao.getBookByID(bookID);
    }

    public int updateReadStatus(Book book){
        return bookDao.updateReadStatus(book.getBookID(),book.isRead());
    }

    public List<Book> getListOfBooksByUserID(int userID) {
        return bookDao.getListOfBooksByUserID(userID);
    }

    public List<Book> getAllBooks() {return bookDao.getAllBooks();}
}