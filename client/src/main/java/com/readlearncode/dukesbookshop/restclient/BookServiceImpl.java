package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookstore.domain.Author;
import com.readlearncode.dukesbookstore.domain.Book;
import com.readlearncode.dukesbookstore.domain.BookBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private Client client;

    @PostConstruct
    public void initialise() {
        client = ClientBuilder.newClient();
    }

    @Override
    public List<Book> getBooks() {

        List<Book> allBooks = new ArrayList<>();
        WebTarget target = client.target(BOOKS_ENDPOINT);
        JsonArray response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);

        System.out.println("JsonArray response: " + response);

        for (int i = 0; i < response.size(); i++) {
            JsonObject bookJson = response.getJsonObject(i);

            List<Author> authors = extractAuthors(bookJson.getJsonArray("authors"));

            Book book = new BookBuilder()
                    .setId(bookJson.getString("id"))
                    .setTitle(bookJson.getString("title"))
                    .setDescription(bookJson.getString("description"))
                    .setPrice((float) bookJson.getInt("price"))
                    .setImageFileName(API_URL + bookJson.getString("imageFileName"))
                    .setAuthors(authors)
                    .setPublished(bookJson.getString("published"))
                    .setLink(bookJson.getString("link"))
                    .createBook();

            allBooks.add(book);
        }

        System.out.println(allBooks);
        return Collections.unmodifiableList(allBooks);
    }

    @Override
    public Book getBook(String id) {
        WebTarget target = client.target(BOOKS_ENDPOINT + "/" + id);
        JsonObject response = target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);

        List<Author> authors = extractAuthors(response.getJsonArray("authors"));

        Book book = new BookBuilder()
                .setId(response.getString("id"))
                .setTitle(response.getString("title"))
                .setDescription(response.getString("description"))
                .setPrice((float) response.getInt("price"))
                .setImageFileName(API_URL + response.getString("imageFileName"))
                .setAuthors(authors)
                .setPublished(response.getString("published"))
                .setLink(response.getString("link"))
                .createBook();

        return book;
    }

    @Override
    public void deleteBook(String isbn) {
        System.out.println("Delete Book ISBN: " + isbn);
    }

    @Override
    public Book saveBook(Book book) {
        return null;
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


    @PreDestroy
    private void destroy() {
        client.close();
    }
}
