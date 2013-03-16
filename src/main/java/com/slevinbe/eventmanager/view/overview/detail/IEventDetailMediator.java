package com.slevinbe.eventmanager.view.overview.detail;

public interface IEventDetailMediator {
    void init();

    void exitScreen();

    void declineEvent(String reason);

    void acceptEvent();
}
