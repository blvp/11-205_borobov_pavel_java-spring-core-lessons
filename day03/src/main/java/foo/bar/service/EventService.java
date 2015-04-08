package foo.bar.service;

import foo.bar.model.Event;
import foo.bar.model.GuestInfo;

import java.util.List;

/**
 * Created by blvp on 08.04.15.
 */
public interface EventService {
    List<GuestInfo> showAllGuests(Long eventId);
    Event createEvent(Event event);
    Event getEvent(Long eventId);

}
