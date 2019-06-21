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
  private static Comparator<Event> eventsComparator = Comparator.comparingInt(e1 -> -e1.priority);

  private static PriorityQueue<Event> eventsQueue = new PriorityQueue<>(eventsComparator);
  private static List<Listener> eventListeners = new ArrayList<>();

  public void addEvent(Event newEvent) {

    // main DNF
    eventsQueue.offer(newEvent);

    Event topPriorityEvent = this.getTopPriorityEvent();
    if (topPriorityEvent.priority == newEvent.priority) {
      notify(newEvent);
    }

    //else if (topPriorityEvent.priority < newEvent.priority) {
    //  notify(newEvent);
    //}

    // log the output
  }

  public void addListener(Listener listener) {
    eventListeners.add(listener);
  }

  public void notify(Event highestPriorityEvent) {
    for (Listener listener : eventListeners) {
      listener.notify(highestPriorityEvent);
    }
  }

  public Event getTopPriorityEvent() {
    // Edge cases
    return eventsQueue.peek();
    // log the output
  }

  public Event removeEvent() {
    // Edge cases
    Event topEvent = eventsQueue.poll();
    // log the output
    return topEvent;
  }

  public boolean removeEvent(Event event) {
    // Edge cases
    return eventsQueue.remove(event);
    // log the output
  }

}