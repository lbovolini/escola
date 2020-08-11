package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AulaDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.service.DisciplinaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @Inject
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        disciplinaService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        DisciplinaDTO disciplinaDTO = disciplinaService.find(id);
        return Response.ok().entity(disciplinaDTO).build();
    }

    @GET
    @Path("/{id}/aulas/{alunoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAulas(@PathParam("id") int disciplinaId, @PathParam("alunoId") int alunoId) {
        List<AulaDTO> aulaDTOList = disciplinaService.findAulas(disciplinaId, alunoId);
        return Response.ok().entity(aulaDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(DisciplinaDTO disciplinaDTO) {
        disciplinaService.save(disciplinaDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(DisciplinaDTO disciplinaDTO) {
        disciplinaService.update(disciplinaDTO);
        return Response.ok().build();
    }
}
