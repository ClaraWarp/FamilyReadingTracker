package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception case that returns "User exists" if registering data that is already in database

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "User Already Exists.")
public class UserAlreadyExistsException extends RuntimeException {

}
