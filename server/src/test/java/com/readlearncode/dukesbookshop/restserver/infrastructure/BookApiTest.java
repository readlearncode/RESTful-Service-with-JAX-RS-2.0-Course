package com.readlearncode.dukesbookshop.restserver.infrastructure;

//import com.readlearncode.dukesbookshop.restserver.domain.Book;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.container.test.api.RunAsClient;
//import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.arquillian.test.api.ArquillianResource;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.util.Calendar;
//

import com.readlearncode.dukesbookshop.RESTConfig;
import com.readlearncode.dukesbookshop.restserver.domain.Book;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;


/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@RunWith(Arquillian.class)
public class BookApiTest {

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "rest-server.war")
                .addClass(Book.class)
                .addClass(BookBean.class)
                .addClass(BookRepository.class)
                .addClass(BookStoreService.class)
                .addClass(RESTConfig.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Test
    @RunAsClient
    public void addBook(@ArquillianResteasyResource("api") final WebTarget webTarget) {
        final Response response = webTarget
                .path("/books")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(new Book("1234567890", "Java 101", BigDecimal.TEN, Calendar.getInstance().getTime())));
        assertEquals(true, response.readEntity(Boolean.class));
    }
}
