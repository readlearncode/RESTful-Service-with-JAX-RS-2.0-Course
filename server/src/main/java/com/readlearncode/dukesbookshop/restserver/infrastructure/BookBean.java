package com.readlearncode.dukesbookshop.restserver.infrastructure;


import com.readlearncode.dukesbookshop.restserver.domain.Book;

import javax.ejb.Stateless;
import java.util.*;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class BookBean implements BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    @Override
    public Book saveBook(final Book book) {
        if (Objects.isNull(book.getId())) {
            book.setId(UUID.randomUUID().toString());
        }
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
