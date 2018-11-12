package com.bigasus.newse.nonFunctional.exception;


public class EnvironmentValidationException extends RuntimeException {
    public EnvironmentValidationException() {
        super();
    }
    public EnvironmentValidationException(String s) {
        super(s);
    }
    public EnvironmentValidationException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public EnvironmentValidationException(Throwable throwable) {
        super(throwable);
    }
}

