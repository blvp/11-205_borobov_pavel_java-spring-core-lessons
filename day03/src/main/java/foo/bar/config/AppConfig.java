package foo.bar.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;

/**
 * Created by blvp on 08.04.15.
 */
@Configuration
@Import({DaoConfig.class, ServiceConfig.class})
public class AppConfig {


    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        return new PropertyPlaceholderConfigurer();
    }
}
