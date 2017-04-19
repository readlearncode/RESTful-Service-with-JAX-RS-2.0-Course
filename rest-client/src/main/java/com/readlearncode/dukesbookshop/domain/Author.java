package com.readlearncode.dukesbookshop.domain;


import java.io.Serializable;
import java.util.UUID;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Author implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String blogURL;

    public Author(){}

    public Author(String firstName, String lastName){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, String blogURL){
        this(firstName, lastName);
        this.blogURL = blogURL;
    }

    public Author(String id, String firstName, String lastName, String blogURL){
        this(firstName, lastName, blogURL);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBlogURL() {
        return blogURL;
    }

    public void setBlogURL(String blogURL) {
        this.blogURL = blogURL;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", blogURL='" + blogURL + '\'' +
                '}';
    }
}