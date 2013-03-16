package com.slevinbe.eventmanager.command;

import com.slevinbe.eventmanager.service.IEventService;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.inject.Inject;
import java.util.List;

public class LoadEventsCommand extends Service<List<EventVO>> {

    @Inject
    public IEventService eventService;

    @Override
    protected Task<List<EventVO>> createTask() {
        return new Task<List<EventVO>>() {
            @Override
            protected List<EventVO> call() throws Exception {
                return eventService.getEvents();
            }
        };

    }
}
