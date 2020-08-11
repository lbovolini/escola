package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.service.TurmaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    @Inject
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        turmaService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        TurmaDTO turmaDTO = turmaService.find(id);
        return Response.ok().entity(turmaDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(TurmaDTO turmaDTO) {
        turmaService.save(turmaDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(TurmaDTO turmaDTO) {
        turmaService.update(turmaDTO);
        return Response.ok().build();
    }
}
