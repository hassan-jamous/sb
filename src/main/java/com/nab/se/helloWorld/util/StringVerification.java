package com.nab.se.helloWorld.util;

import org.springframework.stereotype.Component;

@Component
public class StringVerification {

    public boolean isInvalidLength(String input, int minLength, int maxLength) {
        return !(input.length() >= minLength && input.length() <= maxLength);
    }
}
