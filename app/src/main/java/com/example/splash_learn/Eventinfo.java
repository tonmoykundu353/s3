package com.example.splash_learn;

public class Eventinfo {
    String Clubname,EventName,EventPlace,EventRegFees,EventDate,OrganizedBy;

    public Eventinfo(String clubname, String eventName, String eventPlace, String eventRegFees, String eventDate,String userRoll) {
        Clubname = clubname;
        EventName = eventName;
        EventPlace = eventPlace;
        EventRegFees = eventRegFees;
        EventDate = eventDate;
        OrganizedBy=userRoll;
    }

    public Eventinfo() {

    }

    public String getClubname() {
        return Clubname;
    }

    public void setClubname(String clubname) {
        Clubname = clubname;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventPlace() {
        return EventPlace;
    }

    public void setEventPlace(String eventPlace) {
        EventPlace = eventPlace;
    }

    public String getEventRegFees() {
        return EventRegFees;
    }

    public void setEventRegFees(String eventRegFees) {
        EventRegFees = eventRegFees;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public String getOrganizedBy() {
        return OrganizedBy;
    }

    public void setOrganizedBy(String organizedBy) {
        OrganizedBy = organizedBy;
    }
}
