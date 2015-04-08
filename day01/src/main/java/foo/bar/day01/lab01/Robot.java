package foo.bar.day01.lab01;

/**
 * Created by blvp on 06.04.15.
 */
public class Robot {

    @RunThisMethod(repeat = 10)
    public void clean(){
        System.out.println("Cleaning!");
    }

    @Override
    public String toString() {
        return "I'm Robot!";
    }
}
