package com.ctw.workstation.rack.entity;

import com.ctw.workstation.utils.RackStatus;

public class RackRequestDTO {
    String serial_number;
    String defaultLocation;
    String status;
    Long teamID;

    public RackRequestDTO(String serial_number, String defaultLocation, String status, Long teamID) {
        this.serial_number = serial_number;
        this.defaultLocation = defaultLocation;
        this.status = status;
        this.teamID = teamID;
    }


    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public String getStatus() {
        return RackStatus.getByValue(status).getName();
    }

    public void setStatus(String status) {
        this.status = RackStatus.getByValue(status).getName();
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }
}
