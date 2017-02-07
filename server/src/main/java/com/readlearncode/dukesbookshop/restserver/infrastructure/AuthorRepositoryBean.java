package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Author;

import javax.ejb.Stateless;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class AuthorRepositoryBean implements AuthorRepository {

    private final Map<String, Author> authors = new HashMap<>();

    @Override
    public Author saveAuthor(Author author) {
        authors.put(author.getId(), author);
        return author;
    }

    @Override
    public Author deleteAuthor(String id) {
        return authors.remove(id);
    }

    @Override
    public List<Author> getAll() {
        return authors.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Author> getById(String id) {
        System.out.println("authors: " + authors);

        return Optional.ofNullable(authors.get(id));
    }

}