package foo.bar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by blvp on 10.04.15.
 */
@Configuration
@Import({DataSourceConfig.class, PersistenceConfig.class, ServiceConfig.class})
public class CoreConfig {
}
