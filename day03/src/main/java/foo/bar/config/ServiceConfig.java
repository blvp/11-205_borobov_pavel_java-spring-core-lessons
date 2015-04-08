package foo.bar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by blvp on 08.04.15.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "foo.bar.service"
})
public class ServiceConfig {

}
