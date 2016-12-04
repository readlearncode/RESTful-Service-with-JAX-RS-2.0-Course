package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Book;

import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public interface BookRepository {

    Book saveBook(final Book book);

    void deleteBook(final String id);

    List<Book> getAll();

    Book getById(String id);
}
