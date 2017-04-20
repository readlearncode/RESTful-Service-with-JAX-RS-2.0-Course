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
import javax.ws.rs.core.GenericType;
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
        WebTarget target = client.target(BOOKS_ENDPOINT);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        cachedBooks = response.readEntity(new GenericType<ArrayList<Book>>() {});
        return Collections.unmodifiableList(cachedBooks);
    }

    @PreDestroy
    private void destroy() {
        client.close();
    }

    @Override
    public Book getBook(String id) {
        return null;
    }

    @Override
    public void deleteBook(String isbn) {}

    @Override
    public Book saveBook(Book book) {
        return null;
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


    /**
     * Extracts the author list form the json object
     *
     * @param authorArray the JSON Array that contains the author list
     * @return list of authors
     */
    public List<Author> extractAuthors(JsonArray authorArray) {
        List<Author> authors = new ArrayList<>();

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

}
