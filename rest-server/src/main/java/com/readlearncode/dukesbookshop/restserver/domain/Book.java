package com.readlearncode.dukesbookshop.restserver.domain;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Book extends Hypermedia implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String IMAGE_LOCATION = "/images/covers/";

    @Size(min = 10, max = 10, message = "ISBN should be 10 characters")
    private String id;

    @Size(min = 5)
    private String title;

    @Size(min = 20)
    private String description;

    @Size(min = 1)
    private ArrayList<Author> authors = new ArrayList<>();

    @DecimalMin("0.00")
    private Float price;

    @NotNull
    private String imageFileName;

    @NotNull
    @Pattern(regexp="^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$")
    private String link;

    @Past
    private Date published;


    public Book() {
    }

    public Book(String id, String title, String description, ArrayList<Author> authors, Float price, String imageFileName, String link, Date published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.price = price;
        this.imageFileName = imageFileName.length() == 0 ? IMAGE_LOCATION.concat("no_image.png") : imageFileName;
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

    public void setAuthors(ArrayList<Author> authors) {
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

    public ArrayList<Author> getAuthors() {
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
