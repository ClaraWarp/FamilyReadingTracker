package com.techelevator.model;

//This class holds information for a book.

public class Book {

    private int bookID;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private boolean read;

    public Book(){}

    public Book(int bookID, String title, String author, String isbn, String description, Boolean read){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.read = read;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
