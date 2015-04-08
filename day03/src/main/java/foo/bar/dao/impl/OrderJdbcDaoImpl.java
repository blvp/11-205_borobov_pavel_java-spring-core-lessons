package foo.bar.dao.impl;

import foo.bar.dao.OrderJdbcDao;
import foo.bar.model.GuestInfo;
import foo.bar.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by blvp on 08.04.15.
 */
@Repository
public class OrderJdbcDaoImpl implements OrderJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public OrderInfo createNewOrder(Long guestId, Long eventId) {
        return jdbcTemplate.execute(new ConnectionCallback<OrderInfo>() {
            @Override
            public OrderInfo doInConnection(Connection con) throws SQLException, DataAccessException {
                PreparedStatement pst = con.prepareStatement("INSERT INTO orders(guest_id, event_id) values(?, ?)");
                pst.setLong(1, guestId);
                pst.setLong(2, eventId);
                return new OrderInfo();
            }
        });
    }
}
