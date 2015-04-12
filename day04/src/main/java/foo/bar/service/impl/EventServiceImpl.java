package foo.bar.service.impl;

import foo.bar.dao.EventDao;
import foo.bar.model.Event;
import foo.bar.service.EventService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by blvp on 10.04.15.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    @Transactional
    public Event getEventById(Long id) {
        Event one = eventDao.findOne(id);
        Hibernate.initialize(one.getGuests());
        return one;
    }
}
