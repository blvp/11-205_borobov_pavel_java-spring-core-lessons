package foo.bar.service;

import foo.bar.config.AppConfig;
import foo.bar.model.Event;
import foo.bar.model.GuestInfo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class EventServiceTest extends TestCase {

    @Autowired
    private EventService eventService;

    @Test
    public void testShowAllGuests() throws Exception {
        List<GuestInfo> guests = eventService.showAllGuests(1L);
        Assert.assertNotNull(guests);
        Assert.assertEquals(2, guests.size());
    }

    @Test
    public void testCreateEvent() throws Exception {
        Event event = new Event();
        event.setName("blahblah");
        event = eventService.createEvent(event);

        Assert.assertNotNull(event);

        Long eventId = event.getId();

        Assert.assertNotNull(eventId);
    }
}