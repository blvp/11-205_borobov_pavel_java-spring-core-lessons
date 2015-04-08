package foo.bar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by blvp on 08.04.15.
 */
public class Server {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
    }
}
