package com.itsci.projectev.services;

import com.itsci.projectev.models.ChargingPointProvider;
import com.itsci.projectev.repositories.ChargingPointProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class ChargingPointProviderServiceImpl implements ChargingPointProviderService{

    private final String Picture_Provider_FOLDER_PATH = "D:/img/picture_provider/";


    @Autowired
    private ChargingPointProviderRepository chargingPointProviderRepository;

    @Override
    public List<ChargingPointProvider> getAllProvider() { return chargingPointProviderRepository.findAll();
    }

    @Override
    public ChargingPointProvider doLoginProvider(Map<String, String> map) {
        ChargingPointProvider chargingPointProvider = chargingPointProviderRepository.findByProviderUsernameEquals(map.get("providerUsername"));
        if (chargingPointProvider == null) return null;
        if (!chargingPointProvider.getProviderPassword().equals(map.get("providerPassword"))) return null;
        return chargingPointProvider;
    }

    @Override
    public ChargingPointProvider addProvider(Map<String, String> map) {
        System.out.println("Add Provider worked!");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String username = map.get("providerUsername");
        String password = map.get("providerPassword");
        String idcard = map.get("providerIdCard");
        String name = map.get("providerFName");
        String sername = map.get("providerLName");
        String img = map.get("providerImg");
        String gender = map.get("providerGender");
        Date dateDOB;
        try{
            dateDOB = format.parse(map.get("providerDOB"));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        String tel = map.get("providerTel");
        String email = map.get("providerEmail");
        String type = map.get("providerType");
        String status = "รอการยืนยัน";
        String dateapp = "รอวันอนุมัติ";
        ChargingPointProvider chargingPointProvider = new ChargingPointProvider(username,password,idcard,name,sername,img,gender,dateDOB,tel,email,type,status,dateapp);
        return chargingPointProviderRepository.save(chargingPointProvider);
    }

    @Override
    public ChargingPointProvider getProviderByID(String chargingPointProviderID) {
        return chargingPointProviderRepository.getReferenceById(chargingPointProviderID);
    }

//    @Override
//    public ChargingPointProvider getProviderByID(int chargingPointProviderID) {
//        return chargingPointProviderRepository.getReferenceById(String.valueOf(chargingPointProviderID));
//    }

    @Override
    public ChargingPointProvider updateProvider(Map<String, String> map) {
        System.out.println("Update provider worked!");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

//        int providerID = Integer.parseInt(map.get("chargingPointProviderID"));
        String username = map.get("providerUsername");
        String password = map.get("providerPassword");
        String idcard = map.get("providerIdCard");
        String name = map.get("providerFName");
        String sername = map.get("providerLName");
        String img = map.get("providerImg");
        String gender = map.get("providerGender");

        Date dateDOB;
        try{
            dateDOB = format.parse(map.get("providerDOB"));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        String tel = map.get("providerTel");
        String email = map.get("providerEmail");
        String type = map.get("providerType");
        String status = map.get("providerStatus");
        String dateapp = map.get("approveDate");
        ChargingPointProvider chargingPointProvider = new ChargingPointProvider(username,password,idcard,name,sername,img,gender,dateDOB,tel,email,type,status,dateapp);
        return chargingPointProviderRepository.save(chargingPointProvider);
    }

    @Override
    public ChargingPointProvider profileProvider (Map<String, String>map){
        String providerUsername = map.get("chargingPointProviderID");
        ChargingPointProvider chargingPointProvider = chargingPointProviderRepository.getChargingPointProviderByProviderUsername(providerUsername);
        if (chargingPointProvider != null){
            return chargingPointProvider;
        } else {
            throw new EntityNotFoundException("Provider not found witd id " + providerUsername);
        }
    }

    @Override
    public void deleteProvider(String chargingPointProviderID) {
        ChargingPointProvider chargingPointProvider = chargingPointProviderRepository.getReferenceById(chargingPointProviderID);
        chargingPointProviderRepository.delete(chargingPointProvider);
    }

    public String uploadPictureProvider(MultipartFile file) throws IOException {
        System.out.println("FILE NAME IS : " + file.getOriginalFilename());
        String newFileName = System.currentTimeMillis() + ".png";
        file.transferTo(new File(Picture_Provider_FOLDER_PATH + newFileName));
        return Picture_Provider_FOLDER_PATH + newFileName;
    }
}
