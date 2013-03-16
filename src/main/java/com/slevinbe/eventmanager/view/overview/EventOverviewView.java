package com.slevinbe.eventmanager.view.overview;

import com.slevinbe.eventmanager.view.overview.detail.EventDetailView;
import com.slevinbe.eventmanager.view.overview.listview.EventListView;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.util.Duration;

import javax.inject.Inject;

public class EventOverviewView implements IEventOverviewView {

    @Inject
    public IEventOverviewMediator mediator;
    @Inject
    public EventListView eventListView;
    @Inject
    public EventDetailView eventDetailView;

    private Pane view;
    private ListView eventList;
    private Pane detailsPane;
    private TranslateTransition showDetailsPaneTransition;
    private FadeTransition hideEventListTransition;
    private FadeTransition showEventListTransition;
    private TranslateTransition hideDetailsPaneTransition;

    public Pane getView() {
        if(view == null) {
            view = PaneBuilder.create()
                    .prefWidth(900)
                    .prefHeight(700)
                    .padding(new Insets(5))
                    .children(
                            eventList = eventListView.getView()
                    )
                    .build();
            eventList.prefWidthProperty().bind(view.widthProperty());
            eventList.prefHeightProperty().bind(view.heightProperty());

            hideEventListTransition = FadeTransitionBuilder.create()
                    .node(eventList)
                    .byValue(-1)
                    .duration(new Duration(300))
                    .interpolator(Interpolator.EASE_OUT)
                    .autoReverse(true)
                    .build();

            showEventListTransition = FadeTransitionBuilder.create()
                    .node(eventList)
                    .byValue(1)
                    .duration(new Duration(300))
                    .interpolator(Interpolator.EASE_OUT)
                    .autoReverse(true)
                    .build();

            mediator.init();
        }

        return view;
    }

    @Override
    public void showEventDetailPane() {
        initDetailsPane();

        hideEventListTransition.play();
        view.getChildren().add(detailsPane);
        showDetailsPaneTransition.play();
        hideEventListTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getChildren().remove(eventList);
            }
        });
    }

    @Override
    public void showEventsList() {
        hideDetailsPaneTransition.play();
        view.getChildren().add(eventList);
        showEventListTransition.play();
        hideDetailsPaneTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getChildren().remove(detailsPane);
            }
        });
    }

    private void initDetailsPane() {
        if(detailsPane == null) {
            detailsPane = eventDetailView.getView();
            detailsPane.setLayoutY(30);
            detailsPane.setLayoutX(30);

            hideDetailsPaneTransition = TranslateTransitionBuilder.create()
                    .node(detailsPane)
                    .fromX(0)
                    .toX(view.getWidth())
                    .duration(new Duration(300))
                    .interpolator(Interpolator.EASE_IN)
                    .build();

            showDetailsPaneTransition = TranslateTransitionBuilder.create()
                    .node(detailsPane)
                    .fromX(view.getWidth())
                    .toX(0)
                    .duration(new Duration(300))
                    .interpolator(Interpolator.EASE_IN)
                    .build();
        }
    }
}
