package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.domain.Book;
import com.readlearncode.dukesbookshop.restserver.infrastructure.AuthorRepository;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookRepository;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookShopService;
import com.readlearncode.dukesbookshop.restserver.infrastructure.Exceptions.ISBNNotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

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

    @EJB
    private AuthorRepository authorRepository;

    @EJB
    private BookShopService bookShopService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBook(@NotNull @Valid final Book book) {
        Book bookPersisted = bookRepository.saveBook(book);
        return Response.ok(bookPersisted).build();
    }

    @DELETE
    @Path("{isbn: \\d{9}[\\d|X]$}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(final @PathParam("isbn") String isbn) throws ISBNNotFoundException {
        return Response
                .ok(bookRepository.deleteBook(isbn).orElseThrow(ISBNNotFoundException::new))
                .build();
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
    @Path("{isbn: \\d{9}[\\d|X]$}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getById(final @PathParam("isbn") String isbn) {
        Optional<Book> book = bookRepository.getByISBN(isbn);
        if (book.isPresent()) {
            return Response.ok(book.get()).build();
        }

        return Response.noContent().build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}/authors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthors(final @PathParam("isbn") String isbn) {
        List<Author> authors = bookShopService.findAllAuthorsOfBookWithISBN(isbn);
        return Response.ok(authors).build();

    }

//    @GET
//    @Path("duke")
//    public JsonObject getDuke() {
//        return Json.createObjectBuilder()
//                .add("name", "Duke")
//                .build();
//    }
}
