package com.github.lbovolini.escola.exception;

import com.github.lbovolini.escola.message.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidCredentialsMapper implements ExceptionMapper<InvalidCredentialsException> {
    @Override
    public Response toResponse(InvalidCredentialsException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
}
