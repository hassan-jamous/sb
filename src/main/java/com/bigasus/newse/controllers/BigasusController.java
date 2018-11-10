package com.bigasus.newse.controllers;

import com.bigasus.newse.services.BigasusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BigasusController {

    @Autowired
    BigasusService bigasusService;

    @GetMapping(value = "/{token}")
    public String token(@PathVariable String token) {
        return bigasusService.getMeSomething(token);
    }
}
