package generics.boundedgenerics;

public class LivingBeing {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String name;
    public int age;
    public int weight;
    public LivingBeing() {
    }

    public LivingBeing(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void printType() {
        System.out.println("I am Living Being with name: " + this.getName()
                + " and age: " + this.getAge() + " weighing : "
                + this.getWeight());
    }
}
