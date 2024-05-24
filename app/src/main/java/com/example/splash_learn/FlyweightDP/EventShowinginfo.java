package com.example.splash_learn.FlyweightDP;

//package com.example.splash_learn;

public class EventShowinginfo {
    private String eventName;
    private String clubname;
    private String eventDate;
    private String eventRegFees;
    private EventSharedProperties sharedProperties;

    public EventShowinginfo(String eventName, String clubname, String eventDate, String eventRegFees, EventSharedProperties sharedProperties) {
        this.eventName = eventName;
        this.clubname = clubname;
        this.eventDate = eventDate;
        this.eventRegFees = eventRegFees;
        this.sharedProperties = sharedProperties;
    }

    public String getEventName() {
        return eventName;
    }

    public String getClubname() {
        return clubname;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventRegFees() {
        return eventRegFees;
    }

    public EventSharedProperties getSharedProperties() {
        return sharedProperties;
    }
}

