package foo.bar.lab03;

import foo.bar.lab01.RunThisMethod;
import foo.bar.lab02.Quoter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by blvp on 06.04.15.
 */
public class TalkingRobot implements Robot {
    private List<Quoter> quoters;

    @Override
    @RunThisMethod(repeat = 10)
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }
}
