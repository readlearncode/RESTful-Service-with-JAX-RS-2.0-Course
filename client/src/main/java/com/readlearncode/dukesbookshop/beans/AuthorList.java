package com.readlearncode.dukesbookshop.beans;

import com.readlearncode.dukesbookshop.restclient.AuthorService;
import com.readlearncode.dukesbookshop.domain.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Named
@RequestScoped
public class AuthorList {

    @Inject
    private AuthorService authorService;

    private List<Author> authors;

    @PostConstruct
    public void initialize() {
        authors = authorService.getAuthors();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Map<String, String> getAuthorsAsMap() {
        return getAuthors()
                .stream()
                .collect(Collectors.toMap(o -> o.getId(), o -> o.getFirstName() + " " + o.getLastName()));
    }

}