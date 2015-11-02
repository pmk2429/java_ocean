package threading;

/**
 * Created by Pavitra on 10/27/2015.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ReturnValueFromThread {

    public static void main(String args[]) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Double> retdouble = service.submit(new RetDouble());
        Future<Integer> retInt = service.submit(new RetInt());
        System.out.println(retdouble.get());
        System.out.println(retInt.get());
        service.shutdown();
    }
}

class RetDouble implements Callable<Double> {

    RetDouble() {
    }

    @Override
    public Double call() {
        return 2.0;
    }
}

class RetInt implements Callable<Integer> {

    RetInt() {
    }

    @Override
    public Integer call() {

        return 1;
    }
}