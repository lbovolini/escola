package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.service.DisciplineService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/disciplinas")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Inject
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        disciplineService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        DisciplineDTO disciplineDTO = disciplineService.find(id);
        return Response.ok().entity(disciplineDTO).build();
    }

    @GET
    @Path("/{id}/aulas/{alunoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAulas(@PathParam("id") int disciplinaId, @PathParam("alunoId") int alunoId) {
        List<ClassDTO> classDTOList = disciplineService.findAulas(disciplinaId, alunoId);
        return Response.ok().entity(classDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(DisciplineDTO disciplineDTO) {
        disciplineService.save(disciplineDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(DisciplineDTO disciplineDTO) {
        disciplineService.update(disciplineDTO);
        return Response.ok().build();
    }
}
