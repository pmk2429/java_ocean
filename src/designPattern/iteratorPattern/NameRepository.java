package designPattern.iteratorPattern;

public class NameRepository implements Container {

	public String[] names = { "Pavitra", "Komal", "Mantra", "Rashmi", "Mukund",
			"Tyson" };

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {
			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return names[index++];
			}
			return null;
		}
	}
}
