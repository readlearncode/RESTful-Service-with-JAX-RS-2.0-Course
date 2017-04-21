package com.readlearncode.dukesbookshop.restserver.infrastructure.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Provider
public class AuthorIDNotRecognisedExceptionManager implements ExceptionMapper<AuthorIDNotRecognisedException> {
    @Override
    public Response toResponse(AuthorIDNotRecognisedException exception) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
