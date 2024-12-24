package com.itsci.projectev.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsci.projectev.models.ChargingPointProvider;
import com.itsci.projectev.models.Station;
import com.itsci.projectev.models.StationType;
import com.itsci.projectev.repositories.ChargingPointProviderRepository;
import com.itsci.projectev.repositories.StationRepository;
import com.itsci.projectev.repositories.StationTypeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private ChargingPointProviderRepository chargingPointProviderRepository;

    @Autowired
    private StationTypeRepository stationTypeRepository;

//    @Override
//    public ChargingPointProvider getProviderByUsername(String providerUsername) {
//        return chargingPointProviderRepository.getReferenceById(providerUsername);
//    }

    @Override
    public ChargingPointProvider getProviderByID(String chargingPointProviderID) {
        return chargingPointProviderRepository.getReferenceById(chargingPointProviderID);
    }

    @Override
    public StationType getStationTypeByID(String stationTypeID) {
        return  stationTypeRepository.getReferenceById(stationTypeID);
    }

    @Override
    public List<Station> getAllStation() {
        return stationRepository.findAll();
    }

    @Override
    public Station addStation(Map<String, String> map) {
        String stationname = map.get("stationName");
        String address = map.get("address");
        int chargingpointamount = Integer.parseInt(map.get("chargingPointAmount"));
        String servicestart = map.get("serviceStartTime");
        String serviceend = map.get("serviceEndTime");
        String latitude = map.get("latitude");
        String longtitude = map.get("longtitude");
        String infomation = map.get("contactInfomation");

        String chargingPointProviderID = map.get("chargingPointProvider");
        String stationTypeID = map.get("stationType");

        ChargingPointProvider chargingPointProvider = getProviderByID(chargingPointProviderID);
        StationType stationType = getStationTypeByID(stationTypeID);

        if (chargingPointProvider == null || stationType == null) {
            return null;
        }

        Station station = new Station(stationname, address, chargingpointamount, servicestart, serviceend, latitude, longtitude, infomation, chargingPointProvider, stationType);
        return stationRepository.save(station);
    }

    @Override
    public Station getStationByName(String stationName) {
        return stationRepository.getReferenceById(stationName);
    }

    @Override
    public Station updateStation(Map<String, String> map) {
        String stationid = map.get("stationId");
        String stationname = map.get("stationName");
        String address = map.get("address");
        int chargingpointamount = Integer.parseInt(map.get("chargingPointAmount"));
        String servicestart = map.get("serviceStartTime");
        String serviceend = map.get("serviceEndTime");
        String latitude = map.get("latitude");
        String longtitude = map.get("longtitude");
        String infomation = map.get("contactInfomation");

        String chargingPointProviderID = map.get("chargingPointProvider");
        String stationTypeID = map.get("stationType");

        ChargingPointProvider chargingPointProvider = getProviderByID(chargingPointProviderID);
        StationType stationType = getStationTypeByID(stationTypeID);

        if (chargingPointProvider == null || stationType == null) {
            return null;
        }

        Station station = new Station(stationid, stationname, address, chargingpointamount, servicestart, serviceend, latitude, longtitude, infomation, chargingPointProvider, stationType);
        return stationRepository.save(station);
    }

    @Override
    public Station profileStation(Map<String, String> map) {
        String stationId = map.get("stationId");
        Station station = stationRepository.getStationByStationId(stationId);
        if (station != null) {
            return station;
        } else {
            throw new EntityNotFoundException("Station not found with id " + stationId);
        }
    }

    @Override
    public void deleteStation(String stationId) {
        Station station = stationRepository.getReferenceById(stationId);
        stationRepository.delete(station);
    }
}
