package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.model.Curso;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final CursoDTO cursoDto) {
        try {
            cursoService.save(cursoDto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            cursoService.delete(id);
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
            Curso curso = cursoService.find(id);
            return Response.ok().entity(curso).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List findAll()
    {
        return cursoService.findAll();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(final CursoDTO cursoDto) {
        try {
            cursoService.update(cursoDto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
