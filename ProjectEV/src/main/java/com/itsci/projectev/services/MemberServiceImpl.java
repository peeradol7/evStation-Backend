package com.itsci.projectev.services;

import com.itsci.projectev.models.Member;
import com.itsci.projectev.repositories.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMember() { return memberRepository.findAll(); }

    @Override
    public Member doLoginMember(Map<String, String> map) {
        Member member = memberRepository.findByMemberUsernameEquals(map.get("memberUsername"));
        if (member == null) return null;
        if (!member.getMemberPassword().equals(map.get("memberPassword"))) return null;
        return member;
    }

    @Override
    public Member addMember(Map<String, String> map) {
        System.out.println("Add member worked!");
        String username = map.get("memberUsername");
        String password = map.get("memberPassword");
        String idcard = map.get("memberIdCard");
        String name = map.get("memberFName");
        String sername = map.get("memberLName");
        String img = map.get("memberImg");
        String gender = map.get("memberGender");
        String dateDOB = map.get("memberDOB");
        String tel = map.get("memberTel");
        String email = map.get("memberEmail");
        Member member = new Member(username,password,idcard,name,sername,img,gender,dateDOB,tel,email);
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberByUsername(String memberUsername) {
        return memberRepository.getReferenceById(memberUsername);
    }

    @Override
    public Member updateMember(Map<String, String> map) {
        System.out.println("Update member worked!");
        int memberID = Integer.parseInt(map.get("memberID"));
        String username = map.get("memberUsername");
        String password = map.get("memberPassword");
        String idcard = map.get("memberIdCard");
        String name = map.get("memberFName");
        String sername = map.get("memberLName");
        String img = map.get("memberImg");
        String gender = map.get("memberGender");
        String dateDOB = map.get("memberDOB");
        String tel = map.get("memberTel");
        String email = map.get("memberEmail");
        Member member = new Member(memberID,username,password,idcard,name,sername,img,gender,dateDOB,tel,email);
        return memberRepository.save(member);
    }

    @Override
    public Member profileMember (Map<String, String>map) throws Exception{
        int memberID = Integer.parseInt(map.get("memberID"));
        Member member = memberRepository.getMemberByMemberID(memberID);
        if (member != null){
            return member;
        } else {
            throw new EntityNotFoundException("Member not found with id" +  memberID);
        }
    }

    @Override
    public void deleteMember(String memberID) {
        Member member = memberRepository.getReferenceById(memberID);
        memberRepository.delete(member);
    }

}
