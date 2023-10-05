package strings;

import java.util.Arrays;

public class ReplaceWhiteSpace {
    private static String replaceWithWhiteSpace(String str) {
        char[] res = str.toCharArray();
        int length = str.length();
        int spaceCount = (int) str.chars().filter(Character::isWhitespace).count();
        // count newLength of the array.
        int newLength = length + spaceCount * 2;
        // increase the length of the array
        res = Arrays.copyOf(res, newLength);
        // now loop through array
        for (int i = length - 1; i >= 0; i--) {
            if (Character.isWhitespace(res[i])) {
                res[newLength - 1] = '0';
                res[newLength - 2] = '2';
                res[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                res[newLength - 1] = res[i];
                newLength--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str = "My name is Pavitra M Kansara";
        System.out.println(replaceWithWhiteSpace(str));
    }
}
