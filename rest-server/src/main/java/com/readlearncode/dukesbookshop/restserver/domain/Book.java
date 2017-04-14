package com.readlearncode.dukesbookshop.restserver.domain;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Book extends Hypermedia implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String IMAGE_LOCATION = "/images/covers/";

    @Size(min = 10, max = 10, message = "ISBN should be 10 characters")
    private String id;

    @Size(min = 20)
    private String title;

    @Size(min = 100)
    private String description;

    @Size(min = 1)
    private ArrayList<Author> authors = new ArrayList<>(); // Must use concrete List implementation as JAX-RS doesn't play nice with interfaces.

    @DecimalMin("0.00")
    private Float price;

    @NotNull
    private String imageFileName;

    @NotNull
    @Pattern(regexp="^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$")
    private String link;

    @Past // Format 2018-08-25T00:00:00+01:00
    private Date published;

    public Book() {
        // Required for serialisation/deserialisation
    }

    public Book(String id, String title, String description, Float price, Date published, ArrayList<Author> authors, String imageFileName, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.published = published;
        this.authors = authors;
        this.imageFileName = imageFileName.length() == 0 ? IMAGE_LOCATION.concat("no_image.png") : imageFileName;
        this.link = link;
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

    public final Date getPublished() {
        return published;
    }

    public final void setPublished(final Date published) {
        this.published = published;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
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
