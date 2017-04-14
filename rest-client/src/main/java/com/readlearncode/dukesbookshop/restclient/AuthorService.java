package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookshop.domain.Author;

import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public interface AuthorService {

     List<Author> getAuthors();

     Author getAuthor(String id);

}
