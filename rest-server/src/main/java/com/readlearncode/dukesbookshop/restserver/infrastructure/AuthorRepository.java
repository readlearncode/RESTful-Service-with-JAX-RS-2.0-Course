package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Author;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public interface AuthorRepository {

    Author saveAuthor(final Author author);

    Author deleteAuthor(final String id);

    List<Author> getAll();

    Optional<Author> getById(String id);

    List<Author> saveAuthors(List<Author> authors);
}