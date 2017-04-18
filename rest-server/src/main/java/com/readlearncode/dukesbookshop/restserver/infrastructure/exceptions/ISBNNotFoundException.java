package com.readlearncode.dukesbookshop.restserver.infrastructure.exceptions;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ISBNNotFoundException extends Exception {

    private String message;

    public ISBNNotFoundException() {
        this.message = "ISBN not found";
    }

    public ISBNNotFoundException(String message) {
        this.message = message;
    }
}
