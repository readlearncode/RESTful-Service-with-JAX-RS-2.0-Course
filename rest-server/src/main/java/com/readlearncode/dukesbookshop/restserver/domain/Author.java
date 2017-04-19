package com.readlearncode.dukesbookshop.restserver.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Author extends Hypermedia implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(blogURL, author.blogURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, blogURL);
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
