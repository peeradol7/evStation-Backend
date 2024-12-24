package com.itsci.projectev.services;

import com.itsci.projectev.models.ChargingPoint;
import com.itsci.projectev.models.Member;
import com.itsci.projectev.models.Reserve;
import com.itsci.projectev.repositories.ChargingPointRepository;
import com.itsci.projectev.repositories.MemberRepository;
import com.itsci.projectev.repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReserveServiceImpl implements  ReserveService{

    @Autowired
    private ReserveRepository reserveRepository;

    @Override
    public List<Reserve> getAllReserve() {
        return reserveRepository.findAll();
    }

    @Override
    public Reserve addReserve(Map<String, String> map) {
        int reserveid;
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date reservedate;
        try{
            reserveid = Integer.parseInt(map.get("reserveId"));
        }catch (NumberFormatException e){
            return null;
        }
        try{
            reservedate = dateTimeFormat.parse(map.get("reserveDate"));
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
        Date startTime;
        try{
            startTime = dateTimeFormat.parse(map.get("reserveStartTime"));
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Date endTime;
        try{
            endTime = dateTimeFormat.parse(map.get("reserveEndTime"));
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
        int amount;
        int status;
        try{
            amount = Integer.parseInt(map.get("reserveAmount"));
            status = Integer.parseInt(map.get("reserveStatus"));
        }catch (NumberFormatException e){
            return null;
        }

        Member member = reserveRepository.findById(map.get("memberID")).orElse(null).getMember();
        ChargingPoint chargingPoint = reserveRepository.findById(map.get("chargingPointID")).orElse(null).getChargingPoint();

        if (member == null || chargingPoint == null) {
            return null;
        }

        Reserve reserve = new Reserve(reserveid, reservedate, startTime, endTime, amount, status, member, chargingPoint);
        return reserveRepository.save(reserve);
    }

    @Override
    public Reserve getReserveById(String reserveId) {
        return reserveRepository.getReferenceById(reserveId);
    }

    @Override
    public void deleteReserve(String reserveId) {
        Reserve reserve = reserveRepository.getReferenceById(reserveId);
        reserveRepository.delete(reserve);
    }
}
