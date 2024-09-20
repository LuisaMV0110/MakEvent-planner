package com.mindhub.event_planner.handlers;

public class ObjectNotFound extends RuntimeException{
    public ObjectNotFound(String message){
        super(message);
    }
}
