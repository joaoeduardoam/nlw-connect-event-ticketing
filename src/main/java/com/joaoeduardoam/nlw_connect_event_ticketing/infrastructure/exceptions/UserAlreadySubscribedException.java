package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions;

public class UserAlreadySubscribedException extends RuntimeException{

    public UserAlreadySubscribedException(String message){
        super(message);
    }
}
