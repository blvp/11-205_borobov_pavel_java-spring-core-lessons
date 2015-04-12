package foo.bar.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by blvp on 10.04.15.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq")
    private Long id;

    private String name;

    private String description;

    private Date dateCreated;

    @ManyToMany
    @JoinTable(
            name = "order_info",
            inverseJoinColumns = {
                    @JoinColumn(name = "event_id", referencedColumnName = "id")
            },
            joinColumns = {
                    @JoinColumn(name = "guest_id", referencedColumnName = "id")
            }
    )
    private List<GuestInfo> guests;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<GuestInfo> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestInfo> guests) {
        this.guests = guests;
    }
}
