package hello.HelloSpring;

import hello.HelloSpring.Service.MemberService;
import hello.HelloSpring.repository.memberRepository;
import hello.HelloSpring.repository.memoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberrepository());
    }

    @Bean
    public memberRepository memberrepository() {
        return new memoryMemberRepository();
    }
}
