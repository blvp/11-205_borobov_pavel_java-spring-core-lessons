package foo.bar.model;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by blvp on 08.04.15.
 */
public class GuestInfo {
    private Long id;
    private String name;
    private List<Event> events;

    public GuestInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }


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

    public static final RowMapper<GuestInfo> GUEST_INFO_RM = new RowMapper<GuestInfo>() {
        @Override
        public GuestInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new GuestInfo(rs.getLong("id"), rs.getString("name"));
        }
    };

}
