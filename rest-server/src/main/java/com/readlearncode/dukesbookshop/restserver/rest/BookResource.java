package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Book;
import com.readlearncode.dukesbookshop.restserver.domain.LinkResource;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookRepository;
import com.readlearncode.dukesbookshop.restserver.infrastructure.exceptions.ISBNNotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
@Path("/books")
public class BookResource {

    @EJB
    private BookRepository bookRepository;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBook() {
        List<Book> books = bookRepository.getAll();
        GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books) {
        };
        return Response.ok(bookWrapper).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBook(@Valid final Book book) {
        Book persistedBook = bookRepository.saveBook(book);
        return Response.status(Response.Status.OK).entity(persistedBook).build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookByIsbn(final @PathParam("isbn") String isbn) throws ISBNNotFoundException {
        Optional<Book> book = bookRepository.getByISBN(isbn);
        if (book.isPresent()) {

            Link self = Link.fromUri(uriInfo.getBaseUriBuilder()
                    .path(getClass())
                    .path(getClass(), "getBookByIsbn")
                    .build(book.get().getId()))
                    .rel("self")
                    .type("GET")
                    .build();

            Link delete = Link.fromUri(uriInfo.getBaseUriBuilder()
                    .path(getClass())
                    .path(getClass(), "deleteBook")
                    .build(book.get().getId()))
                    .rel("delete")
                    .type("DELETE")
                    .build();

            LinkResource selfLink = new LinkResource(self);
            LinkResource deleteLink = new LinkResource(delete);

            book.get().addLink(selfLink);
            book.get().addLink(deleteLink);

            return Response.ok(book.get()).links(self, delete).build();
        }
        throw new ISBNNotFoundException();
    }


    public Response deleteBook(final String isbn) throws ISBNNotFoundException {
        return null;
    }

}
