package threading.threadOperations.threads;

import threading.threadOperations.dao.EmployeeDao;
import threading.threadOperations.domain.Employee;

import java.util.concurrent.Callable;

/**
 * Created by Pavitra on 11/1/2015.
 */
public class TasksAsCallable implements Callable<Employee> {

    private int empId;

    public TasksAsCallable(int empId) {
        this.empId = empId;
    }

    @Override
    public Employee call() throws Exception {
        return EmployeeDao.getEmployeeById(this.empId);
    }
}
