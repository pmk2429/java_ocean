package arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Pavitra on 10/21/2015.
 */
public class ParamsArray {
    public static void main(String[] args) {
        new ParamsArray().checkParams(null, 1, null);
    }

    public void checkParams(String str, int data, Animal dog) {
        Object[] args = {str, data, dog};
        if (Collections.frequency(Arrays.asList(args), null) >= 2) {
            System.out.println("all params are null");
        } else {
            System.out.println("Not null");
        }
    }
}


class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}