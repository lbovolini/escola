package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.service.DisciplineService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/disciplines")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Inject
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        disciplineService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") int id) {
        DisciplineDTO disciplineDTO = disciplineService.find(id);
        return Response.ok().entity(disciplineDTO).build();
    }

    @GET
    @Path("/{id}/classes/{studentId}")
    public Response findClasses(@PathParam("id") int disciplinaId, @PathParam("studentId") int alunoId) {
        List<ClassDTO> classDTOList = disciplineService.findClasses(disciplinaId, alunoId);
        return Response.ok().entity(classDTOList).build();
    }

    @POST
    public Response save(DisciplineDTO disciplineDTO) {
        disciplineService.save(disciplineDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(DisciplineDTO disciplineDTO) {
        disciplineService.update(disciplineDTO);
        return Response.ok().build();
    }
}
