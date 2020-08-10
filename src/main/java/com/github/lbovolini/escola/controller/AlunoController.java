package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.AlunoProfileDTO;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        alunoService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        AlunoDTO alunoDTO = alunoService.find(id);
        return Response.ok().entity(alunoDTO).build();
    }

    @GET
    @Path("/{id}/disciplinas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDisciplinas(@PathParam("id") int id) {
        List<DisciplinaDTO> disciplinaDTOList= alunoService.findDisciplinas(id);
        return Response.ok().entity(disciplinaDTOList).build();
    }

    @GET
    @Path("/{id}/turmas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTurmas(@PathParam("id") int id) {
        List<TurmaDTO> turmaDTOList = alunoService.findTurmas(id);
        return Response.ok().entity(turmaDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final AlunoDTO alunoDto) {
        alunoService.save(alunoDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final AlunoDTO alunoDto) {
        alunoService.update(alunoDto);
        return Response.ok().build();
    }

    @PUT
    @Path("/profile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(AlunoProfileDTO alunoProfileDTO) {
        alunoService.updateProfile(alunoProfileDTO);
        return Response.ok().build();
    }
}
