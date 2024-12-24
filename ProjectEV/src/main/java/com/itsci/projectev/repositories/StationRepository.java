package com.itsci.projectev.repositories;

import com.itsci.projectev.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, String> {
    Station getStationByStationId (String stationId);
}
