package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.service.GradeCurricularService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/v1/gradescurriculares")
public class GradeCurricularController {

    private static final Logger LOGGER = Logger.getLogger(GradeCurricularController.class.getName());

    private GradeCurricularService gradeCurricularService;

    public GradeCurricularController() {
        this.gradeCurricularService = new GradeCurricularService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            gradeCurricularService.delete(id);
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
            GradeCurricularDTO gradeCurricularDTO = gradeCurricularService.find(id);
            return Response.ok().entity(gradeCurricularDTO).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}/disciplinas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDisciplinas(@PathParam("id") int id) {
        try {
            List<DisciplinaDTO> disciplinaDTOList = gradeCurricularService.findDisciplinas(id);
            return Response.ok().entity(disciplinaDTOList).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(GradeCurricularDTO gradeCurricularDTO) {
        try {
            gradeCurricularService.save(gradeCurricularDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(GradeCurricularDTO gradeCurricularDTO) {
        try {
            gradeCurricularService.update(gradeCurricularDTO);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
