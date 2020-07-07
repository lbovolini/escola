package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/v1/professores")
public class ProfessorController {

    private static final Logger LOGGER = Logger.getLogger(ProfessorController.class.getName());

    private ProfessorService professorService;

    public ProfessorController() {
        this.professorService = new ProfessorService();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            professorService.delete(id);
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
            ProfessorDTO professorDTO = professorService.find(id);
            return Response.ok().entity(professorDTO).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(ProfessorDTO professorDTO) {
        try {
            professorService.save(professorDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(ProfessorDTO professorDTO) {
        try {
            professorService.update(professorDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
