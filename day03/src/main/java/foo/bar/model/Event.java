package foo.bar.model;

import java.util.List;

/**
 * Created by blvp on 08.04.15.
 */
public class Event {
    private Long id;
    private String name;
    private List<GuestInfo> guests;

    public Event(String name) {
        this.name = name;
    }

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GuestInfo> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestInfo> guests) {
        this.guests = guests;
    }
}
