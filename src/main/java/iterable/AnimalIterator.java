package iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimalIterator<String> implements Iterator<Object> {

	private ArrayList<?> animal;
	private int position;

	public AnimalIterator(Animal animal) {
		this.animal = animal.getAnimal();
	}

	@Override
	public boolean hasNext() {
		if (position < animal.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Object animalObj = animal.get(position);
		position++;
		return animalObj;
	}

	@Override
	public void remove() {
		animal.remove(position);
	}

}
