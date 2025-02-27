package com.ctw.workstation.rackasset.controller;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRepository;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetRequestDTO;
import com.ctw.workstation.rackasset.entity.RackAssetResponseDTO;
import com.ctw.workstation.rackasset.entity.RackAssetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RackAssetService {
    @Inject
    RackRepository rackRepository;
    @Inject
    RackAssetRepository rackAssetRepository;

    @Transactional
    public RackAssetResponseDTO createRackAsset(RackAssetRequestDTO request) {
        Rack rack = rackRepository.findById(request.getRackId());
        if (rack == null) {
            throw new IllegalArgumentException("Invalid Rack ID");
        }
        RackAsset rackAsset = new RackAsset(request.getAssetTag(), request.getRackId());
        rackAsset.setRack(rack);
        rackAssetRepository.persist(rackAsset);
        return new RackAssetResponseDTO(rackAsset);
    }
}
