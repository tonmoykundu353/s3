package com.example.splash_learn.FlyweightDP;

public class EventShowinginfo {
    String clubname,eventdate,eventname,eventRegFees;
    EventSharedProperties eventSharedProperties;
    public EventShowinginfo(String clubname, String eventdate, String eventname, String eventRegFees, EventSharedProperties eventSharedProperties) {
        this.clubname = clubname;
        this.eventdate = eventdate;
        this.eventname = eventname;
        this.eventRegFees = eventRegFees;
        this.eventSharedProperties = eventSharedProperties;

    }

    public EventSharedProperties getEventSharedProperties() {
        return eventSharedProperties;
    }

    public void setEventSharedProperties(EventSharedProperties eventSharedProperties) {
        this.eventSharedProperties = eventSharedProperties;
    }


    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventRegFees() {
        return eventRegFees;
    }

    public void setEventRegFees(String eventRegFees) {
        this.eventRegFees = eventRegFees;
    }
}
