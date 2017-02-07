package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookstore.domain.Author;
import com.readlearncode.dukesbookstore.domain.Book;
import com.readlearncode.dukesbookstore.domain.BookBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

        System.out.println("JsonArray response: " + response);

        for (int i = 0; i < response.size(); i++) {
            JsonObject bookJson = response.getJsonObject(i);

            List<Author> authors = new ArrayList<>();
            JsonArray authorArray = bookJson.getJsonArray("authors");

            System.out.println("JsonArray authorArray: " + authorArray);

            for(int j = 0; j < authorArray.size(); j++){
                JsonObject jObject = authorArray.getJsonObject(j);

                System.out.println("JsonObject jObject: " + jObject);

                String id = jObject.getString("id", "");
                String firstName = jObject.getString("firstName", "");
                String lastName = jObject.getString("lastName", "");
                String blogURL = jObject.getString("blogURL", "");

                Author author = new Author(id, firstName, lastName, blogURL);

                authors.add(author);
            }

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
        return allBooks;
    }


    @PreDestroy
    private void destroy() {
        client.close();
    }

    public void deleteBook(String isbn) {
        System.out.println("Delete Book ISBN: " + isbn);
    }
}
