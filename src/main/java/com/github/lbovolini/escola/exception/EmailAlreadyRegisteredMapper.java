package com.github.lbovolini.escola.exception;

import com.github.lbovolini.escola.message.FormErrorMessage;
import com.github.lbovolini.escola.message.InputError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

@Provider
public class EmailAlreadyRegisteredMapper implements ExceptionMapper<EmailAlreadyRegisteredException> {
    @Override
    public Response toResponse(EmailAlreadyRegisteredException e) {
        List<InputError> inputErrorList = new ArrayList<>();
        inputErrorList.add(new InputError("email", e.getMessage()));
        FormErrorMessage formErrorMessage = new FormErrorMessage(inputErrorList);
        return Response.status(Response.Status.CONFLICT).entity(formErrorMessage).build();
    }
}
