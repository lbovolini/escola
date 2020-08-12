package com.github.lbovolini.escola.exception;

import com.github.lbovolini.escola.message.FormErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidFormExceptionMapper implements ExceptionMapper<InvalidFormException> {
    @Override
    public Response toResponse(InvalidFormException e) {
        FormErrorMessage formErrorMessage = new FormErrorMessage(e.getErrors());
        return Response.status(Response.Status.BAD_REQUEST).entity(formErrorMessage).build();
    }
}
