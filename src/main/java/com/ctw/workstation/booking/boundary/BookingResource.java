package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.controller.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingRequestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/bookings")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {
    @Inject
    BookingService bookingService;

    @POST
    public Response createBooking(BookingRequestDTO request) {
        try{
            return Response.status(Response.Status.CREATED).entity(bookingService.createBooking(request)).build();
        }catch (IllegalArgumentException e){
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response getAllBookings() {
        return Response.status(Response.Status.OK).entity(bookingService.getAllBookings()).build();
    }
}
