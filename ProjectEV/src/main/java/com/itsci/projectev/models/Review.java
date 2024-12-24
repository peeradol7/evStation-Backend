package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 6)
    private int reviewId;

    @Column
    private double score;

    @Column
    private String comment;

    @Column
    private Date reviewDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserveId")
    private Reserve reserve;
}
