package com.readlearncode.dukesbookshop.restserver.infrastructure.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Provider
public class ISBNNotFoundManager implements ExceptionMapper<ISBNNotFoundException>{

    @Override
    public Response toResponse(ISBNNotFoundException exception) {
        return Response.status(NOT_FOUND).build();
    }
}