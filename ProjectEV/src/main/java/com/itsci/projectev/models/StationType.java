package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stationtypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StationType {

    @Id
    @Column(length = 6)
    private int stationTypeID;

    @Column(length = 100, nullable = false)
    private String stationTypeName;
}
