package com.itsci.projectev.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsci.projectev.models.ChargingType;
import com.itsci.projectev.repositories.ChargingTypeRepository;

@Service
public class ChargingTypeServiceImpl implements ChargingTypeService {

    @Autowired
    private ChargingTypeRepository chargingTypeRepository;


    @Override
    public List<ChargingType> getAllChargingType() {
        return chargingTypeRepository.findAll();
    }

    @Override
    public ChargingType addChargingType(Map<String, String> map) {
        int typeid;
        try {
            typeid = Integer.parseInt(map.get("chargingTypeID"));
        }catch (NumberFormatException e){
            return null;
        }
        String typename = map.get("chargingTypeName");
        ChargingType chargingType = new ChargingType(typeid, typename);
        return chargingTypeRepository.save(chargingType);
    }


    @Override
    public ChargingType updateChargingType(Map<String, String> map) {
        int typeid;
        try {
            typeid = Integer.parseInt(map.get("chargingTypeID"));
        }catch (NumberFormatException e){
            return null;
        }
        String typename = map.get("chargingTypeName");
        ChargingType chargingType = new ChargingType(typeid, typename);
        return chargingTypeRepository.save(chargingType);
    }

    @Override
    public ChargingType getChargignTypeByName(String chargingTypeName) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void deleteChargingType(String chargingTypeID) {
        throw new UnsupportedOperationException("");
    }

}
