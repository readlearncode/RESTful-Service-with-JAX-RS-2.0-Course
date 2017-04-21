package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.infrastructure.AuthorRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveAuthor(@Valid final Author author) {
        Author persistedAuthor = authorRepository.saveAuthor(author);
        return Response.status(Response.Status.OK).entity(persistedAuthor).build();
    }
}
