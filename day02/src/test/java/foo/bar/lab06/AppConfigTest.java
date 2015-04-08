package foo.bar.lab06;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@RunWith(BlockJUnit4ClassRunner.class)
public class AppConfigTest extends TestCase {

    @Test
    public void testFileCreator() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public void testFileConsumer() throws Exception {

    }
}