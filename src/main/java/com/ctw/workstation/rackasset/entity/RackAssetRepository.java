package com.ctw.workstation.rackasset.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RackAssetRepository implements PanacheRepository<RackAsset> {
}
