package foo.bar.lab05;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by blvp on 07.04.15.
 */
@Qualifier
public @interface QuoterQualifier {
    QuoterType value() default QuoterType.SHEAKSPERE;
}
