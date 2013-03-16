package com.slevinbe.eventmanager;

import com.slevinbe.eventmanager.application.guice.EventManagerModule;
import com.slevinbe.eventmanager.view.overview.EventOverviewView;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new EventManagerModule());
        EventOverviewView eventOverviewBuilder = injector.getInstance(EventOverviewView.class);

        Scene scene = SceneBuilder.create()
                .root(
                    eventOverviewBuilder.getView()
                ).width(900)
                .height(700)
                .build();
        scene.getStylesheets().add(Main.class.getResource("/EventManager.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }
}
