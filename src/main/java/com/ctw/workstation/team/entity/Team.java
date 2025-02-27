package com.ctw.workstation.team.entity;


import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Supplier;

@Entity
@Table(name = "T_TEAM")
public class Team extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdGenerator")
    @SequenceGenerator(name = "teamIdGenerator", sequenceName = "SEQ_TEAM_ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "product", nullable = false)
    private String product;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Timestamp modified_at;

    @Column(name = "default_location")
    private String defaultLocation;

    @OneToMany(mappedBy = "teamId", fetch = FetchType.LAZY)
    private List<TeamMember> teamMembers;

    @OneToMany(mappedBy = "teamId", fetch = FetchType.LAZY)
    private List<Rack> racks;

    public Team() {
    }

    public Team(String defaultLocation, String product, String name) {
        this.defaultLocation = defaultLocation;
        this.product = product;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
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

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }
}
