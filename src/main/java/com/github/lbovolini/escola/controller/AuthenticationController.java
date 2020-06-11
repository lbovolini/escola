package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.service.AuthenticationService;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController() {
        this.authenticationService = new AuthenticationService();
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials) {
        try {
            authenticationService.validate(credentials);
            String token = authenticationService.generateToken(credentials.getEmail());
            return Response.ok().header(HttpHeaders.AUTHORIZATION, token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
