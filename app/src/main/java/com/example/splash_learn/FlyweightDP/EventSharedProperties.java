package com.example.splash_learn.FlyweightDP;

//package com.example.splash_learn;

public class EventSharedProperties {
    private String eventPlace;
    private String organizedBy;

    public EventSharedProperties(String eventPlace, String organizedBy) {
        this.eventPlace = eventPlace;
        this.organizedBy = organizedBy;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public String getOrganizedBy() {
        return organizedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventSharedProperties that = (EventSharedProperties) o;

        if (!eventPlace.equals(that.eventPlace)) return false;
        return organizedBy.equals(that.organizedBy);
    }

    @Override
    public int hashCode() {
        int result = eventPlace.hashCode();
        result = 31 * result + organizedBy.hashCode();
        return result;
    }
}

