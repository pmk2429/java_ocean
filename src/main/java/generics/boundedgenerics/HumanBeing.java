package generics.boundedgenerics;

public class HumanBeing extends LivingBeing {
  String lastName;
  double height;

  public HumanBeing() {
  }

  public HumanBeing(String name, int age, int weight, String lastName,
                    double height) {
    super(name, age, weight);
    this.lastName = lastName;
    this.height = height;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void printType() {
    System.out.println("I am Human Being with name: " + this.getName()
        + " " + this.getLastName() + " having height : "
        + this.getHeight());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HumanBeing humansObj = (HumanBeing) obj;
    if (Double.doubleToLongBits(height) != Double
        .doubleToLongBits(humansObj.height)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(height);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  public boolean compareObj(HumanBeing obj1, HumanBeing obj2) {
    return obj1.equals(obj2);
  }

}
