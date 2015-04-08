package foo.bar.dao.impl;

import com.google.common.collect.*;
import foo.bar.dao.EventJdbcDao;
import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by blvp on 08.04.15.
 */
@Repository
public class EventJdbcDaoImpl implements EventJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<GuestInfo> getGuestsByEventId(final Long eventId) {
        final String query = "SELECT g.id, g.name from guests g, orders o WHERE g.id = o.guest_id AND o.event_id = ?";
        PreparedStatementCreator creator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setLong(1, eventId);
            return preparedStatement;
        };
        return jdbcTemplate.query(creator, GuestInfo.GUEST_INFO_RM);
    }

    @Override
    public Event createEvent(Event event) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((con -> {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO events(name) values(?)");
            preparedStatement.setString(1, event.getName());
            return preparedStatement;
        }), keyHolder);
        event.setId((Long) keyHolder.getKey());
        return event;
    }

    @Override
    public Event findEventById(Long eventId) {
        Event event = new Event();
        Multimap<Long, GuestInfo> eventIdToGuestList = ArrayListMultimap.create();
        jdbcTemplate.query(con -> {
            PreparedStatement pst = con.prepareStatement("SELECT e.id as event_id, g.id as guest_id, g.name as guestName FROM orders o, guests g, events e where o.guest_id = g.id AND o.event_id = ?");
            pst.setLong(1, eventId);
            return pst;
        }, rs -> {
            eventIdToGuestList.put(rs.getLong("event_id"), new GuestInfo(rs.getLong("guest_id"), rs.getString("guestName")));
        });
        Long newEventId = eventIdToGuestList.keys().iterator().next();
        event.setId(newEventId);
        event.setGuests(Lists.newArrayList(eventIdToGuestList.get(newEventId)));
        new HashMap(){{this.put("1", "1");}};
        return event;
    }


}
