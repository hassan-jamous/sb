package com.bigasus.newse.services;

import org.springframework.stereotype.Service;

@Service
public class BigasusService {

    public String getMeSomething(String token) {
        return "something " + token;
    }
}
