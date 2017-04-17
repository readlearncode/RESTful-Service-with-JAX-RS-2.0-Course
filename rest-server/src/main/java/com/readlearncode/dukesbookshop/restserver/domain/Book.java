package com.readlearncode.dukesbookshop.restserver.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (imageFileName != null ? !imageFileName.equals(book.imageFileName) : book.imageFileName != null)
            return false;
        if (link != null ? !link.equals(book.link) : book.link != null) return false;
        return published != null ? published.equals(book.published) : book.published == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (imageFileName != null ? imageFileName.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (published != null ? published.hashCode() : 0);
        return result;
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
}
