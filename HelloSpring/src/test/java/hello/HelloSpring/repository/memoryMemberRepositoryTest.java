// 테스트 주도 개발(Test-Driven Development, TDD)은
// 소프트웨어 개발 프로세스에서 테스트를 먼저 작성하고,
// 그 테스트를 통과하는 코드를 나중에 작성하는 방법론
package hello.HelloSpring.repository;

import hello.HelloSpring.domain.Member;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class memoryMemberRepositoryTest {

     memoryMemberRepository repository =  new memoryMemberRepository();

     @AfterEach
     public void AfterEach() {
         repository.clearStore();
     }
     @Test
    public void save() {
         Member member = new Member();
         member.setName("test");
         repository.save(member);
         Member result = repository.findById(member.getId()).get();
         assertThat(member).isEqualTo(result);
     }

     @Test
    public void findById() {

         Member member1 = new Member();

         member1.setName("Jung1");
         repository.save(member1);

         Member member2 = new Member();
         member2.setName("Jung2");
         repository.save(member2);

         Member result = repository.findByName("Jung1").get();
         assertThat(result).isEqualTo(member1);
     }

     @Test
    public void findAll() {
         Member member1 = new Member();
         member1.setName("Jung1");
         repository.save(member1);

         Member member2 = new Member();
         member2.setName("Jung2");
         repository.save(member2);

         List<Member> result = repository.findAll();
         assertThat(result.size()).isEqualTo(2);

     }

}

