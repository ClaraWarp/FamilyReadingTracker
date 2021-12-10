package com.techelevator.controller;



import com.techelevator.model.*;
import com.techelevator.services.BookService;
import com.techelevator.services.FamiliesService;
import com.techelevator.services.PrizeService;
import com.techelevator.services.ReadingActivityService;
import com.techelevator.services.UserService;
import com.techelevator.services.ReaderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("api/v1/")
//@PreAuthorize("isAuthenticated()")
public class AppController {

    private BookService bookService;
    private FamiliesService familiesService;
    private PrizeService prizeService;
    private ReadingActivityService readingActivityService;
    private UserService userService;

    //Constructor

    public AppController(BookService bookService, FamiliesService familiesService, PrizeService prizeService, ReadingActivityService readingActivityService, UserService userService) {
        this.bookService = bookService;
        this.familiesService = familiesService;
        this.prizeService = prizeService;
        this.readingActivityService = readingActivityService;
        this.userService = userService;
    }

    //Book Methods

    @RequestMapping(path = "books/{isbn}", method = RequestMethod.GET)
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @RequestMapping(path = "books", method = RequestMethod.POST)
    public boolean addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(path = "books", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(path = "{userID}/books", method = RequestMethod.GET)
    public List<Book> getListOfBooksByUserID(@PathVariable int userID) {
        return bookService.getListOfBooksByUserID(userID);
    }

    //Families Methods

    @RequestMapping(path = "families/{name}", method = RequestMethod.GET)
    public Family getFamilyByName(@PathVariable String name) {
        return familiesService.getFamilyByName(name);
    }

    @RequestMapping(path = "families", method = RequestMethod.POST)
    public void createFamily(@RequestBody Family family) {
        familiesService.createFamily(family);
    }

    //Prize Methods

    @RequestMapping(path = "prizes/family/{familyId}", method = RequestMethod.GET)
    public List<Prize> getListOfPrizesByFamily(@PathVariable Integer familyId) {
        return prizeService.getListOfPrizesByFamily(familyId);
    }

    @RequestMapping(path = "prizes/user/{userId}", method = RequestMethod.GET)
    public List<Prize> getListOfPrizesByUser(@PathVariable Integer userId) {
        return prizeService.getListOfPrizesByUser(userId);
    }

    @RequestMapping(path = "prizes/{id}", method = RequestMethod.GET)
    public Prize getPrizeById(@PathVariable Integer id) {
        return prizeService.getPrizeById(id);
    }

    @RequestMapping(path = "prizes", method = RequestMethod.POST)
    public boolean addPrize(@RequestBody Prize prize) {
        return prizeService.addPrize(prize);
    }

    @RequestMapping(path = "prizes", method = RequestMethod.PUT)
    public boolean editPrize(@RequestBody Prize prize) {
        return prizeService.editPrize(prize);
    }

    @RequestMapping(path = "prizes/{id}", method = RequestMethod.DELETE)
    public boolean removePrize(@PathVariable int id) {
        return prizeService.removePrize(id);
    }

    //Reading Activity Methods

    @RequestMapping(path = "activity/{id}", method = RequestMethod.GET)
    public ReadingActivity getActivityById (@PathVariable int id) {
        return readingActivityService.getActivityByUserId(id);
    }

    @RequestMapping(path = "activity", method = RequestMethod.POST)
    public void addActivity(@RequestBody ReadingActivity readingActivity) {
         readingActivityService.addActivity(readingActivity);
    }

    @RequestMapping(path = "{userId}/activities", method = RequestMethod.GET)
    public List<ReadingActivity> getListOfActivitiesByUserId(@PathVariable int userId) {
        return readingActivityService.getListOfActivitiesByUserId(userId);
    }

    //Reader Methods



    //User Methods

    @RequestMapping(path = "users/", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    } //Not sure what method is for

    @RequestMapping(path = "users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(path = "users/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }





}
