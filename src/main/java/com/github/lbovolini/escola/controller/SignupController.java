package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.service.AlunoService;
import com.github.lbovolini.escola.service.CursoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/signup")
public class SignupController {

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
