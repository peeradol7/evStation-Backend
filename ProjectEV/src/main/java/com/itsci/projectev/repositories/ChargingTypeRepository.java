package com.itsci.projectev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsci.projectev.models.ChargingType;

public interface ChargingTypeRepository extends JpaRepository<ChargingType, Integer> {
}
