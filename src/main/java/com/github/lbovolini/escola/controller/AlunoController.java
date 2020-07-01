package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.service.AlunoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final AlunoDTO alunoDto) {
        try {
            alunoService.save(alunoDto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            alunoService.delete(id);
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
            AlunoDTO alunoDTO = alunoService.find(id);
            return Response.ok().entity(alunoDTO).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(final AlunoDTO alunoDto) {
        try {
            alunoService.update(alunoDto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
