package hello.core.member;

import hello.core.AppConfig;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;



public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();
    ApplicationContext applicationContext;
    MemberService memberService;
//  1. AppConfig(의존성 주입해주는 관리자) 객체 생성
    @BeforeEach // @BeforeEach 실행 전에 먼저 실행
    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
        // @BeforeEach라서 memberService undefind 방지를 위해 MemberService memberService 따로
//        memberService = appConfig.memberService();
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
    }
    @Test
    void join () {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
