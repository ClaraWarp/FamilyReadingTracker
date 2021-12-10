package com.techelevator.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.techelevator.model.Book;

@Component
public class JdbcBookDao implements BookDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        String sql = "SELECT * FROM books WHERE isbn = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, isbn);

        if (results.next()) {
            return mapRowToBook(results);
        } else {
            throw new RuntimeException("book was not found given isbn number " + isbn);
        }
    }

    @Override
    public boolean addBook(Book book) {
        boolean bookCreated = false;

        String insertBook = "insert into books(title, author, isbn, description) values(?, ?, ?, ?)";

        bookCreated = jdbcTemplate.update(insertBook, book.getTitle(), book.getAuthor(), book.getIsbn(),
                book.getDescription()) == 1;

        return bookCreated;
    }

    @Override
    public List<Book> getListOfBooksByUserID(int userID) {

        String sql = "SELECT * FROM books b " +
                "JOIN reading_activity_log ral ON b.isbn = ral.isbn " +
                "WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);
        List<Book> bookList = new ArrayList<>();

        if (results.next()) {
            bookList.add(mapRowToBook(results));
        }

        return bookList;
    }

    @Override
    public List<Book> getAllBooks() {

        String sql = "SELECT * FROM books";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Book> bookList = new ArrayList<>();

        if (results.next()) {
            bookList.add(mapRowToBook(results));
        }
        return bookList;
    }

    private Book mapRowToBook(SqlRowSet rs) {
        Book book = new Book();
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setDescription(rs.getString("description"));

        return book;
    }
}
