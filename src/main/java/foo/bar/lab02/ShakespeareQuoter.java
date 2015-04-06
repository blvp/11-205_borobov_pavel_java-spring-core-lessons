package foo.bar.lab02;

import java.util.Arrays;
import java.util.List;

/**
 * Created by blvp on 06.04.15.
 */
public class ShakespeareQuoter implements Quoter {
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(this.getClass().getSimpleName()+": "+message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
