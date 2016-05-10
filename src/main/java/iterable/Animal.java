package iterable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Animal Class is used to depict the for-each behavior of the custom object It
 * contains the Name of animals as an attribute.
 *
 * @author Pavitra
 */
public class Animal implements Iterable<String> {
    private ArrayList<String> animal = new ArrayList<String>();

    public Animal(ArrayList<String> animal) {
        this.animal = animal;
    }

    public ArrayList<String> getAnimal() {
        return animal;
    }

    @Override
    public Iterator<String> iterator() {
        return new AnimalIterator(this);
    }

}
