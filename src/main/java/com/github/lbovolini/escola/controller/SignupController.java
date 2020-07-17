package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.exception.EmailAlreadyRegisteredException;
import com.github.lbovolini.escola.service.AlunoService;
import com.github.lbovolini.escola.service.CursoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/signup")
public class SignupController {

    private static final Logger LOGGER = Logger.getLogger(SignupController.class.getName());

    private CursoService cursoService;
    private AlunoService alunoService;

    public SignupController() {
        this.cursoService = new CursoService();
        this.alunoService = new AlunoService();
    }

    @GET
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCourses()
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
    @Path("/students")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveStudent(final AlunoDTO alunoDto) {
        try {
            alunoService.save(alunoDto);
            return Response.ok().build();
        } catch (EmailAlreadyRegisteredException eare) {
            LOGGER.log(Level.WARNING, eare.getMessage(), eare);
            return Response.serverError().entity(eare.getMessage()).build();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
