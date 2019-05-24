package strings;

import java.util.Scanner;

public class SubstringCheck {
  public static void main(String[] args) {
    System.out.println("Enter Strings s1 and s1");
    System.out.print("S1> ");
    System.out.println();
    Scanner input = new Scanner(System.in);
    String inputString1 = input.next();
    input.close();
    System.out.print("S2> ");
    Scanner input2 = new Scanner(System.in);
    String inputString2 = input.next();
    input2.close();

    SubstringCheck subStringObj = new SubstringCheck();
    boolean check = subStringObj.isRotation(inputString1, inputString2);
    System.out.println(check);

  }

  private boolean isRotation(String inputString1, String inputString2) {
    int length = inputString1.length();
    if (length == inputString2.length() && length > 0) {
      // concatenate 2 Strings with buffer.
      String bufferString = inputString1 + inputString2;
      return isSubstring(bufferString, inputString2);
    }
    return false;
  }

  private boolean isSubstring(String bufferString, String inputString2) {
    /**
     * isSubstring method checks if one string is substring of another or
     * not.
     *
     */
    return false;
  }
}
