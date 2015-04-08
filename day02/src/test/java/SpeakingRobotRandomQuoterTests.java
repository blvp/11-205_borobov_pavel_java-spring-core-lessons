import foo.bar.lab03.Robot;
import foo.bar.lab03.SpeakingRobot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by blvp on 07.04.15.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SpeakingRobotRandomQuoterTests {

    @Test
    public void testRandomQuotes(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context03.xml");
        Robot robot = context.getBean(SpeakingRobot.class);
        assertNotEquals(robot.speak(), robot.speak());

    }
}
