package foo.bar.service;

import foo.bar.config.AppConfig;
import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EventService eventService;

    private GuestInfo testGuest;
    private Event testEvent;

    @Before
    public void setUp() throws Exception {
        testGuest = null;
        testEvent = eventService.createEvent(new Event("Test event1"));
    }

    @Test
    public void testRegisterGuestToEventCount() throws Exception {
        orderService.registerGuestToEvent(testGuest, testEvent);

    }
}