package com.itsci.projectev.services;

import com.itsci.projectev.models.StationType;

import java.util.List;
import java.util.Map;

public interface StationTypeService {
    List<StationType> getAllStationType();
    StationType addStationType(Map<String, String> map);
    StationType getStationTypeByName(String stationTypeName);
    StationType updateStationType(Map<String, String>map);
    void deleteStationType(String stationTypeID);
}
