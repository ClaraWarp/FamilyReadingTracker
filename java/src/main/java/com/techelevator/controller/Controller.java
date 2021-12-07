package com.techelevator.controller;


import com.techelevator.model.Family;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @RequestMapping (path = "families", method = RequestMethod.GET)
    public List<Family> getListOfFamilies() {
        return
    }
}
