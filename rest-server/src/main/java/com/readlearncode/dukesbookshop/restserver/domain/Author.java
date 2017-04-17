package com.readlearncode.dukesbookshop.restserver.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Author implements Serializable {


    private String id;
    private String firstName;
    private String lastName;
    private String blogURL;

    public Author(){}

    public Author(String id, String firstName, String lastName, String blogURL) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogURL = blogURL;
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
}
