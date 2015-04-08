package foo.bar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by blvp on 08.04.15.
 */
@Configuration
public class AppConfig {

    @Bean
    public RmiProxyFactoryBean proxyFactoryBean(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(GreetService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1199/GreetService");
        return rmiProxyFactoryBean;
    }
}

