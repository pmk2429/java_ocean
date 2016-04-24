package objectTricks;

/**
 * Created by Pavitra on 12/5/2015.
 */
public class SupSub extends Superclass {
    public static void main(String[] args) {
        animal.setName("amigoes");
        String name = animal.getName();
        System.out.println(name);
    }
}

class Superclass {
    public static Animal animal = new Animal();
}

class Animal {
    String name;

    public Animal() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
