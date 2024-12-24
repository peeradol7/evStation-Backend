package com.itsci.projectev.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateChargingPointProviderDTO {

    private int chargingPointProviderID;
    private String providerUsername;
    private String providerPassword;
    private String providerIdCard;
    private String providerFName;
    private String providerLName;
    private String providerImg;
    private String providerGender;
    private String providerDOB;
    private String providerTel;
    private String providerEmail;
    private String providerType;
    private String providerStatus;
    private String approveDate;
}
