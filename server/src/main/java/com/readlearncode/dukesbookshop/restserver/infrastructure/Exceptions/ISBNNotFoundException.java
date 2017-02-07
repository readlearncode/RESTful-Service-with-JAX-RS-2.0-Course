package com.readlearncode.dukesbookshop.restserver.infrastructure.Exceptions;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ISBNNotFoundException extends Exception{

    private String message;

    public ISBNNotFoundException(){
        this.message = "ISBN number not found";
    }

    public ISBNNotFoundException(String message){
        this.message = message;
    }
}