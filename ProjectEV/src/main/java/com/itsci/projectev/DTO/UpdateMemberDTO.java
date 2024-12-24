package com.itsci.projectev.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberDTO {

    private int memberID;
    private String memberUsername;
    private String memberPassword;
    private String memberIdCard;
    private String memberFName;
    private String memberLName;
    private String memberImg;
    private String memberGender;
    private String memberDOB;
    private String memberTel;
    private String memberEmail;

}
