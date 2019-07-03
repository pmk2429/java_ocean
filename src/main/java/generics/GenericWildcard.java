package generics;

/**
 * Once you create an object of MyEmployeeUtil class, the type argument will be
 * specific to an instance type. So you can compare between only same object
 * types, ie, you can compare either objects of CompAEmp or CompBEmp, but not
 * between CompAEmp and CompBEmp. To solve this problem, WildCard argument will
 * helps you. Look at below sample code, which can solve your problem.
 */
public class GenericWildcard {

  public static void main(String[] args) {
    MyEmployeeUtil<CompAEmp> empA = new MyEmployeeUtil<CompAEmp>(
        new CompAEmp("Pavitra", 20000));
    MyEmployeeUtil<CompBEmp> empB = new MyEmployeeUtil<CompBEmp>(
        new CompBEmp("Mantra", 30000));
    MyEmployeeUtil<CompAEmp> empC = new MyEmployeeUtil<CompAEmp>(
        new CompAEmp("Steve", 20000));
    MyEmployeeUtil<CompBEmp> empD = new MyEmployeeUtil<CompBEmp>(
        new CompBEmp("Bill", 40000));
    System.out.println("Is salary same? --> " + empA.isSalaryEqual(empB));
    System.out.println("Is salary same? --> " + empA.isSalaryEqual(empC));
    System.out.println("Is salary same? --> " + empC.isSalaryEqual(empD));
  }

}

class MyEmployeeUtil<T extends Emp> {

  private T emp;

  public MyEmployeeUtil(T obj) {
    emp = obj;
  }

  public int getSalary() {
    return emp.getSalary();
  }

  public boolean isSalaryEqual(MyEmployeeUtil<?> otherEmp) {

    if (emp.getSalary() == otherEmp.getSalary()) {
      return true;
    }
    return false;
  }

  // // create some utility methods to do employee functionalities
  //
  //
  //
}

class Emp {

  private String name;
  private int salary;

  public Emp(String name, int sal) {
    this.name = name;
    this.salary = sal;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
}

class CompAEmp extends Emp {

  public CompAEmp(String nm, int sal) {
    super(nm, sal);
  }
}

class CompBEmp extends Emp {

  public CompBEmp(String nm, int sal) {
    super(nm, sal);
  }
}
