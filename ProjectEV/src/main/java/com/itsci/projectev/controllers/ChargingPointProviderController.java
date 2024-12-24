package com.itsci.projectev.controllers;

import com.itsci.projectev.models.ChargingPointProvider;
import com.itsci.projectev.services.ChargingPointProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/chargingpointproviders")
public class ChargingPointProviderController {
    @Autowired
    private ChargingPointProviderService chargingPointProviderService;

    @PostMapping("/login")
    public ResponseEntity loginprovider (@RequestBody Map<String, String>map){
        try {
            ChargingPointProvider chargingPointProvider = chargingPointProviderService.doLoginProvider(map);
            if (chargingPointProvider != null) {
                return new ResponseEntity<>(chargingPointProvider, HttpStatus.OK);
            } else {
                return new ResponseEntity("Username or password incorrect", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Login failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity getListProvider(){
        try{
            List<ChargingPointProvider> chargingPointProviders = chargingPointProviderService.getAllProvider();
            return new ResponseEntity(chargingPointProviders, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addProvider(@RequestBody Map<String,String> map){
        try{
            ChargingPointProvider chargingPointProvider = chargingPointProviderService.addProvider(map);
            return new ResponseEntity<>(chargingPointProvider, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/getProviderByUsername/{providerUsername}")
//    public ResponseEntity getProviderByUsername(@PathVariable("providerUsername") String providerUsername) throws  IllegalAccessError {
//        try{
//            ChargingPointProvider chargingPointProvider = chargingPointProviderService.getProviderByUsername(providerUsername);
//            return new ResponseEntity<>(chargingPointProvider, HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/getProviderByID/{chargingPointProviderID}")
    public ResponseEntity getProviderByID(@PathVariable("chargingPointProviderID") String chargingPointProviderID) throws  IllegalAccessError {
        try{
            ChargingPointProvider chargingPointProvider = chargingPointProviderService.getProviderByID(chargingPointProviderID);
            return new ResponseEntity<>(chargingPointProvider, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateProvider(@RequestBody Map<String, String>map){
        try{
            ChargingPointProvider chargingPointProvider = chargingPointProviderService.updateProvider(map);
            return new ResponseEntity<>(chargingPointProvider, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/profileProviderID")
    public ResponseEntity getProfileProviderID(@RequestBody Map<String, String> map) {
        try {
            ChargingPointProvider chargingPointProvider =chargingPointProviderService.profileProvider(map);
            return new ResponseEntity(chargingPointProvider, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{chargingPointProviderID}")
        public ResponseEntity dodeletePost(@PathVariable("chargingPointProviderID") String chargingPointProviderID){
            try{
                chargingPointProviderService.deleteProvider(chargingPointProviderID);
                return new ResponseEntity<>("Provider ID: " + chargingPointProviderID + "was deleted!",HttpStatus.OK);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

}
