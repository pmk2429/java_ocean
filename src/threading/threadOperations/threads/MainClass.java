package threading.threadOperations.threads;

import threading.threadOperations.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Pavitra on 11/1/2015.
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<Employee>> listCallableEmployee = new ArrayList<Callable<Employee>>();

        listCallableEmployee.add(new TasksAsCallable(1001));
        listCallableEmployee.add(new TasksAsCallable(1002));
        listCallableEmployee.add(new TasksAsCallable(1003));
        listCallableEmployee.add(new TasksAsCallable(1004));
        listCallableEmployee.add(new TasksAsCallable(1005));

        // returns a list of Futures holding their status and results when all complete
        List<Future<Employee>> tasks = executorService.invokeAll(listCallableEmployee);

        System.out.println(tasks.size() + " Responses recieved.\n");

        for (Future<Employee> task : tasks) {
            System.out.println(task.get().toString());
        }

        /* shutdown your thread pool, else your application will keep running */
        executorService.shutdown();
    }
}
