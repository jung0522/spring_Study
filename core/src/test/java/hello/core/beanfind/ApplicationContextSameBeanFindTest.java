package hello.core.beanfind;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextSameBeanFindTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    
}
