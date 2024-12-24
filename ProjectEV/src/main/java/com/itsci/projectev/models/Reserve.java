package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reserves")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 6)
    private int reserveId;

    @Column(nullable = false)
    private Date reserveDate;

    @Column(nullable = false)
    private Date reserveStartTime;

    @Column(nullable = false)
    private Date reserveEndTime;

    @Column(nullable = false)
    private int reserveAmount;

    @Column(nullable = false)
    private int reserveStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberID")
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chargingPointID")
    private ChargingPoint chargingPoint;
}
