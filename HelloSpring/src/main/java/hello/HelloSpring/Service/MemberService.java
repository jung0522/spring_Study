package hello.HelloSpring.Service;

import hello.HelloSpring.domain.Member;
import hello.HelloSpring.repository.memberRepository;
import hello.HelloSpring.repository.memoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final memberRepository memberrepository;

    public MemberService(memberRepository memberrepository) {
        this.memberrepository = memberrepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 이미 회원이 존재하는 경우


        ValidateDuplicateMember(member);
        memberrepository.save(member);
        return member.getId();
    }

    private void ValidateDuplicateMember(Member member) {
        // findByName의 반환 값이 optional이니까 isPresent메서드 바로 사용해 코드 간결화
        // 단축키: crtl + alt + m == extract method
        memberrepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMember() {
        return memberrepository.findAll();
    }

    /**
     * 전체 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
       return memberrepository.findById(memberId);
    }
}
