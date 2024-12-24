package com.itsci.projectev.services;

import com.itsci.projectev.models.Member;

import java.util.List;
import java.util.Map;

public interface MemberService {
    List<Member> getAllMember();
    Member doLoginMember(Map<String, String> map);
    Member addMember(Map<String, String> map);
    Member getMemberByUsername(String memberUsername);
    Member updateMember(Map<String, String> map);
    Member profileMember(Map<String, String> map) throws Exception;
    void deleteMember(String memberID);
}
