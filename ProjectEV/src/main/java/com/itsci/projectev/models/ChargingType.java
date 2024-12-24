package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chargingtypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChargingType {

    @Id
    @Column(length = 6)
    private int chargingTypeID;

    @Column(length = 30, nullable = false)
    private String chargingTypeName;
}
