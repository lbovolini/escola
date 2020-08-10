package com.github.lbovolini.escola.exception;

import com.github.lbovolini.escola.message.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidPasswordMapper implements ExceptionMapper<InvalidPasswordException> {
    @Override
    public Response toResponse(InvalidPasswordException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return Response.serverError().entity(errorMessage).build();
    }
}
