package foo.bar.lab07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blvp on 06.04.15.
 */
public class BenchmarkTest {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("benchmark-context.xml");
        SomeCoolClass someCoolClass = context.getBean(SomeCoolClass.class);
        someCoolClass.myMethod();
    }
}
