package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.service.ProfessorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    @Inject
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        professorService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        ProfessorDTO professorDTO = professorService.find(id);
        return Response.ok().entity(professorDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(ProfessorDTO professorDTO) {
        professorService.save(professorDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(ProfessorDTO professorDTO) {
        professorService.update(professorDTO);
        return Response.ok().build();
    }
}
