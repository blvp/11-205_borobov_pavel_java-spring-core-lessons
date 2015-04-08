package foo.bar.dao;

import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by blvp on 08.04.15.
 */
public interface EventJdbcDao {
    List<GuestInfo> getGuestsByEventId(Long eventId);
    Event createEvent(Event event);

    Event findEventById(Long eventId);
}
