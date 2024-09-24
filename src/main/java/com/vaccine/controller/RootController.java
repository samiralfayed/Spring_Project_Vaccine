package com.vaccine.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootController {

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String rootMap(){
        return "Samir";
    }
}
