package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.domain.Book;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBook(){
        List<Book> books = bookRepository.getAll();
        GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books){};
        return Response.ok(bookWrapper).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBook(final Book book){
        Book persistedBook = bookRepository.saveBook(book);
        return Response.status(Response.Status.OK).entity(persistedBook).build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookByIsbn(final @PathParam("isbn") String isbn){
       Optional<Book> book = bookRepository.getByISBN(isbn);
        if(book.isPresent()){
            return Response.ok(book.get()).build();
        }
    return Response.noContent().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{isbn: \\d{9}[\\d|X]$}")
    public Response updateBook(final Book book, final @PathParam("isbn") String isbn) {
        Book bookPersisted = bookRepository.saveBook(book);
        return Response.ok(bookPersisted).build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}/authors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorsForBook(final @PathParam("isbn") String isbn) {
        List<Author> authors = bookRepository.getByISBN(isbn).get().getAuthors();
        return Response.ok(authors).build();
    }

}
