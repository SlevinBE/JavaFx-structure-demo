package com.slevinbe.eventmanager.service;

import com.slevinbe.eventmanager.vo.EventVO;

import java.util.List;

public interface IEventService {

    List<EventVO> getEvents();
    EventVO getEventDetails(String id);
    void acceptEvent(EventVO event);
    void declineEvent(EventVO event, String reason);
}
