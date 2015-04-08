import foo.bar.lab04.Quoter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Created by blvp on 07.04.15.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AnnotationComponentTests {
    
    @Test
    public void testComponentCreated(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("foo.bar.lab04");
        Map<String, Quoter> bean = context.getBeansOfType(Quoter.class);
        Assert.assertEquals("I'll be back!",bean.get("terminatorQuoter").sayQuote());
        Assert.assertEquals("2b|!2b",bean.get("sheakspereQuoter").sayQuote());
    }
}
