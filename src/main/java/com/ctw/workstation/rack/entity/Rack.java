package com.ctw.workstation.rack.entity;


import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.utils.RackStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "T_RACK")
public class Rack{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    private Long id;

    @Column(name = "serial_number", length = 20, nullable = false)
    private String serialNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Timestamp modified_at;

    @Column(name = "default_location",length = 10)
    private String defaultLocation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RackStatus status;

    @Column(name = "team_id", nullable = false)
    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false, nullable = false)
    private Team team;

    @OneToMany(mappedBy = "rackId", fetch = FetchType.LAZY)
    private List<RackAsset> rackAssets;

    @OneToMany(mappedBy = "rackId", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Rack(String serialNumber, String defaultLocation, RackStatus status, Long teamId) {
        this.serialNumber = serialNumber;
        this.defaultLocation = defaultLocation;
        this.status = status;
        this.teamId = teamId;
    }
    public Rack() {

    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public RackStatus getStatus() {
        return status;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Team getTeam() {
        return team;
    }

    public List<RackAsset> getRackAssets() {
        return rackAssets;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setStatus(RackStatus status) {
        this.status = status;
    }
}
