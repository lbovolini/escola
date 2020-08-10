package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.service.CursoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/cursos")
public class CursoController {

    private CursoService cursoService;

    public CursoController() {
        this.cursoService = new CursoService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        cursoService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        CursoDTO cursoDTO = cursoService.find(id);
        return Response.ok().entity(cursoDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll()
    {
        List<CursoDTO> cursoDTOList = cursoService.findAll();
        return Response.ok().entity(cursoDTOList).build();
    }

    @GET
    @Path("/gradesCurriculares/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGrandesCurriculares(@PathParam("id") int id) {
        List<GradeCurricularDTO> gradeCurricularDTOList = cursoService.findGrandesCurriculares(id);
        return Response.ok().entity(gradeCurricularDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final CursoDTO cursoDto) {
        cursoService.save(cursoDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final CursoDTO cursoDto) {
        cursoService.update(cursoDto);
        return Response.ok().build();
    }
}
