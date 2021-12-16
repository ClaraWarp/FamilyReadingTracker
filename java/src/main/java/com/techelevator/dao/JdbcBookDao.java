package com.techelevator.dao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import com.techelevator.model.Book;

@Component
public class JdbcBookDao implements BookDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBookByID(int bookID) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookID);

        if (results.next()) {
            return mapRowToBook(results);
        } else {
            throw new RuntimeException("book was not found");
        }
    }

    @Override
    public void addBook(Book book, int userID) {

        String insertBook = "INSERT INTO books( title, author, isbn, description) VALUES(?, ?, ?, ?) RETURNING book_id" ;

        Integer bookCreated = jdbcTemplate.queryForObject(insertBook, Integer.class, book.getTitle(), book.getAuthor(), book.getIsbn(),
                book.getDescription());

        String sql = "INSERT INTO reading_activity_log (user_id, book_id) VALUES (?, ?)";

        if (bookCreated != null) {
            jdbcTemplate.update(sql,userID,bookCreated);
        }

    }

    @Override
    public int updateReadStatus(int id, boolean status) {
        String sql = "UPDATE books SET read = ? WHERE book_id = ?";

        return jdbcTemplate.update(sql,status,id);
    }

    @Override
    public List<Book> getListOfBooksByUserID(int userID) {

        String sql = "SELECT * FROM books b " +
                "JOIN reading_activity_log ral ON b.book_id = ral.book_id " +
                "WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);
        List<Book> bookList = new ArrayList<>();

        while(results.next()) {
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
        book.setBookID(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setDescription(rs.getString("description"));
//        book.setRead(rs.getBoolean("read"));

        return book;
    }
}
