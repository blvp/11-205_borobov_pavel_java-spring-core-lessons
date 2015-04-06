package foo.bar.lab02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blvp on 06.04.15.
 */
public class QuoterTests {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Quoter shakespeareQuoter = context.getBean(Quoter.class);
        shakespeareQuoter.sayQuote();
        Quoter terminatorQuoter = (Quoter) context.getBean("terminatorQuoter");
        terminatorQuoter.sayQuote();
    }
}
