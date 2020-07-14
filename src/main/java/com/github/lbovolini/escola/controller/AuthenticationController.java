package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.auth.Role;
import com.github.lbovolini.escola.service.AuthenticationService;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/")
public class AuthenticationController {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class.getName());

    private AuthenticationService authenticationService;

    public AuthenticationController() {
        this.authenticationService = new AuthenticationService();
    }

    @POST
    @Path("student/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response studentLogin(Credentials credentials) {
        try {
            authenticationService.validateStudent(credentials);
            String token = authenticationService.generateToken(credentials.getEmail(), Role.student());
            return Response.ok().header(HttpHeaders.AUTHORIZATION, token).entity(token).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
