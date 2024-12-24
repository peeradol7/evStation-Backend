package com.itsci.projectev.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsci.projectev.models.StationType;
import com.itsci.projectev.repositories.StationTypeRepository;

@Service
public class StationTypeServiceImpl implements StationTypeService{

    @Autowired
    private StationTypeRepository stationTypeRepository;

    @Override
    public List<StationType> getAllStationType() {
        return stationTypeRepository.findAll();
    }

    @Override
    public StationType addStationType(Map<String, String> map) {
        int typeid;
        try{
            typeid = Integer.parseInt(map.get("stationTypeID"));
        }catch (NumberFormatException e){
            return null;
        }
        String typename = map.get("stationTypeName");
        StationType stationType = new StationType(typeid, typename);
        return stationTypeRepository.save(stationType);
    }

    @Override
    public StationType getStationTypeByName(String stationTypeName) {
        return stationTypeRepository.getReferenceById(stationTypeName);
    }

    @Override
    public StationType updateStationType(Map<String, String> map) {
        int typeid;
        try{
            typeid = Integer.parseInt(map.get("stationTypeID"));
        }catch (NumberFormatException e){
            return null;
        }
        String typename = map.get("stationTypeName");
        StationType stationType = new StationType(typeid, typename);
        return stationTypeRepository.save(stationType);
    }

    @Override
    public void deleteStationType(String stationTypeID) {
        StationType stationType = stationTypeRepository.getReferenceById(stationTypeID);
        stationTypeRepository.delete(stationType);
    }
}
