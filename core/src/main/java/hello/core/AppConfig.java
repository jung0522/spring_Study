package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 의존성 주입해주는 나중에 스프링 부트 역할
@Configuration
public class AppConfig {

    // 인터페이스 메서드로 구체 클래스 생성자로 구현 객체 생성 메서드 호출, 팩토리 메서드 패턴
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository());
    }

    // 구현 객체 생성(반환) 메서드 생성
    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    private static DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
