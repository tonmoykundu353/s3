package com.example.splash_learn;


/**
 *  This is eventInfor class
 */
public class Eventinfo {

    String Clubname,EventName,EventPlace,EventRegFees,EventDate,OrganizedBy;

    /**
     * This is the constructor of EventInfo class with these parameters below..
     * @param clubname
     * @param eventName
     * @param eventPlace
     * @param eventRegFees
     * @param eventDate
     * @param userRoll
     */
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

    /**
     * this is getter (name) of EventInfo
     * @return
     */
    public String getClubname() {
        return Clubname;
    }

    /**
     * this is setter(name) of EventInfo
     * @param clubname
     */
    public void setClubname(String clubname) {
        Clubname = clubname;
    }

    /**
     * this is setter(Eventname) of EventInfo
     * @param
     */
    public String getEventName() {
        return EventName;
    }

    /**
     * This is setter(EventName) of EventInfo
     * @param eventName
     */
    public void setEventName(String eventName) {
        EventName = eventName;
    }

    /**
     * This is getter( place ) of EventInfo
     * @return
     */
    public String getEventPlace() {
        return EventPlace;
    }

    /**
     * This is setter( place ) of EventInfo
     * @param eventPlace
     */
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

    /**
     * This is getter (Organization) of EventInfo
     * @return
     */
    public String getOrganizedBy() {
        return OrganizedBy;
    }

    public void setOrganizedBy(String organizedBy) {
        OrganizedBy = organizedBy;
    }
}
