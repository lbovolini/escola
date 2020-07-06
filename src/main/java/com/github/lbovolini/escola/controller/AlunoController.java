package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.service.AlunoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService();
    }

    @DELETE
    @Path("/{id}")
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

    @GET
    @Path("/{id}/disciplinas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDisciplinas(@PathParam("id") int id) {
        try {
            List<DisciplinaDTO> disciplinaDTOList= alunoService.findDisciplinas(id);
            return Response.ok().entity(disciplinaDTOList).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}/turmas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTurmas(@PathParam("id") int id) {
        try {
            List<TurmaDTO> turmaDTOList = alunoService.findTurmas(id);
            return Response.ok().entity(turmaDTOList).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final AlunoDTO alunoDto) {
        try {
            alunoService.save(alunoDto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
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
