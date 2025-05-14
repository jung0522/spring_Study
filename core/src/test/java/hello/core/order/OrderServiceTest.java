package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

//    MemberService memberService;
//    OrderService orderService;


    ApplicationContext applicationContext;
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void setUp()
    {
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
//        orderService = appConfig.orderService();

        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = (MemberService) applicationContext.getBean("memberService");
        orderService = (OrderService) applicationContext.getBean("orderService");

    }

    @Test
    void createOrder() {

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }



}
