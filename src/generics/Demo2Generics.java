package generics;

/**
 * Created by Pavitra on 10/19/2014.
 */
public class Demo2Generics {

    public static void main(String[] args) {
        SampleGenerics<String, Integer> sample = new SampleGenerics<String, Integer>("PMK", 2429);

        sample.printObjects();
        sample.add("PMK", 2429);

        System.out.println(sample.getU() + " : " + sample.getV());
    }


}

class SampleGenerics<U, V> {
    private U objU;
    private V objV;

    public SampleGenerics(U objU, V objV) {
        this.objU = objU;
        this.objV = objV;
    }

    public void add(U u, V v) {
        this.objU = u;
        this.objV = v;
    }

    public U getU() {
        return objU;
    }

    public V getV() {
        return objV;
    }


    public void printObjects() {
        System.out.println("U type: " + this.objU.getClass().getName());
        System.out.println("V type: " + this.objV.getClass().getName());
    }
}
