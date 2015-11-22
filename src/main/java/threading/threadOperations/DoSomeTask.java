package threading.threadOperations;

/**
 * Created by Pavitra on 11/1/2015.
 */
public class DoSomeTask implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new DoSomeTask());
        thread.start();
    }

    //Means our thread can not return any value.
    @Override
    public void run() {
        System.out.println("Your business logic");
    }
}


