package com.techelevator.services;

import com.techelevator.model.Book;
import org.jboss.logging.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class BookService {

    private static final String API_BASE_URL = "http://localhost:8081/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     */
    public Book addBook(Book newBook) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> entity = new HttpEntity<>(newBook, headers);

        Book returnedBook = null;
        try {
            returnedBook = restTemplate.postForObject(API_BASE_URL + "books", entity, Book.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Failed to add book");
        }
        return returnedBook;
    }


    /**
     * Delete an existing reservation
     */
    public boolean deleteBook(String Isbn) {
        boolean success = false;
        try {
            restTemplate.delete(API_BASE_URL + "books/" + Isbn);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Failed to delete book");
        }
        return success;
    }
    
}