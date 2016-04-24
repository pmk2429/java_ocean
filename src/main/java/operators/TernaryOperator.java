package operators;

/**
 * Created by Pavitra on 12/12/2015.
 */
public class TernaryOperator {
    private static int mValue;

    public static void main(String[] args) {
        setValue(11);
    }


    public static void setValue(int value) {
        mValue = value == 10 ? 0 : -1;
        System.out.println(mValue);
    }
}
