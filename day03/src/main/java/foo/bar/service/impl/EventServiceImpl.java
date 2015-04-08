package foo.bar.service.impl;

import foo.bar.dao.EventJdbcDao;
import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import foo.bar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by blvp on 08.04.15.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventJdbcDao eventDao;

    @Override
    public List<GuestInfo> showAllGuests(Long eventId) {
        return eventDao.getGuestsByEventId(eventId);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDao.createEvent(event);
    }

    @Override
    public Event getEvent(Long eventId) {
        return eventDao.findEventById(eventId);
    }

}
