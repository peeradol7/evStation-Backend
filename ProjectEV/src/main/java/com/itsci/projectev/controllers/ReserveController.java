package com.itsci.projectev.controllers;

import com.itsci.projectev.models.Reserve;
import com.itsci.projectev.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reserves")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @PostMapping("/list")
    public ResponseEntity getListReserve(){
        try{
            List<Reserve> reserves = reserveService.getAllReserve();
            return new ResponseEntity(reserves, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addReserve(@RequestBody Map<String, String> map) {
        try{
            Reserve reserve = reserveService.addReserve(map);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getReserveById/{reserveId}")
    public ResponseEntity getReserveById(@PathVariable("reserveId") String reserveId) throws IllegalAccessError{
        try{
            Reserve reserve = reserveService.getReserveById(reserveId);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{reserveId}")
    public ResponseEntity dodelete(@PathVariable("reserveId") String reserveId){
        try{
            reserveService.deleteReserve(reserveId);
            return new ResponseEntity<>("Reserve ID :" + reserveId + "was delete!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
