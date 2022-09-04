package dat3.Cars.service;

import dat3.Cars.entity.Member;
import dat3.Cars.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberServiceMockWithH2Test {

    public  MemberService memberService;

    public  static MemberRepository memberRepository;

    @BeforeAll
    public static void setupData(@Autowired MemberRepository member_Repository){
        memberRepository = member_Repository;
        List<Member> members = List.of(
                new Member("m1", "pw", "m1@a.dk", "aa", "aaa", "aaaa", "aaaa", "1234"),
                new Member("m2", "pw", "mm@a.dk", "bb", "bbb", "bbbb", "bbbb", "1234")
        );
        memberRepository.saveAll(members);
    }

    @BeforeEach
    public void setMemberService(){
        memberService = new MemberService(memberRepository);
    }
}

