package hello.core.autowired;

import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    static class TestBean {
       //호출 안됨
        @Autowired(required = false)
        public void setBean1(Member member) {
            System.out.println(member);
        }

        //null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setNoBean2 = " + member);
        }

        //Optional.empty 호출
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setNoBean3 = " + member);
        }

    }

}
