package com.slevinbe.eventmanager.command;

import com.slevinbe.eventmanager.service.IEventService;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.inject.Inject;

public class LoadEventDetailsCommand extends Service<EventVO> {

    @Inject
    public IEventService eventService;
    public String eventId;

    @Override
    protected Task<EventVO> createTask() {
        return new Task<EventVO>() {
            @Override
            protected EventVO call() throws Exception {
                return eventService.getEventDetails(eventId);
            }
        };
    }
}
