package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.controller.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMemberRequestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.ctw.workstation.utils.EntityNotFoundException;

@Path("team-members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeammemberResource {
    @Inject
    TeamMemberService teamMemberService;

    @POST
    public Response createTeamMember(TeamMemberRequestDTO teamMember) {
        try{
            return Response.status(Response.Status.CREATED).entity(teamMemberService.createTeamMember(teamMember)).build();
        }catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getTeamMember(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(teamMemberService.getTeamMemberById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMember(@PathParam("id") Long id, TeamMemberRequestDTO teamMember) {
        return Response.status(Response.Status.OK).entity(teamMemberService.updateTeamMember(id, teamMember)).build();
    }

    @GET
    @Path("/{id}/bookings")
    public Response getBookings(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(teamMemberService.getBookingsFromTeamMember(id)).build();
    }

}
