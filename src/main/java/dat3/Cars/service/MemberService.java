package dat3.Cars.service;

import dat3.Cars.dto.CarRequest;
import dat3.Cars.dto.MemberRequest;
import dat3.Cars.dto.MemberResponse;
import dat3.Cars.entity.Car;
import dat3.Cars.entity.Member;
import dat3.Cars.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {


    MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers() {
         List<Member> members = memberRepository.findAll();
         List<MemberResponse> response = members.stream().map(member -> new MemberResponse(member,false)).collect(Collectors.toList());
         return response;
    }

    public MemberResponse addMember(MemberRequest memberRequest){
        //Later you should add error checks --> Missing arguments, email taken etc.

        Member newMember = MemberRequest.getMemberEntity(memberRequest);
        newMember = memberRepository.save(newMember);

        return new MemberResponse(newMember, false);
    }

    public MemberResponse findMemberByUsername(@PathVariable String username) throws Exception {
        Member found = memberRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        return new MemberResponse(found,false);
    }

    public void editMember(MemberRequest body, String username){
        Member member = memberRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        member.setFirstName(body.getFirstName());
        member.setLastName(body.getLastName());
        member.setCity(body.getCity());
        member.setZip(body.getZip());
        member.setStreet(body.getStreet());
        member.setEmail(body.getEmail());
        member.setPassword(body.getPassword());
        memberRepository.save(member);
    }


    public void setRanking(String username, int value) {
        Member member = memberRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        member.setRanking(value);
        memberRepository.save(member);

    }

    public void deleteUser(String username){
        memberRepository.deleteById(username);
    }
}
