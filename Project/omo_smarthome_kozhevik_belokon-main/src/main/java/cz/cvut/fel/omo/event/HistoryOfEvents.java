package cz.cvut.fel.omo.event;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfEvents {
    private static HistoryOfEvents instance = null;

    private static List<Event> events = new ArrayList<>();

    public static void addEvent(Event event) {
        events.add(event);
    }

    public static HistoryOfEvents getInstance() {
        if (instance == null) {
            instance = new HistoryOfEvents();
        }
        return instance;
    }

    public List<Event> getEvents() {
        return events;
    }
}