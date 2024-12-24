package com.itsci.projectev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 6)
    private int memberID;

    @Column(name = "memberUsername", length = 15, nullable = false)
    private String memberUsername;

    @Column(length = 16, nullable = false)
    private String memberPassword;

    @Column(length = 13, nullable = false)
    private String memberIdCard;

    @Column(length = 40, nullable = false)
    private String memberFName;

    @Column(length = 40, nullable = false)
    private String memberLName;

    @Column
    private String memberImg;

    @Column(length = 10, nullable = false)
    private String memberGender;

    @Column(nullable = false)
    private String memberDOB;

    @Column(length = 15, nullable = false)
    private String memberTel;

    @Column(length = 100, nullable = false)
    private String memberEmail;

    public Member(String memberUsername, String memberPassword, String memberIdCard, String memberFName, String memberLName, String memberImg, String memberGender, String memberDOB, String memberTel, String memberEmail) {
        this.memberUsername = memberUsername;
        this.memberPassword = memberPassword;
        this.memberIdCard = memberIdCard;
        this.memberFName = memberFName;
        this.memberLName = memberLName;
        this.memberImg = memberImg;
        this.memberGender = memberGender;
        this.memberDOB = memberDOB;
        this.memberTel = memberTel;
        this.memberEmail = memberEmail;
    }
}
