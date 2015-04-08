package foo.bar.lab06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by blvp on 07.04.15.
 */
@Configuration
@PropertySource("classpath:file.properties")
public class AppConfig {

    @Value("${file}")
    private String fileName;

    @Bean
    public FileCreator fileCreator(){
        return new FileCreator(fileName);
    }

    @Bean
    public FileConsumer fileConsumer(){
        return new FileConsumer(fileName);
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        return new PropertyPlaceholderConfigurer();
    }

}
