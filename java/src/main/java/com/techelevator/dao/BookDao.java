package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    Book getBookByISBN(String isbn);

    boolean addBook(Book book, int userID);

    List<Book> getListOfBooksByUserID(int userID);

    List<Book> getAllBooks();

//    String getISBNByBook();

//    List<Book> listOfBooks();





}
