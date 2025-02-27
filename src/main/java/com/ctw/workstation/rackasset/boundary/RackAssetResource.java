package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.controller.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAssetRequestDTO;
import com.ctw.workstation.rackasset.entity.RackAssetResponseDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rack-asset")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackAssetResource {
    @Inject
    RackAssetService rackAssetService;

    @POST
    public Response createRackAsset(RackAssetRequestDTO request) {
        try{
            return Response.status(Response.Status.CREATED).entity(rackAssetService.createRackAsset(request)).build();}
        catch(IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
