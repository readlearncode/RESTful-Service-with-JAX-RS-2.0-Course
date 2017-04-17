package com.readlearncode.dukesbookshop.restserver.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Book implements Serializable {

    private String id;
    private String title;
    private String description;
    private List<Author> authors;
    private Float price;
    private String imageFileName;
    private String link;
    private Date published;

    public Book(){}

    public Book(String id, String title, String description, List<Author> authors, Float price, String imageFileName, String link, Date published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.price = price;
        this.imageFileName = imageFileName;
        this.link = link;
        this.published = published;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Float getPrice() {
        return price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public String getLink() {
        return link;
    }

    public Date getPublished() {
        return published;
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
                ", published=" + published +
                '}';
    }
}
