package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.service.TurmaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/v1/turmas")
public class TurmaController {

    private static final Logger LOGGER = Logger.getLogger(TurmaController.class.getName());

    private TurmaService turmaService;

    public TurmaController() {
        this.turmaService = new TurmaService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            turmaService.delete(id);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        try {
            TurmaDTO turmaDTO = turmaService.find(id);
            return Response.ok().entity(turmaDTO).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(TurmaDTO turmaDTO) {
        try {
            turmaService.save(turmaDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(TurmaDTO turmaDTO) {
        try {
            turmaService.update(turmaDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
