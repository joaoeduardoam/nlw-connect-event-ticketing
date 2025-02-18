package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String message){
        super(message);
    }
}
