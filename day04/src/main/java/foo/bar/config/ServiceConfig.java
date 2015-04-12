package foo.bar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by blvp on 10.04.15.
 */
@Configuration
@ComponentScan(basePackages = {
        "foo.bar.service"
})
public class ServiceConfig {
}
