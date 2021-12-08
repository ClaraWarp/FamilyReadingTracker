package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class AppController {

    private BookDao bookDao;
    private FamiliesDao familiesDao;
    private PrizeDao prizeDao;
    private ReadingActivityDao readingActivityDao;
    private UserDao userDao;

    //Constructor

    public AppController(BookDao bookDao, FamiliesDao familiesDao, PrizeDao prizeDao, ReadingActivityDao readingActivityDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.familiesDao = familiesDao;
        this.prizeDao = prizeDao;
        this.readingActivityDao = readingActivityDao;
        this.userDao = userDao;
    }

    //Book Methods

    @RequestMapping(path = "books/{isbn}", method = RequestMethod.GET)
    public Book getBookByISBN(@PathVariable String isbn) {
        return bookDao.getBookByISBN(isbn);
    }

    @RequestMapping(path = "books", method = RequestMethod.POST)
    public boolean addBook(@RequestBody Book book) {
        return bookDao.addBook(book);
    }

    //Families Methods

    @RequestMapping(path = "families/{name}", method = RequestMethod.GET)
    public Family getFamilyByName(@PathVariable String name) {
        return familiesDao.getFamilyByName(name);
    }

    //Prize Methods

    @RequestMapping(path = "prizes/{familyId}", method = RequestMethod.GET)
    public List<Prize> getListOfPrizesByFamily(@PathVariable Integer familyId) {
        return prizeDao.getListOfPrizesByFamily(familyId);
    }

    @RequestMapping(path = "prizes/{id}", method = RequestMethod.GET)
    public Prize getPrizeById(@PathVariable Integer id) {
        return prizeDao.getPrizeById(id);
    }

    @RequestMapping(path = "prizes/", method = RequestMethod.POST)
    public boolean createPrize(@RequestBody Prize prize) {
        return prizeDao.createPrize(prize);
    }

    //Reading Activity Methods

    @RequestMapping(path = "activity/{id}", method = RequestMethod.GET)
    public ReadingActivity getActivityById (@PathVariable int id) {
        return readingActivityDao.getActivityById(id);
    }

    @RequestMapping(path = "activity/", method = RequestMethod.POST)
    public void createActivity(@RequestBody ReadingActivity readingActivity) {
         readingActivityDao.createActivity(readingActivity);
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
        return userDao.findAll();
    } //Not sure what method is for

    @RequestMapping(path = "users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userDao.getUserById(id);
    }

    @RequestMapping(path = "users/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        return userDao.findByUsername(username);
    }

//    @RequestMapping(path = "users/", method = RequestMethod.POST)
//    public boolean addUser(@RequestBody User user) {
//        return userDao.addUser(user.getUsername(), user.getPassword(), user.getRole());
//    }




}
