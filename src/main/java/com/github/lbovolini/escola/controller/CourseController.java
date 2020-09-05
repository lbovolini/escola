package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.service.CourseService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/courses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CourseController {

    private final CourseService courseService;

    @Inject
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        courseService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") int id) {
        CourseDTO courseDTO = courseService.find(id);
        return Response.ok().entity(courseDTO).build();
    }

    @GET
    public Response findAll()
    {
        List<CourseDTO> courseDTOList = courseService.findAll();
        return Response.ok().entity(courseDTOList).build();
    }

    @GET
    @Path("/curriculum/{id}")
    public Response findGrandesCurriculares(@PathParam("id") int id) {
        List<CurriculumDTO> curriculumDTOList = courseService.findGrandesCurriculares(id);
        return Response.ok().entity(curriculumDTOList).build();
    }

    @POST
    public Response save(final CourseDTO courseDto) {
        courseService.save(courseDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(final CourseDTO courseDto) {
        courseService.update(courseDto);
        return Response.ok().build();
    }
}
