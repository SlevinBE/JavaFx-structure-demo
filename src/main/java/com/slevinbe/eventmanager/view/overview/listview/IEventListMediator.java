package com.slevinbe.eventmanager.view.overview.listview;

import com.slevinbe.eventmanager.vo.EventVO;

public interface IEventListMediator {

    void loadEvents();

    void updateSelectedEvent(EventVO event);
}
