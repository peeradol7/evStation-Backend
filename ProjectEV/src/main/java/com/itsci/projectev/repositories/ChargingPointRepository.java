package com.itsci.projectev.repositories;

import com.itsci.projectev.models.ChargingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingPointRepository extends JpaRepository<ChargingPoint, String> {
}
