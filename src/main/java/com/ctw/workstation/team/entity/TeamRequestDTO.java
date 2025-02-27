package com.ctw.workstation.team.entity;

public class TeamRequestDTO {
    private String name;
    private String product;
    private String default_location;

    public TeamRequestDTO(String name, String product, String default_location) {
        this.name = name;
        this.product = product;
        this.default_location = default_location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDefault_location() {
        return default_location;
    }

    public void setDefault_location(String default_location) {
        this.default_location = default_location;
    }
}
