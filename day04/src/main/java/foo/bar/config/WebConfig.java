package foo.bar.config;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Created by blvp on 10.04.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "foo.bar.controller"
})
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/templates/");
        configurer.setDefaultEncoding("UTF-8");
        configurer.setFreemarkerSettings(new Properties() {{
            this.put("default_encoding", "UTF-8");
        }});
        return configurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker().suffix(".ftl").cache(false);
        super.configureViewResolvers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("hello");
        super.addViewControllers(registry);
    }

    @Bean
    public HandlerExceptionResolver handlerExceptionResolverComposite(){
        HandlerExceptionResolverComposite handlerExceptionResolverComposite = new HandlerExceptionResolverComposite();
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.addStatusCode("404", HttpStatus.NOT_FOUND.value());
        handlerExceptionResolverComposite.setExceptionResolvers(Arrays.asList(simpleMappingExceptionResolver));
        handlerExceptionResolverComposite.setOrder(1);
        return handlerExceptionResolverComposite;
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.addStatusCode("404", HttpServletResponse.SC_NOT_FOUND);
        exceptionResolvers.add(simpleMappingExceptionResolver);
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }


}
