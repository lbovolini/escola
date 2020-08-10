package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.service.GradeCurricularService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/gradescurriculares")
public class GradeCurricularController {

    private GradeCurricularService gradeCurricularService;

    public GradeCurricularController() {
        this.gradeCurricularService = new GradeCurricularService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        gradeCurricularService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        GradeCurricularDTO gradeCurricularDTO = gradeCurricularService.find(id);
        return Response.ok().entity(gradeCurricularDTO).build();
    }

    @GET
    @Path("/{id}/disciplinas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDisciplinas(@PathParam("id") int id) {
        List<DisciplinaDTO> disciplinaDTOList = gradeCurricularService.findDisciplinas(id);
        return Response.ok().entity(disciplinaDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(GradeCurricularDTO gradeCurricularDTO) {
        gradeCurricularService.save(gradeCurricularDTO);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(GradeCurricularDTO gradeCurricularDTO) {
        gradeCurricularService.update(gradeCurricularDTO);
        return Response.ok().build();
    }
}
