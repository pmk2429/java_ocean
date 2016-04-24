package interfaces.generics;

/**
 * Created by Pavitra on 11/27/2015.
 */
public class GenericInterfaceTest {
    public static void main(String[] args) {
        Box<EntityTest> entityTestBox = new Box<>();
        UserTest userTest = new UserTest("Pavitra");
        entityTestBox.set(userTest);
        System.out.println(entityTestBox.get().getName());
    }
}

class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

interface EntityTest {
    String getName();
}

class UserTest implements EntityTest {

    private String name;

    public UserTest(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
