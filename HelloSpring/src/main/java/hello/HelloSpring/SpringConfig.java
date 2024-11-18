package hello.HelloSpring;

import hello.HelloSpring.Service.MemberService;
import hello.HelloSpring.aop.TimeTraceAop;
import hello.HelloSpring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final memberRepository memberrepository;

    public SpringConfig(memberRepository memberrepository) {
        this.memberrepository = memberrepository;
    }

    @Lazy // MemberService를 지연 초기화
    @Bean
    public MemberService memberService() {
        return new MemberService(memberrepository);
    }

    // 수동으로 등록
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}

/*    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

//    public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberrepository());
    }

    @Bean
    public memberRepository memberrepository() {
//      return new memoryMemberRepository();
//      return new JdbcMemberRepository(dataSource);
//      return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
*/
