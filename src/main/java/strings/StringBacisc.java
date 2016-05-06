package strings;

import java.util.Scanner;

/**
 * Created by Pavitra on 5/6/2016.
 */
public class StringBacisc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());

        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");

        if (A.length() == 1) {
            A = A.substring(0, 1).toUpperCase();
        } else if (A.length() > 1) {
            A = A.substring(0, 1).toUpperCase() + A.substring(1, A.length());
        }
        if (B.length() == 1) {
            B = B.substring(0, 1).toUpperCase();
        } else if (B.length() > 1) {
            B = B.substring(0, 1).toUpperCase() + B.substring(1, B.length());
        }
        System.out.println(A + " " + B);

        sc.close();
    }
}
