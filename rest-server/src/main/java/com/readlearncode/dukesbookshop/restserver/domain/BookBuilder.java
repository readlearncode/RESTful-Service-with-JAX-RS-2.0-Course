package com.readlearncode.dukesbookshop.restserver.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookBuilder {
    private String id;
    private String title;
    private String description;
    private Float price;
    private Date published;
    private ArrayList<Author> authors = new ArrayList<>();
    private String imageFileName;
    private String link;

    public BookBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BookBuilder setPrice(Float price) {
        this.price = price;
        return this;
    }

    public BookBuilder setPublished(Date published) {
        this.published = published;
        return this;
    }

    public BookBuilder setAuthors(ArrayList<Author> authors) {
        this.authors.addAll(authors);
        return this;
    }

    public BookBuilder addAuthor(Author author) {
        this.authors.add(author);
        return this;
    }

    public BookBuilder setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
        return this;
    }

    public BookBuilder setLink(String link) {
        this.link = link;
        return this;
    }

    public Book createBook() {
        return new Book(id, title, description, authors, price, imageFileName, link, published);
    }
}
