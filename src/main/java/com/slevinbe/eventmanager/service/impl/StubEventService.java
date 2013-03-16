package com.slevinbe.eventmanager.service.impl;

import com.slevinbe.eventmanager.service.IEventService;
import com.slevinbe.eventmanager.vo.EventVO;

import java.util.*;

public class StubEventService implements IEventService {

    private List<EventVO> events;

    public StubEventService() {
        Calendar calendarDate = GregorianCalendar.getInstance();
        calendarDate.set(2012, 4, 24, 10, 20);
        Date date = calendarDate.getTime();

        
        events = new ArrayList<EventVO>();
        events.add(createEvent("1", "First Event", "Paris, France", date, date,
                "The event will showcase the first application"));
        events.add(createEvent("2", "Special meeting", "Manchester, UK", date, date,
                "A special meeting for a special application"));
        events.add(createEvent("3", "Technology meetup", "Brussels, Belgium", date, date,
                "Geeking out with the latest technologies"));
        events.add(createEvent("4", "Designer Conference", "Boston, US", date, date,
                "Various talks by the most famous designers in the industry"));
    }

    @Override
    public List<EventVO> getEvents() {
        return events;
    }

    @Override
    public EventVO getEventDetails(String id) {
        for (EventVO event : events) {
            if(event.getId() == id) {
                return event;
            }
        }

        return null;
    }

    @Override
    public void acceptEvent(EventVO event) {
    }

    @Override
    public void declineEvent(EventVO event, String reason) {
    }

    private EventVO createEvent(String id, String name, String location, Date startTime, Date endTime, String description) {
        EventVO event = new EventVO();
        event.setId(id);
        event.setName(name);
        event.setLocation(location);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setDescription(description);
        return event;
    }
}
