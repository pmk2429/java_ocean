package enumDemo;

/**
 * Created by Pavitra on 11/10/2015.
 */
public class EnumTest {
    public enum ActivityState {
        STARTED, RUNNING, STOPPED
    }

    public static void main(String[] args) {
        System.out.println(ActivityState.RUNNING);
    }
}
