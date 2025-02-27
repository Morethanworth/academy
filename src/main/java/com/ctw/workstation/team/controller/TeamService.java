package com.ctw.workstation.team.controller;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRepository;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamService {
    @Inject
    TeamRepository teamRepository;

    @Transactional
    public TeamResponseDTO create(TeamRequestDTO request){
        Team newTeam = new Team(request.getDefault_location(),request.getProduct(), request.getName());
        teamRepository.persistAndFlush(newTeam);
        return new TeamResponseDTO(newTeam);
    }

    public TeamResponseDTO getTeamById(Long id){
        Team team = teamRepository.findById(id);
        if(team == null){
            throw new NotFoundException("Team not found");
        }
        return new TeamResponseDTO(team);
    }

    public List<TeamResponseDTO> getAllTeams(){
        return teamRepository.findAll().stream().map(TeamResponseDTO::new).collect(Collectors.toList());
    }
    @Transactional
    public void deleteTeamById(Long id){
        teamRepository.deleteById(id);
    }

    @Transactional
    public TeamResponseDTO updateTeam(Long id, TeamRequestDTO request){
        Team team = teamRepository.findById(id);
        team.setName(request.getName());
        team.setDefaultLocation(request.getDefault_location());
        team.setProduct(request.getProduct());
        return new TeamResponseDTO(team);
    }

    public List<TeamMemberResponseDTO> getTeamMembers(Long id){
        Team team = teamRepository.findById(id);
        return team.getTeamMembers().stream().map(TeamMemberResponseDTO::new).collect(Collectors.toList());
    }
}
