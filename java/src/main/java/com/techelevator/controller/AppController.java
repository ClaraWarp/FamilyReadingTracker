package com.techelevator.controller;



import com.techelevator.model.*;
import com.techelevator.services.BookService;
import com.techelevator.services.FamiliesService;
import com.techelevator.services.PrizeService;
import com.techelevator.services.ReadingActivityService;
import com.techelevator.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    //Families Methods

    @RequestMapping(path = "families/{name}", method = RequestMethod.GET)
    public Family getFamilyByName(@PathVariable String name) {
        return familiesService.getFamilyByName(name);
    }

    //Prize Methods

    @RequestMapping(path = "prizes/{familyId}", method = RequestMethod.GET)
    public List<Prize> getListOfPrizesByFamily(@PathVariable Integer familyId) {
        return prizeService.getListOfPrizesByFamily(familyId);
    }

    @RequestMapping(path = "prizes/{id}", method = RequestMethod.GET)
    public Prize getPrizeById(@PathVariable Integer id) {
        return prizeService.getPrizeById(id);
    }

    @RequestMapping(path = "prizes/", method = RequestMethod.POST)
    public boolean createPrize(@RequestBody Prize prize) {
        return prizeService.createPrize(prize);
    }

    //Reading Activity Methods

    @RequestMapping(path = "activity/{id}", method = RequestMethod.GET)
    public ReadingActivity getActivityById (@PathVariable int id) {
        return readingActivityService.getActivityById(id);
    }

    @RequestMapping(path = "activity/", method = RequestMethod.POST)
    public void createActivity(@RequestBody ReadingActivity readingActivity) {
         readingActivityService.createActivity(readingActivity);
    }

//    @RequestMapping(path = "activity/", method = RequestMethod.PUT)
//    public void updateActivity(@RequestBody ReadingActivity readingActivity) {
//        readingActivityDao.updateActivity(readingActivity);
//    }

//    @RequestMapping(path = "activity/{id}", method = RequestMethod.DELETE)
//    public void deleteActivity(@PathVariable int id) {
//        readingActivityDao.deleteActivity(id);
//    }

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

//    @RequestMapping(path = "users/", method = RequestMethod.POST)
//    public boolean addUser(@RequestBody User user) {
//        return userDao.addUser(user.getUsername(), user.getPassword(), user.getRole());
//    }




}
