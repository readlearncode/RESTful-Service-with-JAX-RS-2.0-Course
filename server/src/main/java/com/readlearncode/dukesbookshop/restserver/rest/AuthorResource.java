package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.infrastructure.AuthorRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
@Path("/authors")
public class AuthorResource {

    @EJB
    private AuthorRepository authorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAuthors(){
        return Response.ok(authorRepository.getAll()).build();
    }

//    @GET
//    @Path("/id/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAuthor(final @PathParam("id") String id) throws AuthorIDNotRecognised {
//        Author author =  authorRepository.getById(id).orElseThrow(AuthorIDNotRecognised::new);
//        return Response.ok(author).build();
//    }
//
//
//    @Path("/id/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Object getAuthorResource(final @PathParam("id") String id) throws AuthorIDNotRecognised {
//
//        System.out.println("id: " + id);
//        Author author =  authorRepository.getById(id).orElseThrow(AuthorIDNotRecognised::new);
//
//        System.out.println("author: " + author);
//
//        return author;
////        return Response.ok(author).build();
//
//    }
}