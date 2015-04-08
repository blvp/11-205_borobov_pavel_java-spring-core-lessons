package foo.bar.model;

/**
 * Created by blvp on 08.04.15.
 */
public class OrderInfo {
    private GuestInfo guest;
    private Event event;

    public GuestInfo getGuest() {
        return guest;
    }

    public void setGuest(GuestInfo guest) {
        this.guest = guest;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
