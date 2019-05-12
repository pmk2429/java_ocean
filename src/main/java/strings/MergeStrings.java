package strings;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class MergeStrings {

  private static String interleave(String str1, String str2) {
    int length1 = str1.length();
    int length2 = str2.length();

    // take the smaller String
    int smallStringLength = length1 < length2 ? length1 : length2;
    int biggerStringLength = length1 > length2 ? length1 : length2;
    int remainingString = biggerStringLength - smallStringLength;

    System.out.println(remainingString);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < smallStringLength; i++) {
      sb.append(str1.charAt(i));
      sb.append(str2.charAt(i));
    }

    String biggerString = str1.compareTo(str2) > 0 ? str2 : str1;
    System.out.println(biggerString);
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
