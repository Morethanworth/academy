package com.ctw.workstation.rack.controller;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.rack.entity.RackRepository;
import com.ctw.workstation.rack.entity.RackRequestDTO;
import com.ctw.workstation.rackasset.entity.RackAssetResponseDTO;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRepository;
import com.ctw.workstation.utils.RackStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackService {
    @Inject
    RackRepository rackRepository;

    @Inject
    TeamRepository teamRepository;

    @Transactional
    public RackDTO createRack(RackRequestDTO request) throws IllegalArgumentException {
        Team team = teamRepository.findById(request.getTeamID());
        if (team == null) {
            throw new IllegalArgumentException("Invalid team ID");
        }
        Rack rack = new Rack(request.getSerial_number(),request.getDefaultLocation(), RackStatus.getByValue(request.getStatus()), request.getTeamID());
        rack.setTeam(team);
        rackRepository.persist(rack);
        return new RackDTO(rack.getId(),rack.getSerialNumber(),rack.getDefaultLocation(),request.getStatus(),request.getTeamID());
    }

    public List<RackAssetResponseDTO> getRackAssets(Long id){
        Rack rack = rackRepository.findById(id);
        return rack.getRackAssets().stream().map(RackAssetResponseDTO::new).collect(Collectors.toList());
    }

    public List<RackDTO> getAllRacks(){
        return rackRepository.findAll().stream()
                .map(rack -> new RackDTO(rack.getId(), rack.getSerialNumber(),
                        rack.getDefaultLocation(),rack.getStatus().getName(),rack.getTeamId())).collect(Collectors.toList());
    }
    @Transactional
    public void deleteRack(Long id){
        Rack rack = rackRepository.findById(id);
        rackRepository.delete(rack);

    }
}
