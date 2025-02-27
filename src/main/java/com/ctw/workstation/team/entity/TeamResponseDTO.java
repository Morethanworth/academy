package com.ctw.workstation.team.entity;

import java.sql.Timestamp;

public class TeamResponseDTO {
    private Long id;
    private String name;
    private String product;
    private String default_location;
    private Timestamp created_at;
    private Timestamp modified_at;

    public TeamResponseDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.product = team.getProduct();
        this.default_location = team.getDefaultLocation();
        this.created_at = team.getCreated_at();
        this.modified_at = team.getModified_at();
    }
    public TeamResponseDTO(Long id, String name, String product, String default_location, Timestamp created_at, Timestamp modified_at) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.default_location = default_location;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public TeamResponseDTO() {
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

    public String getDefault_location() {
        return default_location;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }
}
