package com.slevinbe.eventmanager.view.overview.detail;

import com.slevinbe.eventmanager.command.AcceptEventCommand;
import com.slevinbe.eventmanager.command.DeclineEventCommand;
import com.slevinbe.eventmanager.application.guice.ICommandProvider;
import com.slevinbe.eventmanager.command.LoadEventDetailsCommand;
import com.slevinbe.eventmanager.model.IEventSelectionModel;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import javax.inject.Inject;

public class EventDetailMediator implements IEventDetailMediator {

    @Inject
    public ICommandProvider commandProvider;
    @Inject
    public IEventSelectionModel eventSelectionModel;
    @Inject
    public IEventDetailView view;

    @Override
    public void init() {
        loadEventDetails();

        eventSelectionModel.getSelectedEventProperty().addListener(new SelectedEventChangeListener());
    }

    @Override
    public void exitScreen() {
        //clear the selection, which should be listened to in the overview screen
        eventSelectionModel.setSelectedEvent(null);
    }

    @Override
    public void declineEvent(String reason) {
        DeclineEventCommand command = commandProvider.get(DeclineEventCommand.class);
        command.setOnSucceeded(new DeclineEventSucceededHandler());
        command.eventToDeny = eventSelectionModel.getSelectedEvent();
        command.denyReason = reason;
        command.start();
    }

    @Override
    public void acceptEvent() {
        AcceptEventCommand command = commandProvider.get(AcceptEventCommand.class);
        command.setOnSucceeded(new AcceptEventSucceededHandler());
        command.eventToAccept = eventSelectionModel.getSelectedEvent();
        command.start();
    }

    private void loadEventDetails() {
        if(eventSelectionModel.getSelectedEvent() != null) {
            LoadEventDetailsCommand command = commandProvider.get(LoadEventDetailsCommand.class);
            command.setOnSucceeded(new LoadEventDetailsSucceededHandler());
            command.eventId = eventSelectionModel.getSelectedEvent().getId();
            command.start();
        } else {
            view.updateEventDetails(null);
        }
    }

    private class SelectedEventChangeListener implements ChangeListener<EventVO> {
        @Override
        public void changed(ObservableValue<? extends EventVO> observableValue, EventVO eventVO, EventVO eventVO2) {
            loadEventDetails();
        }
    }

    private class DeclineEventSucceededHandler implements EventHandler<WorkerStateEvent> {
        @Override
        public void handle(WorkerStateEvent workerStateEvent) {
            exitScreen();
        }
    }

    private class AcceptEventSucceededHandler implements EventHandler<WorkerStateEvent> {
        @Override
        public void handle(WorkerStateEvent workerStateEvent) {
            exitScreen();
        }
    }

    private class LoadEventDetailsSucceededHandler implements EventHandler<WorkerStateEvent> {
        @Override
        public void handle(WorkerStateEvent workerStateEvent) {
            view.updateEventDetails((EventVO) workerStateEvent.getSource().getValue());
        }
    }
}
