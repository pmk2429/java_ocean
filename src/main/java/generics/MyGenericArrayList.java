package generics;

public class MyGenericArrayList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		GenericArrayList strLst = new GenericArrayList();
		strLst.add("pmk");
		strLst.add("2429");
		strLst.add("tysu");
		strLst.add(new Integer(1234));
		for (int i = 0; i < strLst.size(); ++i) {
			String str = strLst.get(i).toString();
			System.out.println(str);
		}
	}
}

class GenericArrayList<E> {
	private int size;
	private Object[] elements;

	GenericArrayList() {
		elements = new Object[10];
		size = 0;
	}

	// e is element of type E.
	public void add(E e) {
		if (size < elements.length) {
			elements[size] = e;
		} else {

		}
		++size;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index
					+ " and Size: " + size);
		}
		return (E) elements[index];
	}

	public int size() {
		return size;
	}
}
