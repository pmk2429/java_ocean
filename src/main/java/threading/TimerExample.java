package threading;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Pavitra on 5/8/2016.
 */
public class TimerExample {

    private static final Timer timer = new Timer();

    // runs only once
    public static void main(String[] args) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("printed");
            }
        }, 2 * 1000);


        // runs repetitively
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("rep printing");
            }
        }, 2 * 1000, 2 * 1000);
    }
}
