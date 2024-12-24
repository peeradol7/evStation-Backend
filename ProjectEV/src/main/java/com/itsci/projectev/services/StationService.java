package com.itsci.projectev.services;

import com.itsci.projectev.models.ChargingPointProvider;
import com.itsci.projectev.models.Station;
import com.itsci.projectev.models.StationType;

import java.util.List;
import java.util.Map;

public interface StationService {
    ChargingPointProvider getProviderByID(String chargingPointProviderID);

    StationType getStationTypeByID(String stationTypeID);

    List<Station> getAllStation();
    Station addStation(Map<String, String>map);
    Station getStationByName(String stationName);
    Station updateStation(Map<String, String> map);
    Station profileStation(Map<String, String> map);
    void deleteStation(String stationId);
}
