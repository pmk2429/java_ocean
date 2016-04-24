package arrays.lamda;

import java.util.Observable;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class MyApp {
    public static void main(String[] args) {
        out.print("Enter text> ");
        EventSource eventSource = new EventSource();

        eventSource.addObserver((Observable obs, Object arg) -> {
            out.println("\nReceived response: " + arg);
        });

        new Thread(eventSource).start();
    }
}

class EventSource extends Observable implements Runnable {
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            setChanged();
            notifyObservers(response);
        }
    }
}