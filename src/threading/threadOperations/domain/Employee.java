package threading.threadOperations.domain;

/**
 * Created by Pavitra on 11/1/2015.
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private String location;

    public Employee(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getId() < o.getId()) {
            return -1;
        } else if (this.getId() > o.getId()) {
            return 1;
        }
        return 0;
    }
}
