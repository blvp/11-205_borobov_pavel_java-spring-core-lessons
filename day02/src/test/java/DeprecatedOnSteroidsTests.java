import foo.bar.lab01.AwesomeNewStuff;
import foo.bar.lab01.DeprecatedOldShit;
import foo.bar.lab01.DeprecatedOnSteroids;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by blvp on 07.04.15.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class DeprecatedOnSteroidsTests {


    @Test
    public void testDeprecatedOnSteroid(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("deprecated-on-steroids.xml");
        for (String beanName : context.getBeanDefinitionNames()) {
            assertNull(context.getBean(beanName).getClass().getAnnotation(DeprecatedOnSteroids.class));
        }
    }
}
