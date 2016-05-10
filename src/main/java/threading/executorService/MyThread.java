package threading.executorService;

/**
 * Created by Pavitra on 5/8/2016.
 */

public class MyThread implements Runnable {

    private String myName;
    private int count;
    private final long timeSleep;

    MyThread(String name, int newcount, long newtimeSleep) {
        this.myName = name;
        this.count = newcount;
        this.timeSleep = newtimeSleep;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        int sum = 0;
        for (int i = 1; i <= this.count; i++) {
            sum = sum + i;
        }
        System.out.println(myName + " thread has sum = " + sum +
                " and is going to sleep for " + timeSleep);
        try {
            Thread.sleep(this.timeSleep);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
