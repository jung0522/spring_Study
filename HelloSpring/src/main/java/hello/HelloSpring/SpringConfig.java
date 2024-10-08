package hello.HelloSpring;

import hello.HelloSpring.Service.MemberService;
import hello.HelloSpring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private final DataSource dataSource;
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
