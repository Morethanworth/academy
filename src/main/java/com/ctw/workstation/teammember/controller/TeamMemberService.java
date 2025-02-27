package com.ctw.workstation.teammember.controller;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRepository;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberRepository;
import com.ctw.workstation.teammember.entity.TeamMemberRequestDTO;
import com.ctw.workstation.teammember.entity.TeamMemberResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import com.ctw.workstation.utils.EntityNotFoundException;

import java.util.List;

@ApplicationScoped
public class TeamMemberService {
    @Inject
    TeamMemberRepository teamMemberRepository;
    @Inject
    TeamRepository teamRepository;

    @Transactional
    public TeamMemberResponseDTO createTeamMember(TeamMemberRequestDTO request) throws EntityNotFoundException {
        Team team = teamRepository.findById(request.getTeamId());
        if (team == null) {
            throw new EntityNotFoundException("Team not found");
        }
        TeamMember teamMember = new TeamMember(request.getName(), request.getCtwId(), request.getTeamId());
        teamMember.setTeam(team);

        teamMemberRepository.persistAndFlush(teamMember);

        return new TeamMemberResponseDTO(teamMember);
    }

    public TeamMemberResponseDTO getTeamMemberById(Long id){
        TeamMember teamMember = teamMemberRepository.findById(id);
        return new TeamMemberResponseDTO(teamMember);
    }

    public TeamMemberResponseDTO updateTeamMember(Long id, TeamMemberRequestDTO request) {
        TeamMember teamMember = teamMemberRepository.findById(id);
        teamMember.setCtwId(request.getCtwId());
        teamMember.setName(request.getName());
        return new TeamMemberResponseDTO(teamMember);
    }

    public List<Booking> getBookingsFromTeamMember(Long id){
        TeamMember teamMember  = teamMemberRepository.findById(id);
        return teamMember.getBookings();
    }
}
