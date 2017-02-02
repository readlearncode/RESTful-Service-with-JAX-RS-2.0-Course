package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookstore.domain.Book;
import com.readlearncode.dukesbookstore.domain.BookBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class BookService {

    private static final String API_URL = "http://localhost:8081/rest-server";
    private static final String BOOKS_ENDPOINT = API_URL + "/api/books";

    private Client client;

    @PostConstruct
    public void initialise() {
        client = ClientBuilder.newClient();
    }


    public List<Book> getBooks() throws ParseException {

        List<Book> allBooks = new ArrayList<>();
        WebTarget target = client.target(BOOKS_ENDPOINT);
        JsonArray response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);

        for (int i = 0; i < response.size(); i++) {
            JsonObject bookJson = response.getJsonObject(i);

            Book book = new BookBuilder()
                    .setId(bookJson.getString("id"))
                    .setTitle(bookJson.getString("title"))
                    .setDescription(bookJson.getString("description"))
                    .setPrice((float) bookJson.getInt("price"))
                    .setImageFileName(API_URL + bookJson.getString("imageFileName"))
                    .setAuthors(
                            bookJson.getJsonArray("authors")
                                    .getValuesAs(JsonString.class)
                                    .stream()
                                    .map(JsonString::getString)
                                    .collect(Collectors.toList()))
                    .setPublished(bookJson.getString("published"))
                    .setLink(bookJson.getString("link"))
                    .createBook();

            allBooks.add(book);
        }

        System.out.println(allBooks);
        return allBooks;
    }


    @PreDestroy
    private void destroy() {
        client.close();
    }

}
