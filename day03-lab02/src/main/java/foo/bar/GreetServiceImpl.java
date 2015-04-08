package foo.bar;

import org.springframework.stereotype.Component;

/**
 * Created by blvp on 08.04.15.
 */
public class GreetServiceImpl implements GreetService {
    private String greet;

    public void setGreet(String greet) {
        this.greet = greet;
    }

    @Override
    public String greet() {
        return greet;
    }
}
