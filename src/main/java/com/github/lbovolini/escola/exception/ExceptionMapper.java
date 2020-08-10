package com.github.lbovolini.escola.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {

    private static final Logger LOGGER = Logger.getLogger(ExceptionMapper.class.getName());

    @Override
    public Response toResponse(Exception e) {
        LOGGER.log(Level.WARNING, e.getMessage(), e);
        return Response.serverError().build();
    }
}
