package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

       MemberService memberService = ac.getBean(MemberService.class);
       // ac.getBean("memberServiec", MemberService.class); -> 이름 따로 설정 안 해줘서 모흔다.
       assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
