package com.slevinbe.eventmanager.view.overview.listview;

import com.slevinbe.eventmanager.command.LoadEventsCommand;
import com.slevinbe.eventmanager.application.guice.ICommandProvider;
import com.slevinbe.eventmanager.model.IEventSelectionModel;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import javax.inject.Inject;
import java.util.List;

public class EventListMediator implements IEventListMediator {

    @Inject
    public ICommandProvider commandProvider;
    @Inject
    public IEventSelectionModel eventSelectionModel;
    @Inject
    public IEventListView view;

    public void loadEvents() {
        LoadEventsCommand command = commandProvider.get(LoadEventsCommand.class);
        command.setOnSucceeded(new LoadEventsSucceedHandler());
        command.start();
    }

    @Override
    public void updateSelectedEvent(EventVO event) {
        eventSelectionModel.setSelectedEvent(event);
    }

    private class LoadEventsSucceedHandler implements EventHandler<WorkerStateEvent> {

        @Override
        public void handle(WorkerStateEvent workerStateEvent) {
            view.updateEventList((List<EventVO>)workerStateEvent.getSource().getValue());
        }
    }
}
