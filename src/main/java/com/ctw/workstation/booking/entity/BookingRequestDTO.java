package com.ctw.workstation.booking.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class BookingRequestDTO {
    private LocalDateTime bookFrom;
    private LocalDateTime bookTo;
    private Long rackId;
    private Long requesterId;

    public BookingRequestDTO(LocalDateTime bookFrom, LocalDateTime bookTo, Long rackId, Long requestId) {
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.rackId = rackId;
        this.requesterId = requestId;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public Long getRackId() {
        return rackId;
    }

    public Long getRequesterId() {
        return requesterId;
    }
}
