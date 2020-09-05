package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.service.StudentService;
import com.github.lbovolini.escola.service.CourseService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/signup")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SignupController {

    private final CourseService courseService;
    private final StudentService studentService;

    @Inject
    public SignupController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GET
    @Path("/courses")
    public Response findAllCourses()
    {
        List<CourseDTO> courseDTOList = courseService.findAll();
        return Response.ok().entity(courseDTOList).build();
    }

    @POST
    @Path("/students")
    public Response saveStudent(final StudentDTO studentDto) {
        studentService.save(studentDto);
        return Response.ok().build();
    }
}
