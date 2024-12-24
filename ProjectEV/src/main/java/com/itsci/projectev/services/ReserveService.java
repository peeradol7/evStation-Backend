package com.itsci.projectev.services;

import com.itsci.projectev.models.Reserve;

import java.util.List;
import java.util.Map;

public interface ReserveService {
    List<Reserve> getAllReserve();

    Reserve addReserve(Map<String, String> map);

    Reserve getReserveById(String reserveId);

    void deleteReserve(String reserveId);
}