package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookshop.domain.Author;
import com.readlearncode.dukesbookshop.domain.Book;

import javax.json.JsonArray;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public interface BookService {
     List<Book> getBooks();
     Book getBook(String id);
     void deleteBook(String isbn);
     Book saveBook(Book book);
     List<Author> extractAuthors(JsonArray authorArray);
}
