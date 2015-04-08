package foo.bar.lab04;

import foo.bar.lab05.QuoterQualifier;
import foo.bar.lab05.QuoterType;
import org.springframework.stereotype.Component;

/**
 * Created by blvp on 07.04.15.
 */
@Component
@QuoterQualifier(QuoterType.TERMINATOR)
public class TerminatorQuoter implements Quoter {
    @Override
    public String sayQuote() {
        return "I'll be back!";
    }
}
