package strings;

import java.util.Scanner;

public class Palindrome {
  public static void main(String args[]) {
    String original, reverse = "";
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a string to check if it is a palindrome:");
    System.out.print("> ");
    original = in.nextLine();

    int length = original.length();

    for (int i = length - 1; i >= 0; i--) {
      reverse = reverse + original.charAt(i);
    }

    System.out.println();
    if (original.equals(reverse)) {
      System.out.println("YES, Entered string is a palindrome.");
    } else {
      System.out.println("NO, Entered string is not a palindrome.");
    }
  }

  public static boolean isPalidrome(String inputString) {
    boolean isPalindrome = false;
    int length = inputString.length();
    int i, begin, end, middle;

    begin = 0;
    end = length - 1;
    middle = (begin + end) / 2;

    for (i = begin; i <= middle; i++) {
      if (inputString.charAt(begin) == inputString.charAt(end)) {
        begin++;
        end--;
      } else {
        break;
      }
    }
    if (i == middle + 1) {
      System.out.println("Palindrome");
      isPalindrome = true;
    } else {
      System.out.println("Not a palindrome");
      isPalindrome = false;
    }
    return isPalindrome;
  }
}
