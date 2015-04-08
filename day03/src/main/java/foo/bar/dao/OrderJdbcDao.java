package foo.bar.dao;

import foo.bar.model.OrderInfo;

/**
 * Created by blvp on 08.04.15.
 */
public interface OrderJdbcDao {
    OrderInfo createNewOrder(Long guestId, Long eventId);
}
