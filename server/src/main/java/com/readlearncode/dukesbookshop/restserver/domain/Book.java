package com.readlearncode.dukesbookshop.restserver.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 10, max = 10)
    private String id;

    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    private BigDecimal price;

    @Past
    private Date published;

    public Book(String id, String title, BigDecimal price, Date published) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.published = published;
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

    public final BigDecimal getPrice() {
        return price;
    }

    public final void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public final Date getPublished() {
        return published;
    }

    public final void setPublished(final Date published) {
        this.published = published;
    }

}
