package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
@Path("/books")
public class BookResource {

    @EJB
    private BookRepository bookRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBook(@NotNull @Valid final Book book) {
        Book bookPersisted = bookRepository.saveBook(book);
        return Response.ok(bookPersisted).build();
    }

    @DELETE
    @Path("{isbn:^\\d{9}[\\d|X]$}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(final @PathParam("isbn") String isbn) {
        bookRepository.deleteBook(isbn);
        return Response.ok().build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Book> books = bookRepository.getAll();
        GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books) {
        };
        System.out.println(books);
        return Response.ok(bookWrapper).build();
    }

    @GET
    @Path("{isbn:^\\d{9}[\\d|X]$}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(final @PathParam("isbn") String isbn) {
        Book book = bookRepository.getById(isbn);
        return Response.ok(book).build();
    }

//    @GET
//    @Path("duke")
//    public JsonObject getDuke() {
//        return Json.createObjectBuilder()
//                .add("name", "Duke")
//                .build();
//    }
}
