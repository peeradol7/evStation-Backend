package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chargingpoints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChargingPoint {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 6)
    private int chargingPointID;

    @Column(length = 100, nullable = false)
    private String chargingPointName;

    @Column(nullable = false)
    private double serviceFee;

    @Column(nullable = false)
    private int chargingPointStatus;

    @Column(nullable = false)
    private int reserveDuration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId")
    private Station station;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chargingTypeID")
    private ChargingType chargingType;
}
