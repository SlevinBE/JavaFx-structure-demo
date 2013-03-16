package com.slevinbe.eventmanager.view.overview;

import com.slevinbe.eventmanager.model.IEventSelectionModel;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.inject.Inject;

public class EventOverviewMediator implements IEventOverviewMediator {

    @Inject
    public IEventOverviewView view;

    @Inject
    public IEventSelectionModel eventSelectionModel;

    public void init() {
        eventSelectionModel.getSelectedEventProperty().addListener(new SelectedEventChangedHandler());
    }

    private class SelectedEventChangedHandler implements ChangeListener<EventVO> {
        @Override
        public void changed(ObservableValue<? extends EventVO> observableValue, EventVO eventVO, EventVO eventVO2) {
            if(eventVO2 != null) {
                view.showEventDetailPane();
            } else {
                view.showEventsList();
            }
        }
    }
}
