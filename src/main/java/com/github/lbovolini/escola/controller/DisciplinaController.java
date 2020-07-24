package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AulaDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.service.DisciplinaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/v1/disciplinas")
public class DisciplinaController {

    private static final Logger LOGGER = Logger.getLogger(DisciplinaController.class.getName());

    private DisciplinaService disciplinaService;

    public DisciplinaController() {
        this.disciplinaService = new DisciplinaService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            disciplinaService.delete(id);
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
            DisciplinaDTO disciplinaDTO = disciplinaService.find(id);
            return Response.ok().entity(disciplinaDTO).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}/aulas/{alunoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAulas(@PathParam("id") int disciplinaId, @PathParam("alunoId") int alunoId) {
        try {
            List<AulaDTO> aulaDTOList = disciplinaService.findAulas(disciplinaId, alunoId);
            return Response.ok().entity(aulaDTOList).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(DisciplinaDTO disciplinaDTO) {
        try {
            disciplinaService.save(disciplinaDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(DisciplinaDTO disciplinaDTO) {
        try {
            disciplinaService.update(disciplinaDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
