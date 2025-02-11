package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        // basePackages = {"hello.core", "hello.service"}
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 실습을 위해 AppConfig가 스프링 컨테이너에 등록이 안 되게
)
public class AutoAppConfig {

}
