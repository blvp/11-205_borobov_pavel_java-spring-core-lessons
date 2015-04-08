package foo.bar.lab03;

/**
 * Created by blvp on 07.04.15.
 */
public abstract class SpeakingRobot implements Robot {
    private RandomQuoter quoter;

    @Override
    public String speak(){
        String randomQuote = getQuoter().getRandomQuote();
        System.out.println(randomQuote);
        return randomQuote;
    }

    @Override
    public void setQuoter(RandomQuoter quoter) {
        this.quoter = quoter;
    }
}
