package com.p2prototype.b217.moodprototype;

/**
 * Created by Anders on 30/04/2017.
 */

public class Event {
    String eventName;
    int flagColor;
    public Event(String eventName, int flagColor){
        this.eventName = eventName;
        this.flagColor = flagColor;
    }

    public String getEventName() {
        return eventName;
    }

    public int getFlagColor() {
        return flagColor;
    }
}
