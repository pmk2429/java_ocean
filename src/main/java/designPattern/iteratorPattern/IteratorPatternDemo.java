package designPattern.iteratorPattern;

public class IteratorPatternDemo {

	public static void main(String[] args) {
		NameRepository names = new NameRepository();
		for (Iterator iter = names.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("Name: " + name);
		}
	}
}
