package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
