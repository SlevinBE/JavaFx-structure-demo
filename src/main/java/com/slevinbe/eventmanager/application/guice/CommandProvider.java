package com.slevinbe.eventmanager.application.guice;

import com.google.inject.Injector;
import javafx.concurrent.Service;

import javax.inject.Inject;

public class CommandProvider implements ICommandProvider {

    @Inject
    public Injector injector;

    public <T extends Service> T get(Class<T> type) {
        return injector.getInstance(type);
    }
}
