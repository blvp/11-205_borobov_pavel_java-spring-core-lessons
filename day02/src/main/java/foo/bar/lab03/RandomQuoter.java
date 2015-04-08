package foo.bar.lab03;

import java.util.Random;

/**
 * Created by blvp on 07.04.15.
 */
public class RandomQuoter {
    private String randomQuote;

    public RandomQuoter() {
        randomQuote = Integer.toHexString(new Random().nextInt());
    }

    public String getRandomQuote() {
        return randomQuote;
    }
}
