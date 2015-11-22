package uuid;

import java.util.UUID;

/**
 * Created by Pavitra on 11/16/2015.
 */
public class GenerateUUID {
    public static void main(String[] args) {
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();

        System.out.println((idOne));
        System.out.println((idTwo));
    }
}
