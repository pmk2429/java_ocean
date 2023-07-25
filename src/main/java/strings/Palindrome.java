package strings;

import java.util.Scanner;

public class Palindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
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
            }
            else {
                break;
            }
        }
        if (i == middle + 1) {
            System.out.println("Palindrome");
            isPalindrome = true;
        }
        else {
            System.out.println("Not a palindrome");
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
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
        }
        else {
            System.out.println("NO, Entered string is not a palindrome.");
        }
    }
}
