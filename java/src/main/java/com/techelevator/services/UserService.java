package com.techelevator.services;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    } //Not sure what method is for

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
