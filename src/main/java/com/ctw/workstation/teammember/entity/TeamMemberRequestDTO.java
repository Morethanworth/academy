package com.ctw.workstation.teammember.entity;

public class TeamMemberRequestDTO {
    private String name;
    private String ctwId;
    private Long teamId;

    public TeamMemberRequestDTO(String name, String ctwId, Long teamId) {
        this.name = name;
        this.ctwId = ctwId;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public String getCtwId() {
        return ctwId;
    }

    public Long getTeamId() {
        return teamId;
    }
}
