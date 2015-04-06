package foo.bar.lab09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blvp on 06.04.15.
 */
public class DMPWTest {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dmpwtest.xml");
        DestroyableBean bean = context.getBean(DestroyableBean.class);
        context.destroy();
    }
}
