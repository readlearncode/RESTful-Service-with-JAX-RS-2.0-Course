package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Book;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
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
    public Response getAllBook(){
        List<Book> books = bookRepository.getAll();
        GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books){};
        return Response.ok(bookWrapper).build();
    }

    @POST
    public Response saveBook(final Book book){
        Book persistedBook = bookRepository.saveBook(book);
        return Response.status(Response.Status.OK).entity(persistedBook).build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}")
    public Response getBookByIsbn(final @PathParam("isbn") String isbn){
       Optional<Book> book = bookRepository.getByISBN(isbn);
        if(book.isPresent()){
            return Response.ok(book.get()).build();
        }
    return Response.noContent().build();
    }

}
