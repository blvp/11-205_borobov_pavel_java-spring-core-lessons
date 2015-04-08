package foo.bar.day01.lab05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blvp on 06.04.15.
 */
public class ProxyTest {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Subject subject = context.getBean(Subject.class);
        subject.longMethod();
    }
}
