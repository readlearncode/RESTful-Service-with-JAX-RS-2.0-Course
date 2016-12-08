package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookstore.domain.Book;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.ParseException;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Named("bookList")
@RequestScoped
public class BookBean {

    @Inject
    private BookService bookService;

    private List<Book> books;

    public List<Book> getBooks() throws ParseException {
        return bookService.getBooks();
    }


}
