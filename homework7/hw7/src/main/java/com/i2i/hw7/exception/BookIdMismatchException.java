package com.i2i.hw7.exception;


public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookIdMismatchException() {
        super("Book ID in path and body do not match");
    }

    public BookIdMismatchException(String message) {
        super(message);
    }
}
