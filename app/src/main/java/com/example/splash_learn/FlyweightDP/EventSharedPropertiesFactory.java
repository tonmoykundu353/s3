package com.example.splash_learn.FlyweightDP;

//package com.example.splash_learn;

import java.util.HashMap;
import java.util.Map;

public class EventSharedPropertiesFactory {
    private static final Map<EventSharedProperties, EventSharedProperties> cache = new HashMap<>();

    public static EventSharedProperties getEventSharedProperties(String eventPlace, String organizedBy) {
        EventSharedProperties key = new EventSharedProperties(eventPlace, organizedBy);
        if (!cache.containsKey(key)) {
            cache.put(key, key);
        }
        return cache.get(key);
    }
}

