package com.itsci.projectev.services;

import com.itsci.projectev.models.ChargingPointProvider;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ChargingPointProviderService {
    List<ChargingPointProvider> getAllProvider();
    ChargingPointProvider doLoginProvider(Map<String, String> map);
    ChargingPointProvider addProvider(Map<String, String> map);
//    ChargingPointProvider getProviderByUsername(String providerUsername);

    ChargingPointProvider getProviderByID(String chargingPointProviderID);

    ChargingPointProvider updateProvider(Map<String, String> map);
    ChargingPointProvider profileProvider(Map<String, String >map);

    String uploadPictureProvider(MultipartFile file) throws IOException;

    void deleteProvider(String chargingPointProviderID);
}
