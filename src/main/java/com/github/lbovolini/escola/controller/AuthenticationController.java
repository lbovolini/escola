package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.service.AuthenticationService;
import com.github.lbovolini.escola.util.StudentUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Inject
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @POST
    @Path("administrator/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response administratorLogin(Credentials credentials) {
        authenticationService.validateAdministrator(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        return Response.ok().header(HttpHeaders.AUTHORIZATION, token).entity(token).build();
    }

    @POST
    @Path("student/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response studentLogin(Credentials credentials) {
        StudentDTO studentDTO = authenticationService.validateStudent(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        UserDTO userDTO = StudentUtil.toUsuarioDTO(studentDTO, credentials.getRole(), token);
        return Response.ok().entity(userDTO).build();
    }

    @POST
    @Path("teacher/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response teacherLogin(Credentials credentials) {
        authenticationService.validateTeacher(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        return Response.ok().header(HttpHeaders.AUTHORIZATION, token).entity(token).build();
    }
}
