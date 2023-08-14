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

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeNormal(String inputString) {
        boolean isPalindrome = false;
        int length = inputString.length();
        int start = 0;
        int end = length - 1;
        int middle = (start + end) / 2;
        int i;

        for (i = start; i <= middle; i++) {
            if (inputString.charAt(start) == inputString.charAt(end)) {
                start++;
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
        String original;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        System.out.print("> ");
        original = in.nextLine();


        System.out.println();
        if (isPalindrome(original)) {
            System.out.println("YES, Entered string is a palindrome.");
        }
        else {
            System.out.println("NO, Entered string is not a palindrome.");
        }
    }
}
