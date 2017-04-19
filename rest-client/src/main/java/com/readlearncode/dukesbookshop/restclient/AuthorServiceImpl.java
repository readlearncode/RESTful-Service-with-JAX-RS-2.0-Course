package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookshop.domain.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class AuthorServiceImpl implements AuthorService {

    private static final String API_URL = "http://localhost:8081/rest-server";
    private static final String AUTHORS_ENDPOINT = API_URL + "/api/authors";

    private Client client;

    @Inject
    private BookService bookService;

    @PostConstruct
    public void initialise() {
        client = ClientBuilder.newClient();
    }


    @Override
    public List<Author> getAuthors() {
        WebTarget target = client.target(AUTHORS_ENDPOINT);
        JsonArray authorArray = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        List<Author> authors = bookService.extractAuthors(authorArray);
        return Collections.unmodifiableList(authors);
    }

    @Override
    public Author getAuthor(String id) {
        return null;
    }


}