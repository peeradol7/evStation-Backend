package com.itsci.projectev.controllers;

import com.itsci.projectev.models.StationType;
import com.itsci.projectev.services.StationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stationtypes")
public class StationTypeController {
    @Autowired
    private StationTypeService stationTypeService;

    @PostMapping("/list")
    public ResponseEntity getListStationType(){
        try{
            List<StationType> stationTypes = stationTypeService.getAllStationType();
            return new ResponseEntity<>(stationTypes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addStationType(@RequestBody Map<String, String> map){
        try{
            StationType stationType = stationTypeService.addStationType(map);
            return new ResponseEntity<>(stationType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStationTypeByID/{stationTypeID}")
    public ResponseEntity getStationTypeByID(@PathVariable("stationTypeID") String stationTypeID) throws IllegalAccessError{
        try{
            StationType stationType = stationTypeService.getStationTypeByName(stationTypeID);
            return new ResponseEntity<>(stationType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStationTypeByName/{stationTypeName}")
    public ResponseEntity getStationTypeByName(@PathVariable("stationTypeName") String stationTypeName) throws IllegalAccessError{
        try{
            StationType stationType = stationTypeService.getStationTypeByName(stationTypeName);
            return new ResponseEntity<>(stationType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateStationType(@RequestBody Map<String, String> map){
        try{
            StationType stationType = stationTypeService.updateStationType(map);
            return new ResponseEntity(stationType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{stationTypeID}")
    public ResponseEntity dodelete(@PathVariable("stationTypeID") String stationTypeID){
        try{
            stationTypeService.deleteStationType(stationTypeID);
            return new ResponseEntity<>("Station Type ID : " + stationTypeID + "was deleted!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
