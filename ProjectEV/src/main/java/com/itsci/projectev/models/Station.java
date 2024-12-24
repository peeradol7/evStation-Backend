package com.itsci.projectev.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "stations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Station {

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 6)
    private String stationId;

    @Column(length = 100, nullable = false)
    private String stationName;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(nullable = false)
    private int chargingPointAmount;

    @Column(nullable = false)
    private String serviceStartTime;

    @Column(nullable = false)
    private String serviceEndTime;

    @Column(length = 255, nullable = false)
    private String latitude;

    @Column(length = 255, nullable = false)
    private String longtitude;

    @Column(length = 255, nullable = false)
    private String contactInfomation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providerUsername")
    private ChargingPointProvider chargingPointProvider;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationTypeID")
    private StationType stationType;

    public Station(String stationName, String address, int chargingPointAmount, String serviceStartTime, String serviceEndTime, String latitude, String longtitude, String contactInfomation, ChargingPointProvider chargingPointProvider, StationType stationType) {
        this.stationName = stationName;
        this.address = address;
        this.chargingPointAmount = chargingPointAmount;
        this.serviceStartTime = serviceStartTime;
        this.serviceEndTime = serviceEndTime;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.contactInfomation = contactInfomation;
        this.chargingPointProvider = chargingPointProvider;
        this.stationType = stationType;
    }
}
