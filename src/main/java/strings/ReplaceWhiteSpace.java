package strings;

import java.util.Arrays;

public class ReplaceWhiteSpace {
    private static String replaceWithWhiteSpace(String str) {
        char[] strArr = str.toCharArray();
        int length = str.length();
        int spaceCount = (int) str.chars().filter(ch -> ch == ' ').count();
        // count newLength of the array.
        int newLength = length + spaceCount * 2;
        // increase the length of the array
        strArr = Arrays.copyOf(strArr, newLength);
        // now loop through array
        for (int i = length - 1; i >= 0; i--) {
            if (Character.isWhitespace(strArr[i])) {
                strArr[newLength - 1] = '0';
                strArr[newLength - 2] = '2';
                strArr[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                strArr[newLength - 1] = strArr[i];
                newLength--;
            }
        }
        return String.copyValueOf(strArr);
    }

    public static void main(String[] args) {
        String str = "my name is pavitra kansara";
        System.out.println(replaceWithWhiteSpace(str));
    }
}
