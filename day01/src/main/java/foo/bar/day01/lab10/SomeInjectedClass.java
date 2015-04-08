package foo.bar.day01.lab10;

/**
 * Created by blvp on 06.04.15.
 */
public class SomeInjectedClass {
    @InjectRandomInt
    private int value;

    public int getValue() {
        return value;
    }
}
