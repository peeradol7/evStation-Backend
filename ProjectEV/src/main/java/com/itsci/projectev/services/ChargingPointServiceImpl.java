package com.itsci.projectev.services;

import com.itsci.projectev.models.ChargingPoint;
import com.itsci.projectev.models.ChargingType;
import com.itsci.projectev.models.Station;
import com.itsci.projectev.repositories.ChargingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChargingPointServiceImpl implements ChargingPointService{

    @Autowired
    private ChargingPointRepository chargingPointRepository;

    @Override
    public List<ChargingPoint> getAllChargingPoint() {
        return chargingPointRepository.findAll();
    }

    @Override
    public ChargingPoint addChargingPoint(Map<String, String> map) {
        int chargingpointid;
        String chargingpointname = map.get("chargingPointName");

        double fee;
        int status;
        int duration;

        try {
            chargingpointid = Integer.parseInt(map.get("chargingPointID"));
            fee = Double.parseDouble(map.get("serviceFee"));
            status = Integer.parseInt(map.get("chargingPointStatus"));
            duration = Integer.parseInt(map.get("reserveDuration"));
        } catch (NumberFormatException e) {
            return null;
        }

        Station station = chargingPointRepository.findById(map.get("stationId")).orElse(null).getStation();
        ChargingType chargingType = chargingPointRepository.findById(map.get("chargingTypeID")).orElse(null).getChargingType();

        if (station == null || chargingType == null) {
            return null;
        }

        ChargingPoint chargingPoint = new ChargingPoint(chargingpointid, chargingpointname, fee, status, duration, station, chargingType);
        return chargingPointRepository.save(chargingPoint);
    }

    @Override
    public ChargingPoint getChargingPointByName(String chargingPointName) {
        return chargingPointRepository.getReferenceById(chargingPointName);
    }

    @Override
    public ChargingPoint updateChargingPoint(Map<String, String> map) {
        int chargingpointid;
        String chargingpointname = map.get("chargingPointName");

        double fee;
        int status;
        int duration;

        try {
            chargingpointid = Integer.parseInt(map.get("chargingPointID"));
            fee = Double.parseDouble(map.get("serviceFee"));
            status = Integer.parseInt(map.get("chargingPointStatus"));
            duration = Integer.parseInt(map.get("reserveDuration"));
        } catch (NumberFormatException e) {
            return null;
        }

        Station station = chargingPointRepository.findById(map.get("stationId")).orElse(null).getStation();
        ChargingType chargingType = chargingPointRepository.findById(map.get("chargingTypeID")).orElse(null).getChargingType();

        if (station == null || chargingType == null) {
            return null;
        }

        ChargingPoint chargingPoint = new ChargingPoint(chargingpointid, chargingpointname, fee, status, duration, station, chargingType);
        return chargingPointRepository.save(chargingPoint);
    }

    @Override
    public void deleteChargingPoint(String chargingPointID) {
        ChargingPoint chargingPoint = chargingPointRepository.getReferenceById(chargingPointID);
        chargingPointRepository.delete(chargingPoint);
    }
}
