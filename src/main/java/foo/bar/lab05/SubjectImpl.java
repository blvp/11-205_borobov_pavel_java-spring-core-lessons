package foo.bar.lab05;

/**
 * Created by blvp on 06.04.15.
 */
public class SubjectImpl implements Subject {
    @Override
    public String longMethod() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000L);
        }
        return "";
    }
}
