package com.slevinbe.eventmanager.model;

import com.slevinbe.eventmanager.vo.EventVO;
import javafx.beans.property.ObjectProperty;

public interface IEventSelectionModel {
    EventVO getSelectedEvent();

    void setSelectedEvent(EventVO event);

    ObjectProperty<EventVO> getSelectedEventProperty();
}
