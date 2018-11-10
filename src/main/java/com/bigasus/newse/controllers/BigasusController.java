package com.bigasus.newse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BigasusController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Bigasus!";
    }
}
