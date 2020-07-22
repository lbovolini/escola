package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.UsuarioDTO;
import com.github.lbovolini.escola.message.ErrorMessage;
import com.github.lbovolini.escola.exception.InvalidCredentialsException;
import com.github.lbovolini.escola.service.AuthenticationService;
import com.github.lbovolini.escola.util.AlunoUtil;

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
    @Path("administrator/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response administratorLogin(Credentials credentials) {
        try {
            authenticationService.validateAdministrator(credentials);
            String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
            return Response.ok().header(HttpHeaders.AUTHORIZATION, token).entity(token).build();
        } catch (InvalidCredentialsException ice) {
            ErrorMessage errorMessage = new ErrorMessage(ice.getMessage());
            return Response.serverError().entity(errorMessage).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("student/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response studentLogin(Credentials credentials) {
        try {
            AlunoDTO alunoDTO = authenticationService.validateStudent(credentials);
            String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
            UsuarioDTO usuarioDTO = AlunoUtil.toUsuarioDTO(alunoDTO, credentials.getRole(), token);
            return Response.ok().entity(usuarioDTO).build();
        } catch (InvalidCredentialsException ice) {
            ErrorMessage errorMessage = new ErrorMessage(ice.getMessage());
            return Response.serverError().entity(errorMessage).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("teacher/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response teacherLogin(Credentials credentials) {
        try {
            authenticationService.validateTeacher(credentials);
            String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
            return Response.ok().header(HttpHeaders.AUTHORIZATION, token).entity(token).build();
        } catch (InvalidCredentialsException ice) {
            ErrorMessage errorMessage = new ErrorMessage(ice.getMessage());
            return Response.serverError().entity(errorMessage).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
