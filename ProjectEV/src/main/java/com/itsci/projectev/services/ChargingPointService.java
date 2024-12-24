package com.itsci.projectev.services;

import com.itsci.projectev.models.ChargingPoint;

import java.util.List;
import java.util.Map;

public interface ChargingPointService {
    List<ChargingPoint> getAllChargingPoint();
    ChargingPoint addChargingPoint(Map<String, String> map);
    ChargingPoint getChargingPointByName(String chargingPointName);
    ChargingPoint updateChargingPoint(Map<String, String> map);
    void deleteChargingPoint(String chargingPointID);
}
