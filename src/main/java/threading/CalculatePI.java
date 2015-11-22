package threading;

/**
 * Created by Pavitra on 11/19/2015.
 */
public class CalculatePI {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        try {
            mt.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Pi = " + mt.pi);
    }
}

class MyThread extends Thread {
    double pi;
    boolean negative = true;

    @Override
    public void run() {
        for (int i = 3; i < 100000; i += 2) {
            if (negative)
                pi -= (1.0 / i);
            else
                pi += (1.0 / i);
            negative = !negative;
        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println("Finished calculating pi");

    }
}
