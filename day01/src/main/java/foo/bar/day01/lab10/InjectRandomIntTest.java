package foo.bar.day01.lab10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blvp on 06.04.15.
 */
public class InjectRandomIntTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("random-inject-context.xml");
        SomeInjectedClass obj = context.getBean(SomeInjectedClass.class);
        System.out.println(obj.getValue());
    }
}
