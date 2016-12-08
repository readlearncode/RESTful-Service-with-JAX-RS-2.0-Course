package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
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
@Path("books")
public class BookStoreService {

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
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteBook(final @PathParam("id") String id) {
        bookRepository.deleteBook(id);
        return Response.ok().build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Book> books = bookRepository.getAll();
        GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books) {};
        System.out.println(books);
        return Response.ok(bookWrapper).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(final @PathParam("id") String id) {
        Book book = bookRepository.getById(id);
        return Response.ok(book).build();
    }

    @GET
    @Path("duke")
    public JsonObject getDuke(){
        return Json.createObjectBuilder()
                .add("name", "Duke")
                .build();
    }
}
