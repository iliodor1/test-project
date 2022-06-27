package com.eldar.testproject.exeption;

public class NotFoundRequestException extends RuntimeException {

    public NotFoundRequestException(String message) {
        super(message);
    }

}
