package com.slevinbe.eventmanager.model;

import com.slevinbe.eventmanager.vo.EventVO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class EventSelectionModel implements IEventSelectionModel {

    private ObjectProperty<EventVO> selectedEvent = new SimpleObjectProperty<EventVO>(this, "selectedEvent");

    @Override
    public EventVO getSelectedEvent() {
        return selectedEvent.get();
    }

    @Override
    public void setSelectedEvent(EventVO event) {
        selectedEvent.set(event);
    }

    @Override
    public ObjectProperty<EventVO> getSelectedEventProperty() {
        return selectedEvent;
    }
}
