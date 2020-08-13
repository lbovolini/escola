package com.github.lbovolini.escola.exception;

import com.github.lbovolini.escola.message.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmailAlreadyRegisteredMapper implements ExceptionMapper<EmailAlreadyRegisteredException> {
    @Override
    public Response toResponse(EmailAlreadyRegisteredException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return Response.status(Response.Status.CONFLICT).entity(errorMessage).build();
    }
}
