package foo.bar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by blvp on 08.04.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RmiProxyFactoryBeanTest {

    @Autowired
    private GreetService greetService;

    @Test
    public void testClientGreetServiceCreated(){
        Assert.assertEquals("Hello, World!", greetService.greet());
    }
}
