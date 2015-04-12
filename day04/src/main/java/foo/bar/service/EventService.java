package foo.bar.service;

import foo.bar.model.Event;

/**
 * Created by blvp on 10.04.15.
 */
public interface EventService {
    Event getEventById(Long id);
}
