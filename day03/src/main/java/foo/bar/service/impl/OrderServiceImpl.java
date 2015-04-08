package foo.bar.service.impl;

import foo.bar.dao.OrderJdbcDao;
import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import foo.bar.model.OrderInfo;
import foo.bar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by blvp on 08.04.15.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderJdbcDao orderJdbcDao;
    @Override
    public OrderInfo registerGuestToEvent(GuestInfo guest, Event event) {
        Assert.notNull(event, "event object must not be null!");
        Assert.notNull(guest, "guest object must not be null!");
        Assert.notNull(guest.getId(), "guest must contain id value!");
        Assert.notNull(event.getId(), "event must contain id value!" );
        OrderInfo newOrder = orderJdbcDao.createNewOrder(guest.getId(), event.getId());
        newOrder.setEvent(event);
        newOrder.setGuest(guest);
        return newOrder;
    }
}
