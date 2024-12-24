package com.itsci.projectev.services;

import java.util.List;
import java.util.Map;

import com.itsci.projectev.models.ChargingType;

public interface ChargingTypeService {
    List<ChargingType> getAllChargingType();
    ChargingType addChargingType(Map<String, String>map);
    ChargingType getChargignTypeByName(String chargingTypeName);
    ChargingType updateChargingType(Map<String, String>map);
    void deleteChargingType(String chargingTypeID);
}
