package strings;

import java.util.Arrays;

public class ReplaceWhiteSpace {
    public static void main(String[] args) {
        String str = "my name is pavitra kansara";

        ReplaceWhiteSpace replaceObj = new ReplaceWhiteSpace();
        char[] strArr = str.toCharArray();
        int length = str.length();
        String replacedString = replaceObj.replaceWithWhiteSpace(strArr, length);
        System.out.println(replacedString);
    }

    public String replaceWithWhiteSpace(char[] strArr, int length) {
        int spaceCount = 0, i;
        for (i = 0; i < length; i++) {
            if (strArr[i] == ' ') {
                spaceCount++;
            }
        }
        // count newLength of the array.
        int newLength = length + spaceCount * 2;
        // increase the length of the array
        strArr = Arrays.copyOf(strArr, newLength);
        // now loop through array
        for (i = length - 1; i >= 0; i--) {
            if (strArr[i] == ' ') {
                strArr[newLength - 1] = '0';
                strArr[newLength - 2] = '2';
                strArr[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                strArr[newLength - 1] = strArr[i];
                newLength = newLength - 1;
            }
        }
        return String.copyValueOf(strArr);
    }
}
