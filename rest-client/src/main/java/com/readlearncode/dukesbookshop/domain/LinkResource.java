package com.readlearncode.dukesbookshop.domain;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class LinkResource {

    private String rel;
    private String type;
    private String uri;

    public LinkResource() {}

    public LinkResource(Link link) {
        rel = link.getRel();
        type = link.getType();
        uri = link.getUri().toString();
    }

    public LinkResource(String rel, String type, String uri) {
        this.rel = rel;
        this.type = type;
        this.uri = uri;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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