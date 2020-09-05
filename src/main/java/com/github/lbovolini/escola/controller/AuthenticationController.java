package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.dto.AdministratorDTO;
import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.service.AuthenticationService;
import com.github.lbovolini.escola.util.AdministratorUtil;
import com.github.lbovolini.escola.util.StudentUtil;
import com.github.lbovolini.escola.util.TeacherUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Inject
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @POST
    @Path("administrator/login")
    public Response administratorLogin(Credentials credentials) {
        AdministratorDTO administratorDTO = authenticationService.validateAdministrator(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        UserDTO userDTO = AdministratorUtil.toUserDTO(administratorDTO, credentials.getRole(), token);
        return Response.ok().entity(userDTO).build();
    }

    @POST
    @Path("student/login")
    public Response studentLogin(Credentials credentials) {
        StudentDTO studentDTO = authenticationService.validateStudent(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        UserDTO userDTO = StudentUtil.toUserDTO(studentDTO, credentials.getRole(), token);
        return Response.ok().entity(userDTO).build();
    }

    @POST
    @Path("teacher/login")
    public Response teacherLogin(Credentials credentials) {
        TeacherDTO teacherDTO = authenticationService.validateTeacher(credentials);
        String token = authenticationService.generateToken(credentials.getEmail(), credentials.getRole());
        UserDTO userDTO = TeacherUtil.toUserDTO(teacherDTO, credentials.getRole(), token);
        return Response.ok().entity(userDTO).build();
    }
}
