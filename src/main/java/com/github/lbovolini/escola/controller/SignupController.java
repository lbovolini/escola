package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.service.AlunoService;
import com.github.lbovolini.escola.service.CursoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/signup")
public class SignupController {

    private final CursoService cursoService;
    private final AlunoService alunoService;

    @Inject
    public SignupController(CursoService cursoService, AlunoService alunoService) {
        this.cursoService = cursoService;
        this.alunoService = alunoService;
    }

    @GET
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCourses()
    {
        List<CursoDTO> cursoDTOList = cursoService.findAll();
        return Response.ok().entity(cursoDTOList).build();
    }

    @POST
    @Path("/students")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveStudent(final AlunoDTO alunoDto) {
        alunoService.save(alunoDto);
        return Response.ok().build();
    }
}
