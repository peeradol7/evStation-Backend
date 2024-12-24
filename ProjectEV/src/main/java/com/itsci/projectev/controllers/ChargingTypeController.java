package com.itsci.projectev.controllers;

import com.itsci.projectev.models.ChargingType;
import com.itsci.projectev.services.ChargingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chargingtypes")
public class ChargingTypeController {
    @Autowired
    private ChargingTypeService chargingTypeService;

    @PostMapping("/list")
    public ResponseEntity getListChargingType(){
        try{
            List<ChargingType> chargingTypes = chargingTypeService.getAllChargingType();
            return new ResponseEntity(chargingTypes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addChargingType(@RequestBody Map<String, String> map){
        try{
            ChargingType chargingType = chargingTypeService.addChargingType(map);
            return new ResponseEntity<>(chargingType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getChargingTypeByName/{chargingTypeName}")
    public ResponseEntity getChargingByName(@PathVariable("chargingTypeName") String chargingTypeName) throws IllegalAccessError{
        try {
            ChargingType chargingType = chargingTypeService.getChargignTypeByName(chargingTypeName);
            return new ResponseEntity<>(chargingType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateChargingType(@RequestBody Map<String, String>map){
        try{
            ChargingType chargingType = chargingTypeService.updateChargingType(map);
            return new ResponseEntity<>(chargingType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{chargingTypeID}")
    public ResponseEntity dodeleteChargingType(@PathVariable("chargingTypeID")String chargingTypeID){
        try{
            chargingTypeService.deleteChargingType(chargingTypeID);
            return new ResponseEntity<>("Charging Type ID: " + chargingTypeID + "was delete!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
