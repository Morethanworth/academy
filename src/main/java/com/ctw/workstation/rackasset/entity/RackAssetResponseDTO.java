package com.ctw.workstation.rackasset.entity;

public class RackAssetResponseDTO {
    private String assetTag;
    private Long rackId;
    private Long id;

    public RackAssetResponseDTO(RackAsset rackAsset) {
        this.assetTag = rackAsset.getAssetTag();
        this.rackId = rackAsset.getRackId();
        this.id = rackAsset.getId();
    }

    public String getAssetTag() {
        return assetTag;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public Long getId() {
        return id;
    }
}
