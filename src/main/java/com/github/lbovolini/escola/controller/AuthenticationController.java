package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.UsuarioDTO;
import com.github.lbovolini.escola.service.AuthenticationService;
import com.github.lbovolini.escola.util.AlunoUtil;

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
        AlunoDTO alunoDTO = authenticationService.validateStudent(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        UsuarioDTO usuarioDTO = AlunoUtil.toUsuarioDTO(alunoDTO, credentials.getRole(), token);
        return Response.ok().entity(usuarioDTO).build();
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
