package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookshop.domain.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class BookServiceImpl implements BookService {

    private static final String API_URL = "http://localhost:8081/rest-server";
    private static final String BOOKS_ENDPOINT = API_URL + "/api/books";

    private List<Book> cachedBooks = new ArrayList<>();

    private Client client;

    @PostConstruct
    public void initialise() {
        client = ClientBuilder.newClient();
    }

    @Override
    public List<Book> getBooks() {

        List<Book> allBooks = new ArrayList<>();

        WebTarget target = client.target(BOOKS_ENDPOINT);

        Future<ArrayList<Book>> bookCall =
                target.request(MediaType.APPLICATION_JSON).async().get(
                        new InvocationCallback<ArrayList<Book>>() {

                            @Override
                            public void completed(ArrayList<Book> arrayListGenericType) {
                                allBooks.addAll(arrayListGenericType);
                                // populate cache with new books
                                cachedBooks.clear();
                                cachedBooks.addAll(arrayListGenericType);
                            }

                            @Override
                            public void failed(Throwable throwable) {
                                // use cached book list
                                allBooks.addAll(cachedBooks);
                            }
                        });

        while (!bookCall.isDone()) ;

        System.out.println("AllBooks: " + allBooks);

        return Collections.unmodifiableList(allBooks);
    }


//    @Override
//    public List<Book> getBooks() {
//
//        allBooks = new ArrayList<>(); //  Fix this hack
//
//        WebTarget target = client.target(BOOKS_ENDPOINT);
//
//        Response rep = target.request(MediaType.APPLICATION_JSON).get();
//
//        // If links are embedded in the HTTP Header, uncomment this code
//        Set<Link> links = rep.getLinks();
//        System.out.println("links: " + links);
//
//        JsonArray response = rep.readEntity(JsonArray.class);
////        List<Book> response = rep.readEntity(new GenericType<List<Book>>() {});
//
//        System.out.println("response: " + response);
//
//
////        JsonArray response        .get(JsonArray.class);
////        Response response = target.request(MediaType.APPLICATION_JSON).get().getLinks();
////        List<Book> allBooks = response.readEntity(new GenericType<ArrayList<Book>>(){});
////        System.out.println("AllBooks: " + allBooks);
//
//
//        System.out.println("JsonArray response: " + response);
//
//        for (int i = 0; i < response.size(); i++) {
//            JsonObject bookJson = response.getJsonObject(i);
//
//            List<Author> authors = extractAuthors(bookJson.getJsonArray("authors"));
//            List<LinkResource> hyperlinks = extractLinks(bookJson.getJsonArray("links"));
//
//            Book book = new BookBuilder()
//                    .setId(bookJson.getString("id"))
//                    .setTitle(bookJson.getString("title"))
//                    .setDescription(bookJson.getString("description"))
//                    .setPrice((float) bookJson.getInt("price"))
//                    .setImageFileName(bookJson.getString("imageFileName"))
//                    .setAuthors(authors)
//                    .setPublished(bookJson.getString("published"))
//                    .setLink(bookJson.getString("link"))
//                    .setHyperlinks(hyperlinks)
//                    .createBook();
//
//            allBooks.add(book);
//        }
//
//        System.out.println("allBooks = " + allBooks);
//        return Collections.unmodifiableList(allBooks);
//    }

    @Override
    public Book getBook(String id) {

        WebTarget target = client.target(BOOKS_ENDPOINT + "/" + id);
//        JsonObject jsonResponse = target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);

        Future<Response> bookCall = target.request(MediaType.APPLICATION_JSON).async().get();

        while(!bookCall.isDone());

        Response response = null;
        try {
            response = bookCall.get(60_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }


        Set<Link> links = response.getLinks();

        System.out.println("links: " + links);

        JsonObject jsonResponse = response.readEntity(JsonObject.class);

        System.out.println("jsonResponse: " + jsonResponse);

        List<Author> authors = extractAuthors(jsonResponse.getJsonArray("authors"));

        System.out.println("authors: " + authors);


        List<LinkResource> hyperlinks = extractLinks(jsonResponse.getJsonArray("links"));

        Book book = new BookBuilder()
                .setId(jsonResponse.getString("id"))
                .setTitle(jsonResponse.getString("title"))
                .setDescription(jsonResponse.getString("description"))
                .setPrice((float) jsonResponse.getInt("price"))
                .setImageFileName(API_URL + jsonResponse.getString("imageFileName"))
                .setAuthors(authors)
                .setPublished(jsonResponse.getString("published"))
                .setLink(jsonResponse.getString("link"))
                .setHyperlinks(hyperlinks)
                .createBook();

        System.out.println("book: " + book);

        return book;
    }


    @Override
    public void deleteBook(String isbn) {

        // Use cached book list to determine delete URI

        System.out.println("deleteBook method: " + cachedBooks);
        System.out.println("deleteBook isbn: " + isbn);

        String uri = cachedBooks.stream()
                .filter(book -> book.getId().equals(isbn))
                .map(Hypermedia::getLinks)
                .findFirst()
                .get()
                .stream()
                .filter(linkResource -> linkResource.getRel().equals("delete"))
                .findFirst()
                .get()
                .getUri();

        System.out.println("Delete Book uri: " + uri);


        WebTarget target = client.target(uri);

        Response response = target.request(MediaType.APPLICATION_JSON).delete();

        System.out.println("Delete Book ISBN: " + isbn);
        System.out.println("Delete Book ISBN: response " + response);
    }

    @Override
    public Book saveBook(Book book) {
        throw new UnsupportedOperationException();
    }

    /**
     * Extracts the author list form the json object
     *
     * @param authorArray the JSON Array that contains the author list
     * @return list of authors
     */
    public List<Author> extractAuthors(JsonArray authorArray) {
        List<Author> authors = new ArrayList<>();

        System.out.println("authorArray: " + authorArray);
        System.out.println("authorArray size: " + authorArray.size());

        for (int j = 0; j < authorArray.size(); j++) {
            JsonObject jObject = authorArray.getJsonObject(j);
            String id = jObject.getString("id", "");
            String firstName = jObject.getString("firstName", "");
            String lastName = jObject.getString("lastName", "");
            String blogURL = jObject.getString("blogURL", "");
            authors.add(new Author(id, firstName, lastName, blogURL));
        }

        return Collections.unmodifiableList(authors);
    }


    /**
     * Extracts the links from the json object
     *
     * @param linkArray the JSON array that contains the link list
     * @return list of links
     */
    private List<LinkResource> extractLinks(JsonArray linkArray) {

        List<LinkResource> links = new ArrayList<>();

        for (int j = 0; j < linkArray.size(); j++) {
            JsonObject jObject = linkArray.getJsonObject(j);
            String rel = jObject.getString("rel", "");
            String type = jObject.getString("type", "");
            String uri = jObject.getString("uri", "");
            links.add(new LinkResource(rel, type, uri));
        }

        return Collections.unmodifiableList(links);
    }

    @PreDestroy
    private void destroy() {
        client.close();
    }
}
