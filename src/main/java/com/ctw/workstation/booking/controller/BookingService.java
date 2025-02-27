package com.ctw.workstation.booking.controller;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingRepository;
import com.ctw.workstation.booking.entity.BookingRequestDTO;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRepository;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.sql.Timestamp;
import java.util.List;

@ApplicationScoped
public class BookingService {
    @Inject
    BookingRepository bookingRepository;

    @Inject
    RackRepository rackRepository;

    @Inject
    TeamMemberRepository teamMemberRepository;


    @Transactional
    public Booking createBooking(BookingRequestDTO request) throws IllegalArgumentException {
        Rack rack = rackRepository.findById(request.getRackId());
        TeamMember teamMember = teamMemberRepository.findById(request.getRequesterId());
        if (rack == null || teamMember == null) {
            throw new IllegalArgumentException("Rack or teamMember not found");
        }
        //business logic here
        Booking booking = new Booking(Timestamp.valueOf(request.getBookTo()),Timestamp.valueOf(request.getBookFrom()),request.getRequesterId(), request.getRackId());
        bookingRepository.persist(booking);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.listAll();
    }

}
