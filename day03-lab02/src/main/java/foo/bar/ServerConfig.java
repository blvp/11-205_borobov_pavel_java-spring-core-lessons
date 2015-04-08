package foo.bar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by blvp on 08.04.15.
 */
@Configuration
public class ServerConfig {

    @Bean
    public GreetService serverGreeter(){
        GreetServiceImpl greetService = new GreetServiceImpl();
        greetService.setGreet("Hello, World!");
        return greetService;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter(GreetService greetService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(GreetService.class);
        rmiServiceExporter.setService(greetService);
        rmiServiceExporter.setServiceName("GreetService");
        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }
}
