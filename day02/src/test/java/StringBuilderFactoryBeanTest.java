import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by blvp on 07.04.15.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class StringBuilderFactoryBeanTest {

    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context02.xml");
        StringBuilder builder = context.getBean(StringBuilder.class);
        assertEquals("Start! Middle End.", builder.toString());
    }
}
