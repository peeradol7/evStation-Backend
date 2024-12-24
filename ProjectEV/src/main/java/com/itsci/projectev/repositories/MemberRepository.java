package com.itsci.projectev.repositories;

import com.itsci.projectev.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {

    Member findByMemberUsernameEquals (String memberUsername);
    Member getMemberByMemberID (int memberID);

}
