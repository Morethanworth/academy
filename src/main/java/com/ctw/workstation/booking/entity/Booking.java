package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
@Table(name = "T_BOOKING")
public class Booking{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    private Long id;

    @Column(name = "book_from", nullable = false)
    private Timestamp bookFrom;

    @Column(name = "book_to", nullable = false)
    private Timestamp bookTo;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Timestamp modified_at;

    @Column(name = "rack_id", nullable = false)
    private Long rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    @Column(name = "requester_id", nullable = false)
    private Long requesterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", updatable = false, insertable = false, nullable = false)
    private TeamMember requester;

    public Booking(Timestamp bookTo, Timestamp bookFrom, Long requesterId, Long rackId) {
        this.bookTo = bookTo;
        this.bookFrom = bookFrom;
        this.requesterId = requesterId;
        this.rackId = rackId;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public Timestamp getBookFrom() {
        return bookFrom;
    }

    public Timestamp getBookTo() {
        return bookTo;
    }

    public Long getRackId() {
        return rackId;
    }

    public Long getRequesterId() {
        return requesterId;
    }
}
