package com.slevinbe.eventmanager.view.overview.listview.itemrenderer;

import com.slevinbe.eventmanager.vo.EventVO;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.util.Callback;

import java.text.SimpleDateFormat;

public class EventListItemRenderer implements Callback<ListView<EventVO>, ListCell<EventVO>> {
    @Override
    public ListCell<EventVO> call(ListView<EventVO> objectListView) {
            return new EventCell();
    }

    private class EventCell extends ListCell<EventVO> {

        @Override
        public void updateItem(EventVO item, boolean empty) {
            super.updateItem(item, empty);

            if(item != null) {
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MMM/yyyy HH:mm");

                Label nameLabel = LabelBuilder.create()
                        .text(item.getName().toUpperCase())
                        .layoutX(10)
                        .layoutY(5)
                        .styleClass("eventItemHeader")
                        .build();

                nameLabel.maxWidthProperty().bind(getListView().widthProperty().subtract(10));

                String startTime = (item.getStartTime() != null)? dateFormatter.format(item.getStartTime()) : "n/a";
                String endTime = (item.getEndTime() != null)? dateFormatter.format(item.getEndTime()) : "n/a";
                Label dateLabel = LabelBuilder.create()
                        .text(startTime + " - " + endTime)
                        .layoutX(10)
                        .styleClass("eventItemDateLabel")
                        .build();
                dateLabel.layoutYProperty().bind(nameLabel.layoutYProperty().add(nameLabel.heightProperty()).add(5));

                Label locationLabel = LabelBuilder.create()
                        .text(" @ " + item.getLocation())
                        .styleClass("eventItemLocationLabel")
                        .build();
                locationLabel.layoutXProperty().bind(dateLabel.layoutXProperty().add(dateLabel.widthProperty()).add(5));
                locationLabel.layoutYProperty().bind(dateLabel.layoutYProperty());

                Label descriptionLabel = LabelBuilder.create()
                        .text(item.getDescription())
                        .layoutX(10)
                        .wrapText(true)
                        .styleClass("eventItemDescriptionLabel")
                        .build();
                descriptionLabel.layoutYProperty().bind(dateLabel.layoutYProperty().add(dateLabel.heightProperty().add(5)));
                descriptionLabel.prefWidthProperty().bind(getListView().widthProperty().subtract(40));

                Pane container = PaneBuilder.create()
                        .children(
                                nameLabel,
                                locationLabel,
                                dateLabel,
                                descriptionLabel
                        )
                        .layoutX(10)
                        .prefHeight(120)
                        .styleClass("eventListItemContainer")
                        .build();

                setGraphic(container);
            }
        }
    }
}
