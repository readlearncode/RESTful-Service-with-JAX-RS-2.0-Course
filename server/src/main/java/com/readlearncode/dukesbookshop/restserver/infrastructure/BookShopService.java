package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.domain.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class BookShopService {

    @EJB
    private AuthorRepository authorRepository;

    @EJB
    private BookRepository bookRepository;


    public List<Author> findAllAuthorsOfBookWithISBN(String isbn) {

        Optional<Book> book = bookRepository.getByISBN(isbn);

        if (book.isPresent()) {
            return book.get().getAuthors();
        }

        return Collections.emptyList();
    }


}