package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!

("Traffic", 10) -> ("Traffic", 10)
("Earthquake", 100) -> ("Earthquake", 100)
("Wild fire", 20) -> ("Earthquake", 100)
Remove ("Earthquake", 100) -> ("Wild fire", 20)
Remove ("Traffic", 10) -> ("Wild fire", 20)

class Event {
  String type;
  int priority;
}

Consumer -> Producer

Design EMS
-> Queue(FIFO) based on priority -> PriorityQueue
-> update(String msg)

Observable > Observer (employeed, people)

*/

// Queue
// Send updates when priority changes
// Subscribing parties to inform with message

class Solution {
    public static void main(String[] args) {
        EventManagementSystem emsObservable = new EventManagementSystem();
        emsObservable.addListener(new Listener());

        Event event = new Event("Traffic", 10);
        emsObservable.addEvent(event);
        // output Traffic

        Event earthQuake = new Event("Earthquake", 100);
        emsObservable.addEvent(earthQuake);
        // output Earthquake

        Event wildFire = new Event("Wild fire", 20);
        emsObservable.addEvent(wildFire);
        // no output

        emsObservable.removeEvent(earthQuake);
        emsObservable.removeEvent(event);
        emsObservable.removeEvent(wildFire);
    }
}

class Event {
    String type;
    int priority;

    public Event(String type, int priority) {
        this.type = type;
        this.priority = priority;
    }
}

interface EventMessage {
    void notify(Event event);
}

class Listener implements EventMessage {
    @Override
    public void notify(Event event) {
        System.out.println(event.type);
    }
}

class EventManagementSystem {
    // sort the events in the reverse order of priority
    private static final Comparator<Event> eventsComparator = Comparator.comparingInt(event -> -event.priority);

    private static final PriorityQueue<Event> eventsQueue = new PriorityQueue<>(eventsComparator);
    private static final List<Listener> eventListeners = new ArrayList<>();

    public void addEvent(Event newEvent) {
        eventsQueue.offer(newEvent);

        Event topPriorityEvent = this.getTopPriorityEvent();
        if (topPriorityEvent.priority == newEvent.priority) {
            notify(newEvent);
        }
    }

    public void addListener(Listener listener) {
        eventListeners.add(listener);
    }

    public void notify(Event highestPriorityEvent) {
        for (Listener listener : eventListeners) {
            listener.notify(highestPriorityEvent);
        }
    }

    /**
     * Returns the top most event stored in the Queue which is sorted by priority.
     */
    public Event getTopPriorityEvent() {
        return eventsQueue.peek();
    }

    public Event removeEvent() {
        return eventsQueue.poll();
    }

    public boolean removeEvent(Event event) {
        return eventsQueue.remove(event);
    }

}