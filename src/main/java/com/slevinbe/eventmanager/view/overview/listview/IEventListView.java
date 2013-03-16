package com.slevinbe.eventmanager.view.overview.listview;

import com.slevinbe.eventmanager.vo.EventVO;

import java.util.List;

public interface IEventListView {

    void updateEventList(List<EventVO> events);
}
