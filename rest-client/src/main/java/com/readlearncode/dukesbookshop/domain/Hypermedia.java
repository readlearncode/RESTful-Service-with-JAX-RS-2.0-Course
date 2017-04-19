package com.readlearncode.dukesbookshop.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public abstract class Hypermedia {

    private List<LinkResource> links = new ArrayList<>();

    public List<LinkResource> getLinks() {
        return links;
    }

    public void setLinks(List<LinkResource> links) {
        this.links = links;
    }

    public void addLink(LinkResource linkResource){
        links.add(linkResource);
    }
}
