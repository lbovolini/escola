package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.exception.EmailAlreadyRegisteredException;
import com.github.lbovolini.escola.message.ErrorMessage;
import com.github.lbovolini.escola.service.AlunoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/v1/alunos")
public class AlunoController {

    private static final Logger LOGGER = Logger.getLogger(AlunoController.class.getName());

    private AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            alunoService.delete(id);
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
            AlunoDTO alunoDTO = alunoService.find(id);
            return Response.ok().entity(alunoDTO).build();
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
            List<DisciplinaDTO> disciplinaDTOList= alunoService.findDisciplinas(id);
            return Response.ok().entity(disciplinaDTOList).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
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
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final AlunoDTO alunoDto) {
        try {
            alunoService.save(alunoDto);
            return Response.ok().build();
        } catch (EmailAlreadyRegisteredException eare) {
            LOGGER.log(Level.WARNING, eare.getMessage(), eare);
            ErrorMessage errorMessage = new ErrorMessage(eare.getMessage());
            return Response.serverError().entity(errorMessage).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final AlunoDTO alunoDto) {
        try {
            alunoService.update(alunoDto);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
