package hard;

import java.util.*;

public class OrgChart {

  public static void main(String[] args) {
        /*
        Calculate salary for the employees
            - FTE: Salary provided
            - Contractor - hourly pay provided
            - Manager - salary is sum of the salary of reports

        Employee:
             * id
             * type
             * name
             * FTE - Salary, Contractor - hourly pay, Manager - list of reports
             * Contractor - hours per week
         */

    List<List<String>> testCase1 = new ArrayList<>();

    testCase1.add(new ArrayList<>(Arrays.asList("1", "FTE", "George", "75000", null)));
    testCase1.add(new ArrayList<>(Arrays.asList("7", "FTE", "Stephan", "50000", null)));
    testCase1.add(new ArrayList<>(Arrays.asList("3", "Manager", "Veronica", "9,6", null)));
    testCase1.add(new ArrayList<>(Arrays.asList("9", "Manager", "Christopher", "1,5", null)));
    testCase1.add(new ArrayList<>(Arrays.asList("5", "Manager", "Mary", "7", null)));
    testCase1.add(new ArrayList<>(Arrays.asList("6", "Contractor", "John", "100", "40")));

    List<List<String>> testCase2 = new ArrayList<>();
    testCase2.add(new ArrayList<>(Arrays.asList("0", "FTE", "George", "75000", null)));
    testCase2.add(new ArrayList<>(Arrays.asList("1", "FTE", "Stephan", "50000", null)));
    testCase2.add(new ArrayList<>(Arrays.asList("2", "Manager", "Veronica", "3,5", null)));
    testCase2.add(new ArrayList<>(Arrays.asList("3", "Manager", "Christopher", "0,4", null)));
    testCase2.add(new ArrayList<>(Arrays.asList("4", "Manager", "Mary", "1", null)));
    testCase2.add(new ArrayList<>(Arrays.asList("5", "Contractor", "John", "100", "40")));

    List<List<String>> testCase3 = new ArrayList<>();
    testCase3.add(new ArrayList<>(Arrays.asList("1", "FTE", "George", "75000", null)));
    testCase3.add(new ArrayList<>(Arrays.asList("2", "FTE", "Stephan", "50000", null)));
    testCase3.add(new ArrayList<>(Arrays.asList("3", "Manager", "Veronica", "4,6", null)));
    testCase3.add(new ArrayList<>(Arrays.asList("4", "Manager", "Christopher", "1,5", null)));
    testCase3.add(new ArrayList<>(Arrays.asList("5", "Manager", "Mary", "2", null)));
    testCase3.add(new ArrayList<>(Arrays.asList("6", "Contractor", "John", "100", "40")));

    List<List<String>> testCase4 = new ArrayList<>();
    testCase4.add(new ArrayList<>(Arrays.asList("1", "FTE", "George", "75000", null)));
    testCase4.add(new ArrayList<>(Arrays.asList("2", "FTE", "Stephan", "50000", null)));
    testCase4.add(new ArrayList<>(Arrays.asList("3", "Manager", "Veronica", "4,6", null)));
    testCase4.add(new ArrayList<>(Arrays.asList("4", "Manager", "Christopher", "1,5,3", null)));
    testCase4.add(new ArrayList<>(Arrays.asList("5", "Manager", "Mary", "2", null)));
    testCase4.add(new ArrayList<>(Arrays.asList("6", "Contractor", "John", "100", "40")));

    System.out.println(sortedListOfSalaries(testCase4));
  }


  // Stack : 4 6
  // Process: 4 (1 5 3)
  //

  private static final String MANAGER = "Manager";
  private static final String FULL_TIME = "FTE";
  private static final String CONTRACTOR = "Contractor";

  // map of employee by id-details relationship
  private static Map<String, List<String>> employeeMap = new HashMap<>();
  private static int[] visitedEmployees;

  private static int deduceSalary(List<String> employeeDetails) {
    int totalSalary = 0;
    int totalWeeksInYear = 52;
    if (employeeDetails != null && employeeDetails.size() >= 4) {
      // if (visitedEmployees[Integer.valueOf(employeeDetails.get(0)])
      visitedEmployees[Integer.valueOf(employeeDetails.get(0))] = 1;
      // branch according to role of employee
      if (employeeDetails.get(1).equals(FULL_TIME)) {
        return Integer.parseInt(employeeDetails.get(3));
      } else if (employeeDetails.get(1).equals(CONTRACTOR)) {
        int totalHours = Integer.valueOf(employeeDetails.get(4)) * totalWeeksInYear;
        totalSalary = Integer.parseInt(employeeDetails.get(3)) * totalHours;
        return totalSalary;
      } else if (employeeDetails.get(1).equals(MANAGER)) {
        String[] employeeIds = employeeDetails.get(3).split(",");
        for (int i = 0; i < employeeIds.length; i++) {
          List<String> reportDetails = employeeMap.get(employeeIds[i]);
          // can be FTE, Contractor or a Manager
          totalSalary += deduceSalary(reportDetails);
        }
        return totalSalary;
      }
    }
    return 0;
  }

  // Complete the sortedListOfSalaries function below.
  static List<Integer> sortedListOfSalaries(List<List<String>> workers) {
    // list of all salaries
    List<Integer> salaryList = new ArrayList<>();

    if (workers == null || workers.size() == 0) {
      return salaryList; // empty Salary
    }

    // first build the sanitized map of each employee and its details for its use later in order to deduce salaries
    for (List<String> employeeDetails : workers) {
      employeeMap.put(employeeDetails.get(0), employeeDetails);
    }

    visitedEmployees = new int[employeeMap.size()];

    // once we have build the map, we can loop the workers to deduce salaries
    for (List<String> employeeDetails : workers) {
      int totalSalary = deduceSalary(employeeDetails);
      salaryList.add(totalSalary);
    }

    Collections.sort(salaryList);

    return salaryList;
  }
}


// Org Chart

/*
   Calculate salary for the employees
   - FTE: Salary provided
   - Contractor - hourly pay provided
   - Manager - salary is sum of the salary of reports

   Employee:
   * id
   * type
   * name
   * FTE - Salary, Contractor - hourly pay, Manager - list of reports
   * Contractor - hours per week
*/

class EmployeeNode {
  String id;
  String name;
  String pay; // salary or hourly pay
  String type;
}
