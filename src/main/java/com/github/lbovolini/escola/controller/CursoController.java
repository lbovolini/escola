package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.service.CursoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/v1/cursos")
public class CursoController {

    private static final Logger LOGGER = Logger.getLogger(CursoController.class.getName());

    private CursoService cursoService;

    public CursoController() {
        this.cursoService = new CursoService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            cursoService.delete(id);
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
            CursoDTO cursoDTO = cursoService.find(id);
            return Response.ok().entity(cursoDTO).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll()
    {
        try {
            List<CursoDTO> cursoDTOList = cursoService.findAll();
            return Response.ok().entity(cursoDTOList).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final CursoDTO cursoDto) {
        try {
            cursoService.save(cursoDto);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final CursoDTO cursoDto) {
        try {
            cursoService.update(cursoDto);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
