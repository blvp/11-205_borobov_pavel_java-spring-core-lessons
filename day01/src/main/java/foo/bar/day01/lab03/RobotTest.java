package foo.bar.day01.lab03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blvp on 06.04.15.
 */
public class RobotTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Robot robot = context.getBean(Robot.class);
//        robot.talk();
    }
}
