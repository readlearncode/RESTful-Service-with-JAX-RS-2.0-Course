package com.readlearncode.dukesbookshop.restserver.infrastructure.Exceptions;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
//    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(ConstraintViolationException exception) {

        final String message = exception.getConstraintViolations().stream()
                .map(cv -> extractPropertyName(cv.getPropertyPath().toString()) + " : " + cv.getMessage())
                .collect(Collectors.joining(", "));

//        final Map<String, String> errorResponse =
//                exception.getConstraintViolations().stream()
//                        .collect(Collectors.toMap(o -> o.getPropertyPath().toString(), o -> o.getMessage()));
//
//        return Response.status(Response.Status.BAD_REQUEST).entity(new DataIntegrityValidation(errorResponse)).build();

        return Response.status(Response.Status.BAD_REQUEST).header("X-Validation-Failure", message).build();
    }

    private String extractPropertyName(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }
}