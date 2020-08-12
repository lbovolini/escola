package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/alunos")
public class StudentController {

    private final StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        studentService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        StudentDTO studentDTO = studentService.find(id);
        return Response.ok().entity(studentDTO).build();
    }

    @GET
    @Path("/{id}/disciplinas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDisciplinas(@PathParam("id") int id) {
        List<DisciplineDTO> disciplineDTOList = studentService.findDisciplinas(id);
        return Response.ok().entity(disciplineDTOList).build();
    }

    @GET
    @Path("/{id}/turmas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTurmas(@PathParam("id") int id) {
        List<GroupDTO> groupDTOList = studentService.findTurmas(id);
        return Response.ok().entity(groupDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final StudentDTO studentDto) {
        studentService.save(studentDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final StudentDTO studentDto) {
        studentService.update(studentDto);
        return Response.ok().build();
    }

    @PUT
    @Path("/profile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(StudentProfileDTO studentProfileDTO) {
        studentService.updateProfile(studentProfileDTO);
        return Response.ok().build();
    }
}
