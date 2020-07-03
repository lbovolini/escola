package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.service.DisciplinaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/disciplinas")
public class DisciplinaController {

    private DisciplinaService disciplinaService;

    public DisciplinaController() {
        this.disciplinaService = new DisciplinaService();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            disciplinaService.delete(id);
            return Response.ok().build();
        } catch (Exception e) {
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
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(DisciplinaDTO disciplinaDTO) {
        try {
            disciplinaService.save(disciplinaDTO);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(DisciplinaDTO disciplinaDTO) {
        try {
            disciplinaService.update(disciplinaDTO);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}