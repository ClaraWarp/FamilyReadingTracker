package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    Book getBookByISBN(String isbn);

    void addBook(String title, String author, String isbn);

//    String getISBNByBook();

//    List<Book> listOfBooks();





}
