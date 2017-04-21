package com.readlearncode.dukesbookshop.restserver.domain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Author extends Hypermedia implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String blogURL;

    public Author() {
    }

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String id, String firstName, String lastName, String blogURL) {
        this(id, firstName, lastName);
        this.blogURL = blogURL;
    }


    @Produces(MediaType.APPLICATION_JSON)
    public String getId() {
        return id;
    }

    @GET
    @Path("/firstName")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFirstName() {
        return firstName;
    }

    @GET
    @Path("/lastName")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLastName() {
        return lastName;
    }

    @GET
    @Path("/blog")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBlogURL() {
        return blogURL;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBlogURL(String blogURL) {
        this.blogURL = blogURL;
    }


}