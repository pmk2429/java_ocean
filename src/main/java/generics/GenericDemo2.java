package generics;

/**
 * Created by Pavitra on 10/19/2014.
 */
public class GenericDemo2<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        GenericDemo2<Integer> integerBox = new GenericDemo2<Integer>();
        GenericDemo2<String> stringBox = new GenericDemo2<String>();
        GenericDemo2<Double> doubleBox = new GenericDemo2<Double>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));
        doubleBox.add(new Double(125.251));

        System.out.printf("Integer Value: %d\n\n", integerBox.get());
        System.out.printf("String Value: %s\n\n", stringBox.get());
        System.out.printf("Double Value: %f\n", doubleBox.get());
    }
}
