package com.itsci.projectev.controllers;


import com.itsci.projectev.models.Station;
import com.itsci.projectev.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping("/list")
    public ResponseEntity getListStation(){
        try{
            List<Station> stations = stationService.getAllStation();
            return new ResponseEntity<>(stations, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addStation(@RequestBody Map<String, String> map) {
        try {
            Station station = stationService.addStation(map);
            return new ResponseEntity(station, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStationByName/{stationName}")
    public ResponseEntity getStationByName(@PathVariable("stationName") String stationName) throws IllegalAccessError{
        try{
            Station station = stationService.getStationByName(stationName);
            return new ResponseEntity<>(station, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateStation(@RequestBody Map<String, String> map){
        try{
            Station station = stationService.updateStation(map);
            return new ResponseEntity(station, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/profileStationID")
    public ResponseEntity getProfileStationID(@RequestBody Map<String, String> map) {
        try {
            Station station = stationService.profileStation(map);
            return new ResponseEntity<>(station, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{stationId}")
    public ResponseEntity dodelete(@PathVariable("stationId") String stationId){
        try{
            stationService.deleteStation(stationId);
            return new ResponseEntity<>("Station ID: " + stationId + "was delete!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
