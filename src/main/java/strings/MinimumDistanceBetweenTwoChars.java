package strings;

/**
 * Given a String XXX000YYYX0Y, find the minimum difference between X and Y.
 */
public class MinimumDistanceBetweenTwoChars {

    private static int minimumDistance(String str, char c1, char c2) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int shortedDistance = str.length();
        int i1 = -1, i2 = -1;

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar == c1) {
                i1 = i;
            }
            else if (currChar == c2) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                shortedDistance = Math.min(shortedDistance, Math.abs(i2 - i1));
            }
        }
        return shortedDistance;
    }

    public static void main(String[] args) {
        String str = "XXX000YYY0000X0Y";
        System.out.println(minimumDistance(str, 'X', 'Y'));
    }

}
