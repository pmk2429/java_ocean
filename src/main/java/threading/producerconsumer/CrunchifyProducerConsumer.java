package threading.producerconsumer;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Pavitra on 11/22/2015.
 */
public class CrunchifyProducerConsumer {
  private static Vector<Object> data = new Vector<>();

  public static void main(String[] args) {
    new Producer().start();
    new Consumer().start();
  }

  public static class Consumer extends Thread {
    Consumer() {
      super("Consumer");
    }

    @Override
    public void run() {
      for (; ; ) {
        try {
          Thread.sleep(1);
        } catch (Exception e) {
          e.printStackTrace();
        }
        // IMP step to consider else Consumer will consume when Producer haven't produced
        synchronized (data) {
          @SuppressWarnings("rawtypes")
          Iterator it = data.iterator();
          while (it.hasNext())
            it.next();
        }
      }
    }
  }

  public static class Producer extends Thread {
    Producer() {
      super("Producer");
    }

    @Override
    public void run() {
      for (; ; ) {
        try {
          Thread.sleep(1);
        } catch (Exception e) {
          e.printStackTrace();
        }
        data.add(new Object());
        if (data.size() > 1000)
          data.remove(data.size() - 1);
      }
    }
  }
}