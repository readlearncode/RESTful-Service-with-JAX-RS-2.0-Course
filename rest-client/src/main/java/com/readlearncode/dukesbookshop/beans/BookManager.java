package com.readlearncode.dukesbookshop.beans;

import com.readlearncode.dukesbookshop.restclient.AuthorService;
import com.readlearncode.dukesbookshop.restclient.BookService;
import com.readlearncode.dukesbookshop.domain.Book;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Named
@ViewScoped
public class BookManager implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private BookService bookService;

    @Inject
    private AuthorService authorService;

    private String id;

    private Book book;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void onLoad() {
        book = bookService.getBook(id);
    }

    public String submit(Book book) {
        book = bookService.saveBook(book);
        return "book-details?id=" + book.getId();
    }

    public void delete(String id){
        System.out.println("delete id: " + id);
        bookService.deleteBook(id);
    }

}