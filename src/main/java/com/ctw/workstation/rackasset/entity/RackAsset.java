package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;
import jakarta.ws.rs.DefaultValue;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackAssetIdGenerator")
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID")
    private Long id;

    @Column(name = "asset_tag", nullable = false, length = 10)
    private String assetTag;

    @Column(name = "rack_id", nullable = false)
    private Long rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    public RackAsset() {
    }

    public RackAsset(String assetTag, Long rackId) {
        this.assetTag = assetTag;
        this.rackId = rackId;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public Long getId() {
        return id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public Long getRackId() {
        return rackId;
    }

    public Rack getRack() {
        return rack;
    }
}
