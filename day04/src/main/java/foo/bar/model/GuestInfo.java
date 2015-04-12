package foo.bar.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by blvp on 10.04.15.
 */
@Entity
public class GuestInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
    @SequenceGenerator(name = "guest_seq")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "guests")
    private List<Event> events;

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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

