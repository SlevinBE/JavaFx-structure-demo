package com.slevinbe.eventmanager.application.guice;

import com.google.inject.AbstractModule;
import com.slevinbe.eventmanager.application.translations.ITranslationProvider;
import com.slevinbe.eventmanager.application.translations.ResourceBundleTranslationProvider;
import com.slevinbe.eventmanager.command.AcceptEventCommand;
import com.slevinbe.eventmanager.command.DeclineEventCommand;
import com.slevinbe.eventmanager.command.LoadEventsCommand;
import com.slevinbe.eventmanager.model.EventSelectionModel;
import com.slevinbe.eventmanager.model.IEventSelectionModel;
import com.slevinbe.eventmanager.service.IEventService;
import com.slevinbe.eventmanager.service.impl.StubEventService;
import com.slevinbe.eventmanager.view.overview.EventOverviewMediator;
import com.slevinbe.eventmanager.view.overview.EventOverviewView;
import com.slevinbe.eventmanager.view.overview.IEventOverviewMediator;
import com.slevinbe.eventmanager.view.overview.IEventOverviewView;
import com.slevinbe.eventmanager.view.overview.detail.EventDetailMediator;
import com.slevinbe.eventmanager.view.overview.detail.EventDetailView;
import com.slevinbe.eventmanager.view.overview.detail.IEventDetailMediator;
import com.slevinbe.eventmanager.view.overview.detail.IEventDetailView;
import com.slevinbe.eventmanager.view.overview.listview.EventListMediator;
import com.slevinbe.eventmanager.view.overview.listview.EventListView;
import com.slevinbe.eventmanager.view.overview.listview.IEventListMediator;
import com.slevinbe.eventmanager.view.overview.listview.IEventListView;

import javax.inject.Singleton;

/**
 * Guice module which maps the injections.
 */
public class EventManagerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EventManagerModule.class).toInstance(this);

        mapViews();
        mapMediators();
        mapCommands();
        mapServices();
        mapModels();
        mapInfrastructure();
    }

    private void mapViews() {
        bind(IEventOverviewView.class).to(EventOverviewView.class);
        bind(IEventListView.class).to(EventListView.class);
        bind(IEventDetailView.class).to(EventDetailView.class);
    }

    private void mapMediators() {
        bind(IEventOverviewMediator.class).to(EventOverviewMediator.class);
        bind(IEventListMediator.class).to(EventListMediator.class);
        bind(IEventDetailMediator.class).to(EventDetailMediator.class);
    }

    private void mapCommands() {
        bind(ICommandProvider.class).to(CommandProvider.class);

        bind(LoadEventsCommand.class);
        bind(AcceptEventCommand.class);
        bind(DeclineEventCommand.class);
    }

    private void mapServices() {
        bind(IEventService.class).to(StubEventService.class);
    }

    private void mapModels() {
        bind(IEventSelectionModel.class).to(EventSelectionModel.class).in(Singleton.class);
    }

    private void mapInfrastructure() {
        bind(ITranslationProvider.class).to(ResourceBundleTranslationProvider.class).in(Singleton.class);
    }
}
