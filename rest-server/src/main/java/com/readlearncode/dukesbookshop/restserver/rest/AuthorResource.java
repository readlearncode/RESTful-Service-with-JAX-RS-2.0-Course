package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.domain.LinkResource;
import com.readlearncode.dukesbookshop.restserver.infrastructure.AuthorRepository;
import com.readlearncode.dukesbookshop.restserver.infrastructure.exceptions.AuthorIDNotRecognisedException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.List;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
@Path("/authors")
public class AuthorResource {

    @Context
    private UriInfo uriInfo;

    @EJB
    private AuthorRepository authorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAuthors() {

        List<Author> authors = authorRepository.getAll();

        for (Author author : authors) {

            Link self = Link.fromUri(uriInfo.getBaseUriBuilder()
                    .path(getClass())
                    .path(getClass(), "getAuthor")
                    .build(author.getId()))
                    .rel("self")
                    .type("GET")
                    .build();

            LinkResource selfLink = new LinkResource(self);
            author.addLink(selfLink);
        }

        return Response.ok(new GenericEntity<List<Author>>(authors) {}).build();
    }


    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthor(final @PathParam("id") String id) throws AuthorIDNotRecognisedException {
        Author author = authorRepository.getById(id).orElseThrow(AuthorIDNotRecognisedException::new);

        Link self = Link.fromUri(uriInfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "getAuthor")
                .build(author.getId()))
                .rel("self")
                .type("GET")
                .build();

        LinkResource selfLink = new LinkResource(self);

        author.addLink(selfLink);

        return Response.ok(author).build();
    }

}
