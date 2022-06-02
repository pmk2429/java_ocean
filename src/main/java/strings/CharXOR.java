package strings;

import static java.lang.Integer.toBinaryString;

/**
 * if the strings are equal you'll get back a \0 which is not a printable character
 */
public class CharXOR {

    private static void xor() {
        String a = "abcde";
        String b = a;
        for (int idx = 0; idx < b.length(); idx++) {
            System.out.printf("xoring <%s> [%s] with <%s> [%s]\n",
                a.charAt(0), toBinaryString(a.charAt(0)),
                b.charAt(idx), toBinaryString(b.charAt(idx)));
            int c = (a.charAt(0) ^ b.charAt(idx));
            System.out.printf("result is <%s> [%s]\n", (char) c, toBinaryString(c));
        }
    }

    public static void main(String[] args) {
        String A = "a";
        String B = "b";
        int j = 0;
        char xorChar = (char) (A.charAt(j) ^ B.charAt(j));
        System.out.printf("'%c' = %d\n", xorChar, (int) xorChar);
    }
}
