package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamResponseDTO;

import java.sql.Timestamp;

public class TeamMemberResponseDTO {
    private Long id;
    private String name;
    private String ctwId;
    private Timestamp created_at;
    private Timestamp modified_at;
    private TeamResponseDTO team;

    public TeamMemberResponseDTO(TeamMember teamMember) {
        this.id = teamMember.getId();
        this.name = teamMember.getName();
        this.ctwId = teamMember.getCtwId();
        this.created_at = teamMember.getCreated_at();
        this.modified_at = teamMember.getModified_at();
        this.team = new TeamResponseDTO(teamMember.getTeam());
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCtwId() {
        return ctwId;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public TeamResponseDTO getTeam() {
        return team;
    }
}
