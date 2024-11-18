package hello.HelloSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


// @Component로 등록하거나 @Bean으로 등록
@Component
@Aspect
public class TimeTraceAop {
//    @Around("execution(* hello.HelloSpring..*(..))) && !target(hello.HelloSpring.SpringConfig)" )

    @Around("execution(* hello.HelloSpring..*(..))")
    // 순환참조 문제 자기 자신 제외 (수동으로 @Bean 등록할 경우 @Around 어노테이션으로 지정된 AOP 대상이 SpringConfig의 빈 생성 메서드까지 포함)
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
