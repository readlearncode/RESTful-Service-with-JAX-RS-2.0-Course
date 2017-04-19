package com.readlearncode.dukesbookshop.restserver.domain;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.Objects;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class LinkResource {

    private String rel;
    private String type;
    private URI uri;

    public LinkResource(){}

    public LinkResource(Link link) {
        this.rel = link.getRel();
        this.type = link.getType();
        this.uri = link.getUri();
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkResource that = (LinkResource) o;
        return Objects.equals(rel, that.rel) &&
                Objects.equals(type, that.type) &&
                Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rel, type, uri);
    }

    @Override
    public String toString() {
        return "LinkResource{" +
                "rel='" + rel + '\'' +
                ", type='" + type + '\'' +
                ", uri=" + uri +
                '}';
    }
}
