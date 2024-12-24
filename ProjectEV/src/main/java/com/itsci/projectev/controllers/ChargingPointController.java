package com.itsci.projectev.controllers;

import com.itsci.projectev.models.ChargingPoint;
import com.itsci.projectev.services.ChargingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chargingpoints")
public class ChargingPointController {
    @Autowired
    private ChargingPointService chargingPointService;

    @PostMapping("/list")
    public ResponseEntity getListChargingPoint(){
        try{
            List<ChargingPoint> chargingPoints = chargingPointService.getAllChargingPoint();
            return new ResponseEntity(chargingPoints, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addChargignPoint(@RequestBody Map<String,String> map){
        try{
            ChargingPoint chargingPoint = chargingPointService.addChargingPoint(map);
            return new ResponseEntity<>(chargingPoint, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getChargingByName/{chargingPointName}")
    public ResponseEntity getChargingPointByName(@PathVariable("chargingPointName") String chargingPointName) throws IllegalAccessError{
        try {
            ChargingPoint chargingPoint = chargingPointService.getChargingPointByName(chargingPointName);
            return new ResponseEntity<>(chargingPoint, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateChargingPoint(@RequestBody Map<String, String>map){
        try{
            ChargingPoint chargingPoint = chargingPointService.updateChargingPoint(map);
            return new ResponseEntity<>(chargingPoint, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{chargingPointID}")
    public ResponseEntity dodeleteChargingPoint(@PathVariable("chargingPointID")String chargingPointID){
        try{
            chargingPointService.deleteChargingPoint(chargingPointID);
            return new ResponseEntity<>("ChargingPoint ID: " + chargingPointID + "was deleted!", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
