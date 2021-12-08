package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username); //Might be able to get with findByUsername; wouldn't ID be included?

    boolean create(String username, String password, String role);
}
