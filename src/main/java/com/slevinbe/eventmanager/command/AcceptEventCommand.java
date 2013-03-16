package com.slevinbe.eventmanager.command;

import com.slevinbe.eventmanager.service.IEventService;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.inject.Inject;

public class AcceptEventCommand extends Service<Void> {

    @Inject
    public IEventService eventService;
    public EventVO eventToAccept;

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                eventService.acceptEvent(eventToAccept);

                return null;
            }
        };
    }
}
