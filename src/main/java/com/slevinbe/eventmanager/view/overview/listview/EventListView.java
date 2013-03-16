package com.slevinbe.eventmanager.view.overview.listview;

import com.slevinbe.eventmanager.view.overview.listview.itemrenderer.EventListItemRenderer;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.ListViewBuilder;
import javafx.scene.input.MouseEvent;

import javax.inject.Inject;
import java.util.List;

public class EventListView implements IEventListView {

    @Inject
    public IEventListMediator mediator;

    private ListView listView;
    private ObservableList events;

    public ListView getView() {
        if(listView == null) {
            events = FXCollections.observableArrayList();

            listView =  ListViewBuilder.create()
                    .items(events)
                    .onMouseClicked(new EventListMouseClickedHandler())
                    .build();
            listView.setCellFactory(new EventListItemRenderer());

            mediator.loadEvents();
        }

        return listView;
    }

    @Override
    public void updateEventList(List<EventVO> events) {
        this.events.clear();
        this.events.addAll(events);
    }

    private class EventListMouseClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            mediator.updateSelectedEvent((EventVO)listView.getSelectionModel().getSelectedItem());
        }
    }
}
