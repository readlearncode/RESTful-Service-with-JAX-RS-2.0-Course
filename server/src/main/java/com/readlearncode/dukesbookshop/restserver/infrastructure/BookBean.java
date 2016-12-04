package com.readlearncode.dukesbookshop.restserver.infrastructure;


import com.readlearncode.dukesbookshop.restserver.domain.Book;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;
import java.util.*;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Singleton
@Startup
public class BookBean implements BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    @PostConstruct
    public void initialise(){
        this.saveBook(new Book("1234567890", "Java 101", BigDecimal.TEN, Calendar.getInstance().getTime()));
    }

    @Override
    public Book saveBook(final Book book) {
        book.setId(UUID.randomUUID().toString());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteBook(final String id) {
        if (books.containsKey(id)) {
            books.remove(id);
        }
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getById(final String id) {
        return books.get(id);
    }
}
