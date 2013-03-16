package com.slevinbe.eventmanager.view.overview.detail;

import com.slevinbe.eventmanager.application.translations.ITranslationProvider;
import com.slevinbe.eventmanager.vo.EventVO;
import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import javax.inject.Inject;

public class EventDetailView implements IEventDetailView {

    @Inject
    public IEventDetailMediator mediator;
    @Inject
    public ITranslationProvider translationProvider;

    private Pane view;
    private Pane detailPanel;
    private GridPane form;
    private Label nameField;
    private Label locationField;
    private Label descriptionField;
    private Button acceptButton;
    private Button declineButton;
    private Button backButton;
    private Label startTimeField;
    private Label endTimeField;
    private Label eventTypeField;
    private Label createdByField;
    private TextArea declineReasonField;
    private VBox declineConfirmPanel;

    private FadeTransition showDeclineConfirmPanelTransition;
    private FadeTransition hideDeclineConfirmPanelTransition;

    public Pane getView() {
        if(view == null) {
            view =  PaneBuilder.create()
                    .children(
                            detailPanel = VBoxBuilder.create()
                                    .children(
                                        LabelBuilder.create()
                                                .text(translationProvider.getString("eventDetails.header").toUpperCase())
                                                .styleClass("eventDetailsHeader")
                                                .build(),
                                        form = createForm()
                                )
                                .build()
                    )
                    .build();

            mediator.init();
        }

        return view;
    }

    private GridPane createForm() {
        form = GridPaneBuilder.create()
                .hgap(10)
                .vgap(10)
                .padding(new Insets(25))
                .styleClass("detailPaneStyle")
                .build();

        ColumnConstraints column1 = new ColumnConstraints(300);
        ColumnConstraints column2 = new ColumnConstraints(300);

        form.getColumnConstraints().addAll(column1, column2);


        Label nameLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.name"))
                .styleClass("fieldLabelStyle")
                .build();
        nameField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .build();
        Label locationLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.location"))
                .styleClass("fieldLabelStyle")
                .build();
        locationField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .build();
        Label startTimeLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.startTime"))
                .styleClass("fieldLabelStyle")
                .build();
        startTimeField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .build();
        Label endTimeLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.endTime"))
                .styleClass("fieldLabelStyle")
                .build();
        endTimeField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .build();
        Label eventTypeLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.eventType"))
                .styleClass("fieldLabelStyle")
                .build();
        eventTypeField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .build();
        Label createdByLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.createdBy"))
                .styleClass("fieldLabelStyle")
                .build();
        createdByField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .build();
        Label descriptionLabel = LabelBuilder.create()
                .text(translationProvider.getString("eventDetails.label.description"))
                .styleClass("fieldLabelStyle")
                .build();
        descriptionField = LabelBuilder.create()
                .styleClass("fieldStyle")
                .prefWidth(Integer.MAX_VALUE)
                .wrapText(true)
                .build();

        acceptButton = ButtonBuilder.create()
                .text(translationProvider.getString("eventDetails.button.accept"))
                .onMouseClicked(new AcceptButtonClickHandler())
                .build();
        declineButton = ButtonBuilder.create()
                .text(translationProvider.getString("eventDetails.button.decline"))
                .onMouseClicked(new DeclineButtonClickHandler())
                .build();
        backButton = ButtonBuilder.create()
                .text(translationProvider.getString("eventDetails.button.back"))
                .onMouseClicked(new BackButtonClickHandler())
                .build();
        HBox buttonBox = HBoxBuilder.create()
                .children(
                        backButton,
                        declineButton,
                        acceptButton
                )
                .spacing(5)
                .alignment(Pos.BASELINE_RIGHT)
                .build();

        form.add(nameLabel, 0, 0);
        form.add(nameField, 0, 1);
        form.add(locationLabel, 1, 0);
        form.add(locationField, 1, 1);
        form.add(startTimeLabel, 0, 2);
        form.add(startTimeField, 0, 3);
        form.add(endTimeLabel, 1, 2);
        form.add(endTimeField, 1, 3);
        form.add(eventTypeLabel, 0, 4);
        form.add(eventTypeField, 0, 5);
        form.add(createdByLabel, 1, 4);
        form.add(createdByField, 1, 5);
        form.add(descriptionLabel, 0, 6);
        form.add(descriptionField, 0, 7, 2, 1);
        form.add(buttonBox, 0, 8, 2, 1);

        return form;
    }

    public Pane createDeclineEventPane() {
        declineConfirmPanel = VBoxBuilder.create()
                .prefWidth(400)
                .spacing(4)
                .styleClass("declineReasonPanel")
                .children(
                        LabelBuilder.create()
                                .text(translationProvider.getString("eventDetails.label.declineReason"))
                                .styleClass("fieldLabelStyle")
                                .build(),
                        declineReasonField = TextAreaBuilder.create()
                                .build(),
                        HBoxBuilder.create()
                            .spacing(5)
                            .alignment(Pos.BASELINE_RIGHT)
                            .children(
                                    ButtonBuilder.create()
                                            .text(translationProvider.getString("eventDetails.button.cancel"))
                                            .onMouseClicked(new CancelEventDeclineHandler())
                                            .build(),
                                    ButtonBuilder.create()
                                            .text(translationProvider.getString("eventDetails.button.decline"))
                                            .onMouseClicked(new DeclineConfirmButtonClickHandler())
                                            .build()
                            ).build()
                ).build();

        declineConfirmPanel.layoutXProperty().bind(
                detailPanel.layoutXProperty().add(
                        detailPanel.widthProperty().subtract(declineConfirmPanel.widthProperty()).divide(2)
                )
        );

        declineConfirmPanel.layoutYProperty().bind(
                detailPanel.layoutYProperty().add(
                        detailPanel.heightProperty().subtract(declineConfirmPanel.heightProperty()).divide(2)
                )
        );

        showDeclineConfirmPanelTransition = FadeTransitionBuilder.create()
                .node(declineConfirmPanel)
                .fromValue(0)
                .toValue(1)
                .duration(new Duration(300))
                .build();

        hideDeclineConfirmPanelTransition = FadeTransitionBuilder.create()
                .node(declineConfirmPanel)
                .fromValue(1)
                .toValue(0)
                .duration(new Duration(300))
                .build();

        return declineConfirmPanel;
    }

    public void updateEventDetails(EventVO event) {
        if(view != null && event != null) {
            nameField.setText(event.getName());
            locationField.setText(event.getLocation());
            descriptionField.setText(event.getDescription());
            createdByField.setText(event.getCreatedBy());
            eventTypeField.setText(event.getEventType());
        }
    }


    private class BackButtonClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            mediator.exitScreen();
        }
    }

    private class DeclineButtonClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(declineConfirmPanel == null) {
                createDeclineEventPane();
            }

            view.getChildren().add(declineConfirmPanel);
            showDeclineConfirmPanelTransition.play();
        }
    }

    private class AcceptButtonClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            mediator.acceptEvent();
        }
    }

    private class DeclineConfirmButtonClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            mediator.declineEvent(declineReasonField.getText());
            view.getChildren().remove(declineConfirmPanel);
        }
    }

    private class CancelEventDeclineHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            hideDeclineConfirmPanelTransition.play();
            hideDeclineConfirmPanelTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    view.getChildren().remove(declineConfirmPanel);
                }
            });
        }
    }
}
