package com.readlearncode.dukesbookshop.restserver.rest;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.domain.Book;
import com.readlearncode.dukesbookshop.restserver.domain.Hypermedia;
import com.readlearncode.dukesbookshop.restserver.domain.LinkResource;
import com.readlearncode.dukesbookshop.restserver.infrastructure.AuthorRepository;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookRepository;
import com.readlearncode.dukesbookshop.restserver.infrastructure.BookShopService;
import com.readlearncode.dukesbookshop.restserver.infrastructure.Exceptions.ISBNNotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
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
public class BookResource extends Hypermedia {

    @EJB
    private BookRepository bookRepository;

    @EJB
    private AuthorRepository authorRepository;

    @EJB
    private BookShopService bookShopService;

    @Context
    private UriInfo uriInfo;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(@Valid final Book book) {
        Book bookPersisted = bookRepository.saveBook(book);
        return Response.ok(bookPersisted).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBook(@Valid final Book book) {
        Book bookPersisted = bookRepository.saveBook(book);
        return Response.ok(bookPersisted).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{isbn: \\d{9}[\\d|X]$}")
    public Response saveBookWithISBN(@Valid final Book book) {
        Book bookPersisted = bookRepository.saveBook(book);
        return Response.ok(bookPersisted).build();
    }

    @DELETE
    @Path("{isbn: \\d{9}[\\d|X]$}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(final @PathParam("isbn") String isbn) throws ISBNNotFoundException {

//        Response response;
//        try{
//            response = Response.ok(bookRepository.deleteBook(isbn).get()).build();
//        } catch (Exception e){
//            response = Response.status(Response.Status.NOT_FOUND).build();
//        }
//        return response;

//        try {
//            return Response.ok(bookRepository.deleteBook(isbn)).build();
//        } catch (Exception e) {
//            throw new WebApplicationException(Response.Status.NO_CONTENT);
//        }

        return Response
                .ok(bookRepository.deleteBook(isbn).orElseThrow(ISBNNotFoundException::new))
                .build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        List<Book> books = bookRepository.getAll();
        books.forEach(book -> setHypermedia(book, uriInfo));
        System.out.println(books);
        return Response.ok(new GenericEntity<List<Book>>(books) {
        }).build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
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
//        return Response.noContent().build();
    }

    @GET
    @Path("{isbn: \\d{9}[\\d|X]$}/authors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthors(final @PathParam("isbn") String isbn) {
        List<Author> authors = bookShopService.findAllAuthorsOfBookWithISBN(isbn);
        return Response.ok(authors).build();
    }


    private void setHypermedia(Book book, UriInfo uriInfo) {

        System.out.println("uriInfo.getBaseUriBuilder() = " + uriInfo.getBaseUriBuilder());

        Link self = Link.fromUri(uriInfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "getBookByIsbn")
                .build(book.getId()))
                .rel("self")
                .type("GET")
                .build();

        Link delete = Link.fromUri(uriInfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "deleteBook")
                .build(book.getId()))
                .rel("delete")
                .type("DELETE")
                .build();

        LinkResource selfLink = new LinkResource(self);
        LinkResource deleteLink = new LinkResource(delete);

        book.addLink(selfLink);
        book.addLink(deleteLink);

    }

//    @GET
//    @Path("duke")
//    public JsonObject getDuke() {
//        return Json.createObjectBuilder()
//                .add("name", "Duke")
//                .build();
//    }
}
