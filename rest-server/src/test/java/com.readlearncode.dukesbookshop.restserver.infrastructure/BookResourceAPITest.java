package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.RESTConfig;
import com.readlearncode.dukesbookshop.restserver.domain.Book;
import com.readlearncode.dukesbookshop.restserver.rest.BookResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@RunWith(Arquillian.class)
public class BookResourceAPITest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class)
                .addClass(RESTConfig.class)
                .addClass(BookResource.class)
                .addClass(BookRepositoryBean.class)
                .addClass(BookRepository.class)
                .addClass(Book.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
//    @RunAsClient
    public void authenticateUser(@ArquillianResteasyResource final WebTarget webTarget) {
        final Response response = webTarget
                .path("/books")
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertEquals(true, response.readEntity(List.class));
    }

}
