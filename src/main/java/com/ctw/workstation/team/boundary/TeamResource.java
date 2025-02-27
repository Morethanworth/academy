package com.ctw.workstation.team.boundary;


import com.ctw.workstation.team.controller.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logmanager.MDC;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {


    @Inject
    TeamService teamService;


    @POST
    public Response createTeam(TeamRequestDTO team) {
        Log.infof("Request for team with name: %s", team.getName());
        return Response.status(Response.Status.CREATED).entity(teamService.create(team)).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeam(@PathParam("id") Long id) {
        try{
            return Response.status(Response.Status.OK).entity(teamService.getTeamById(id)).build();
        }catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }

    }
    @GET
    public Response getTeams() {
        return Response.status(Response.Status.OK).entity(teamService.getAllTeams()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") Long id) {
        teamService.deleteTeamById(id);
        return Response.status(Response.Status.OK).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") Long id, TeamRequestDTO team) {
        return Response.status(Response.Status.OK).entity(teamService.updateTeam(id, team)).build();
    }

    @GET
    @Path("/{id}/team-members")
    public Response getTeamMembers(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(teamService.getTeamMembers(id)).build();
    }




}
