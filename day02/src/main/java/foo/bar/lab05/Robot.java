package foo.bar.lab05;

import foo.bar.lab04.Quoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by blvp on 07.04.15.
 */
@Component
public class Robot {

    @Autowired
    @QuoterQualifier(QuoterType.TERMINATOR)
    Quoter quoter;
}
