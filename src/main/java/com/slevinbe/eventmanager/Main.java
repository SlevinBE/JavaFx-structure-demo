package com.slevinbe.eventmanager;

import com.slevinbe.eventmanager.application.guice.EventManagerModule;
import com.slevinbe.eventmanager.view.overview.EventOverviewView;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Pane eventOverviewPane;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new EventManagerModule());
        EventOverviewView eventOverviewBuilder = injector.getInstance(EventOverviewView.class);

        Scene scene = SceneBuilder.create()
                .root(
                    eventOverviewPane = eventOverviewBuilder.getView()
                ).build();
        scene.getStylesheets().add(Main.class.getResource("/EventManager.css").toExternalForm());

        eventOverviewPane.prefWidthProperty().bind(scene.widthProperty());
        eventOverviewPane.prefHeightProperty().bind(scene.heightProperty());

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
