package com.readlearncode.dukesbookshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Book extends Hypermedia implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String description;
    private List<Author> authors = Collections.emptyList();
    private Float price;
    private String imageFileName;
    private String link;
    private String published;

    public Book(){}

    public Book(String id, String title, String description, Float price, String published, List<Author> authors, String imageFileName, String link, List<LinkResource> links) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.published = published;
        this.authors = authors;
        this.imageFileName = imageFileName;
        this.link = link;
        this.setLinks(links);
    }

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public final Float getPrice() {
        return price;
    }

    public final void setPrice(final Float price) {
        this.price = price;
    }

    public final String getPublished() {
        return published;
    }

    public final void setPublished(final String published) {
        this.published = published;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(price, book.price) &&
                Objects.equals(imageFileName, book.imageFileName) &&
                Objects.equals(link, book.link) &&
                Objects.equals(published, book.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, authors, price, imageFileName, link, published);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authors=" + authors +
                ", price=" + price +
                ", imageFileName='" + imageFileName + '\'' +
                ", link='" + link + '\'' +
                ", published='" + published + '\'' +
                '}';
    }
}
