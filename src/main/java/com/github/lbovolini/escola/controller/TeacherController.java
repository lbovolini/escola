package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/professores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherController {

    private final TeacherService teacherService;

    @Inject
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        teacherService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") int id) {
        TeacherDTO teacherDTO = teacherService.find(id);
        return Response.ok().entity(teacherDTO).build();
    }

    @POST
    public Response save(TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(TeacherDTO teacherDTO) {
        teacherService.update(teacherDTO);
        return Response.ok().build();
    }
}
