package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "chargingpointproviders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChargingPointProvider {

//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(length = 6)
//    private int chargingPointProviderID;
    @Id
    @Column(length = 15, nullable = false)
    private String providerUsername;

    @Column(length = 16, nullable = false)
    private String providerPassword;

    @Column(nullable = false, unique = true)
    private String providerIdCard;

    @Column(length = 40, nullable = false)
    private String providerFName;

    @Column(length = 40, nullable = false)
    private String providerLName;

    @Column
    private String providerImg;

    @Column(nullable = false)
    private String providerGender;

    @Column(nullable = false)
    private Date providerDOB;

    @Column(nullable = false)
    private String providerTel;

    @Column(length = 100, nullable = false)
    private String providerEmail;

    @Column(length = 50, nullable = false)
    private String providerType;

    @Column(nullable = false)
    private String providerStatus;

    @Column(nullable = false)
    private String approveDate;

    public ChargingPointProvider(String providerPassword, String providerIdCard, String providerFName, String providerLName, String providerImg, String providerGender, Date providerDOB, String providerTel, String providerEmail, String providerType, String providerStatus, String approveDate) {
        this.providerPassword = providerPassword;
        this.providerIdCard = providerIdCard;
        this.providerFName = providerFName;
        this.providerLName = providerLName;
        this.providerImg = providerImg;
        this.providerGender = providerGender;
        this.providerDOB = providerDOB;
        this.providerTel = providerTel;
        this.providerEmail = providerEmail;
        this.providerType = providerType;
        this.providerStatus = providerStatus;
        this.approveDate = approveDate;
    }
}
