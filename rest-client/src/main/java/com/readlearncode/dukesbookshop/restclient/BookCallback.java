package com.readlearncode.dukesbookshop.restclient;

import com.readlearncode.dukesbookshop.domain.Book;

import javax.ws.rs.client.InvocationCallback;
import java.util.ArrayList;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookCallback implements InvocationCallback<ArrayList<Book>> {

    @Override
    public void completed(ArrayList<Book> books) {

    }

    @Override
    public void failed(Throwable throwable) {

    }
}