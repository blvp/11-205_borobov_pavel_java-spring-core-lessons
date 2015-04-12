package foo.bar.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by blvp on 10.04.15.
 */
@Entity
@Table(name = "order_info")
public class OrderInfo {

    @EmbeddedId
    private OrderInfoPK id;

    public OrderInfoPK getId() {
        return id;
    }

    public void setId(OrderInfoPK id) {
        this.id = id;
    }

    @Embeddable
    public class OrderInfoPK implements Serializable {

        @ManyToOne
        @JoinColumn(referencedColumnName = "id",
                nullable = false, updatable = false)
        private GuestInfo guest;

        @ManyToOne
        @JoinColumn(referencedColumnName = "id",
                nullable = false, updatable = false)
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
}
