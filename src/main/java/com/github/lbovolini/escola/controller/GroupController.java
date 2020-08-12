package com.github.lbovolini.escola.controller;

import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.service.GroupService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/turmas")
public class GroupController {

    private final GroupService groupService;

    @Inject
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        groupService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        GroupDTO groupDTO = groupService.find(id);
        return Response.ok().entity(groupDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(GroupDTO groupDTO) {
        groupService.save(groupDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(GroupDTO groupDTO) {
        groupService.update(groupDTO);
        return Response.ok().build();
    }
}
