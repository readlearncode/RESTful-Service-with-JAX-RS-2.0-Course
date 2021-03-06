package com.readlearncode.dukesbookshop.restserver.infrastructure;


import com.readlearncode.dukesbookshop.restserver.domain.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class BookRepositoryBean implements BookRepository {

    @EJB
    private AuthorRepository authorRepository;

    private static final String IMAGE_LOCATION = "/images/covers/";

    private final Map<String, Book> books = new HashMap<>();

    @Override
    public Book saveBook(final Book book) {

        System.out.println("book: " + book);

        if (book.getImageFileName().length() == 0) {
            book.setImageFileName(IMAGE_LOCATION.concat("no_image.png"));
        }
        authorRepository.saveAuthors(book.getAuthors());
        books.put(book.getId(), book);
        // TODO: check if author already exists and if not, create him/her
        return book;
    }

    @Override
    public Optional<Book> deleteBook(final String id) {
        return Optional.of(books.remove(id));
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Optional<Book> getByISBN(final String id) {
        return Optional.ofNullable(books.get(id));
    }
}
