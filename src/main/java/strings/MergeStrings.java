package strings;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class MergeStrings {

    private static String interleave(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        // take the smaller String
        int smallStringLength = Math.min(length1, length2);
        int biggerStringLength = Math.max(length1, length2);
        int remainingString = biggerStringLength - smallStringLength;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < smallStringLength; i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }

        String biggerString = str1.compareTo(str2) < 0 ? str1 : str2;
        int startIndex = biggerString.length() - remainingString;

        // append the remaining pieces in the String
        for (int i = startIndex; i < biggerString.length(); i++) {
            sb.append(biggerString.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(interleave("4567", "d"));
    }
}
