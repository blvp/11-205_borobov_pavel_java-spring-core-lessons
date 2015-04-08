package foo.bar.service;

import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import foo.bar.model.OrderInfo;

/**
 * Created by blvp on 08.04.15.
 */
public interface OrderService {

    OrderInfo registerGuestToEvent(GuestInfo guest, Event event);
}
