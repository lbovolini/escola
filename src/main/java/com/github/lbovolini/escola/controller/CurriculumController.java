package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.service.CurriculumService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/gradescurriculares")
public class CurriculumController {

    private final CurriculumService curriculumService;

    @Inject
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        curriculumService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        CurriculumDTO curriculumDTO = curriculumService.find(id);
        return Response.ok().entity(curriculumDTO).build();
    }

    @GET
    @Path("/{id}/disciplinas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDisciplinas(@PathParam("id") int id) {
        List<DisciplineDTO> disciplineDTOList = curriculumService.findDisciplinas(id);
        return Response.ok().entity(disciplineDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(CurriculumDTO curriculumDTO) {
        curriculumService.save(curriculumDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(CurriculumDTO curriculumDTO) {
        curriculumService.update(curriculumDTO);
        return Response.ok().build();
    }
}
