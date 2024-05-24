package com.example.splash_learn.DP;

import com.example.splash_learn.Eventinfo;
import com.example.splash_learn.Contestentinfo;
import com.example.splash_learn.RegStudAtEventInfo;

// Define an interface for the factory
// Factory interface
public interface InfoFactory {
    Eventinfo createEventinfo(String clubname, String eventName, String eventPlace, String eventRegFees, String eventDate, String organizedBy);

    Contestentinfo createContestentinfo(String name, String email, String ContactNo);

    //RegStudAtEventInfo createRegStudAtEventInfo(String contactNo, String email, String name);
}


// Usage
//public class FactoryPatternExample {
//    public static void main(String[] args) {
//        // Create factory
//        InfoFactory factory = new ConcreteInfoFactory();
//
//        // Create instances using factory
//        Eventinfo eventinfo = factory.createEventinfo("Club A", "Event A", "Place A", "$10", "2024-05-20", "User A");
//        Contestentinfo contestantinfo = factory.createContestantinfo("John Doe", "john@example.com", "1234567890");
//        RegStudAtEventInfo regStudAtEventInfo = factory.createRegStudAtEventInfo("1234567890", "jane@example.com", "Jane Doe");
//
//        // Use the created instances
//        System.out.println(eventinfo.getEventName());
//        System.out.println(contestantinfo.getName());
//        System.out.println(regStudAtEventInfo.getEmail());
//    }
//}

