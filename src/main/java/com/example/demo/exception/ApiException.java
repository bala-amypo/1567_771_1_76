package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for handling API errors.
 * Includes a message and an HTTP status code.
 */
public class ApiException extends RuntimeException {

    private final HttpStatus status;

    // Constructor with message and status
    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    // Optional: Constructor with only message, defaults to BAD_REQUEST
    public ApiException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    // Getter for HTTP status
    public HttpStatus getStatus() {
        return status;
    }
}
