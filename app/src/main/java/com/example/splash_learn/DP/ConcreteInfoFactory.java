package com.example.splash_learn.DP;

import com.example.splash_learn.Contestentinfo;
import com.example.splash_learn.Eventinfo;
import com.example.splash_learn.RegStudAtEventInfo;

// Concrete factory implementation
public class ConcreteInfoFactory implements InfoFactory {
    @Override
    public Eventinfo createEventinfo(String clubname, String eventName, String eventPlace, String eventRegFees, String eventDate, String organizedBy) {
        return new Eventinfo(clubname, eventName, eventPlace, eventRegFees, eventDate, organizedBy);
    }

    @Override
    public Contestentinfo createContestentinfo(String name, String email, String ContactNo) {
        return new Contestentinfo(name, email, ContactNo);
    }

//    @Override
//    public RegStudAtEventInfo createRegStudAtEventInfo(String contactNo, String email, String name) {
//        return new RegStudAtEventInfo(contactNo, email, name);
//    }



}