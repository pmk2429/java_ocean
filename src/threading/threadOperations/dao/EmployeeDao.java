package threading.threadOperations.dao;

import threading.threadOperations.domain.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pavitra on 11/1/2015.
 */
public class EmployeeDao {
    private static Map<Integer, Employee> emps;


    static {
        emps = new HashMap<Integer, Employee>();

        emps.put(1001, new Employee(1001, "Pavitra", "Ahmedabad"));
        emps.put(1002, new Employee(1002, "Jayant", "Pune"));
        emps.put(1003, new Employee(1003, "Ravi", "Banglore"));
        emps.put(1004, new Employee(1004, "Kapil", "Delhi"));
        emps.put(1005, new Employee(1005, "Gaurav", "Pune"));
    }

    public static Employee getEmployeeById(int empId) {
        return emps.get(empId);
    }
}
