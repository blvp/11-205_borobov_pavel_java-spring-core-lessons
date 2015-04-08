package foo.bar.day01.lab02;

import java.util.List;

/**
 * Created by blvp on 06.04.15.
 */
public class TeminatorQuoter implements Quoter{
    private List<String> messages;

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println(this.getClass().getSimpleName() + ": " + message);
        }
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
