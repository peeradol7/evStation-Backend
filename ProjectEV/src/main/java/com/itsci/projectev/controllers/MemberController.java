package com.itsci.projectev.controllers;

import com.itsci.projectev.models.Member;
import com.itsci.projectev.services.MemberService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity loginMember (@RequestBody Map<String,String> map) {
        try {
            Member member = memberService.doLoginMember(map);
            if (member != null) {
                return new ResponseEntity<>(member, HttpStatus.OK);
            } else {
                return new ResponseEntity("Username or password incorrect", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity("Login failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity getListMember(){
        try{
            List<Member> members = memberService.getAllMember();
            return new ResponseEntity(members, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addMember(@RequestBody Map<String,String> map) {
        try{
            Member member = memberService.addMember(map);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMemberByUsername/{memberUsername}")
    public ResponseEntity getMemberByUsername(@PathVariable("memberUsername") String memberUsername) throws IllegalAccessError{
        try{
            Member member = memberService.getMemberByUsername(memberUsername);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateMember(@RequestBody Map<String, String>map){
        try{
            Member member = memberService.updateMember(map);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/profileMemberID")
    public ResponseEntity getProfileMemberID(@RequestBody Map<String, String> map){
        try {
            Member member = memberService.profileMember(map);
            return new ResponseEntity(member, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{memberID}")
    public ResponseEntity dodeletePost(@PathVariable("memberID") String memberID){
        try{
            memberService.deleteMember(memberID);
            return new ResponseEntity<>("Member ID: " + memberID + "was deleted!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    @GetMapping("/getallmembers")
//    public ResponseEntity getAllMembers (){
//        List<Member> members = new ArrayList<>();
//        members.add(new Member("M001", "boo", "1234", "00000000000", "passakorn", "thamthong", "test.png", "M", new Date(2003,05,01), "0947314999", "boo@gmail.com"));
//        members.add(new Member("M002", "boo2", "1234", "00000000000", "passakornn", "thamthongg", "test.png", "M", new Date(2003,05,01), "0947314999", "booo@gmail.com"));
//        return new ResponseEntity(members, HttpStatus.OK);
//    }
//
//    @GetMapping("/getmemberid/{memberID}")
//    public ResponseEntity getMemberById (@PathVariable String memberID) {
//        List<Member> members = new ArrayList<>();
//        members.add(new Member("M001", "boo", "1234", "00000000000", "passakorn", "thamthong", "test.png", "M", new Date(2003,05,01), "0947314999", "boo@gmail.com"));
//        members.add(new Member("M002", "boo2", "1234", "00000000000", "passakornn", "thamthongg", "test.png", "M", new Date(2003,05,01), "0947314999", "booo@gmail.com"));
//
//        Member targerMember = null;
//        for (Member member : members) {
//            if (member.getMemberID().equals(memberID)) {
//                targerMember = member;
//                break;
//            }
//        }
//        return new ResponseEntity(targerMember, HttpStatus.OK);
//    }

//    @GetMapping("/members/getmemberid")
//    public ResponseEntity getMemberById (@RequestBody Map<String, String> json) {
//
//        return new ResponseEntity("Get by id : " + json.get("memberID"), HttpStatus.OK);
//    }
}
