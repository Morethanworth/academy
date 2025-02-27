package com.ctw.workstation.rackasset.entity;

public class RackAssetRequestDTO {
    private String assetTag;
    private Long rackId;

    public RackAssetRequestDTO(String assetTag, Long rackId) {
        this.assetTag = assetTag;
        this.rackId = rackId;
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

}
