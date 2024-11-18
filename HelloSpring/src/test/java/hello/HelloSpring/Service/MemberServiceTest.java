package hello.HelloSpring.Service;

import hello.HelloSpring.domain.Member;
import hello.HelloSpring.repository.memberRepository;
import hello.HelloSpring.repository.memoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    memoryMemberRepository repository;

    @BeforeEach
    public void BeforeEach()
    {
        repository = new memoryMemberRepository();
        memberService = new MemberService(repository);
    }
    @AfterEach
    public void AfterEach() {
        repository.clearStore();
    }


    @Test
    void join() {
        //given : 테스트를 위해 준비를 하는 과정이다.
        // 테스트에 사용하는 변수, 입력 값 등을 정의하거나, Mock 객체를
        // 정의하는 구문
        Member member = new Member();
        member.setName("정준영");


        //when : 실제로 액션을 하는 테스트를 실행하는 과정
        Long saveId = memberService.join(member);

        //then : 마지막은 테스트를 검증하는 과정이다.
        // 예상한 값, 실제 실행을 통해서 나온 값을 검증한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void ValidateDuplicateMember()
    {
        //given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //given
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    //        try {
    //            memberService.join(member2);
    //            fail();
    //        }
    //        catch (Exception e) {
    //            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    //        }
        //when
    }



    @Test
    void findMember() {
    }

    @Test
    void findOne()
    {
    }
}