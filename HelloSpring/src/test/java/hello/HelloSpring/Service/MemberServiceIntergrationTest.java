package hello.HelloSpring.Service;

import hello.HelloSpring.domain.Member;
import hello.HelloSpring.repository.memberRepository;
import hello.HelloSpring.repository.memoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


// @Transactional은 스프링 프레임워크에서 사용되는 어노테이션으로,
// 데이터베이스 트랜잭션 관리를 쉽게 할 수 있게 해줍니다.
// 이 어노테이션을 사용하면 메소드나 클래스의 데이터베이스 작업이
// 트랜잭션 내에서 실행되며, 작업 중 오류가 발생하면 자동으로 롤백됩니다.

// 롤백(Rollback)은 데이터베이스 트랜잭션에서 작업 중 오류가 발생했을 때,
// 이전 상태로 되돌리는 과정을 의미
@SpringBootTest
@Transactional
class MemberServiceIntergrationTest {

    @Autowired MemberService memberService;
    @Autowired memberRepository memberrepository;




@Test
//    @Commit db 저장 하려면
void join() {
        //given : 테스트를 위해 준비를 하는 과정이다.
        // 테스트에 사용하는 변수, 입력 값 등을 정의하거나, Mock 객체를
        // 정의하는 구문
        Member member = new Member();
        member.setName("정준영1");


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

}