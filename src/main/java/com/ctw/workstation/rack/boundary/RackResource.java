package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.controller.RackService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.rack.entity.RackRequestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("racks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackResource {
    @Inject
    RackService rackService;

    @POST
    public Response createRack(RackRequestDTO rack) {
        try{
            System.out.println(rack.toString());
            return Response.status(Response.Status.CREATED).entity(rackService.createRack(rack)).build();}

        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response getAllRacks() {
        return Response.status(Response.Status.OK).entity(rackService.getAllRacks()).build();
    }

    @GET
    @Path("/{id}/rack-assets")
    public Response getRackAssets(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(rackService.getRackAssets(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") Long id) {
        rackService.deleteRack(id);
        return Response.status(Response.Status.OK).build();
    }

}
