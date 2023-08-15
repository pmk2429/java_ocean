package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * WAP to find Given a string check if it is Pangram or not.
 * A pangram is a sentence containing every letter in the English Alphabet.
 * <p>
 * Examples : "The quick brown fox jumps over the lazy dog” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
 * “The quick brown fox jumps over the dog” is not a Pangram.
 * [Doesn’t contain all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing]
 * <p>
 */
public class Pangram {

    private static final int MAX_CHARS = 26;

    private static boolean checkPangram(String str) {
        boolean[] mark = new boolean[26];

        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // If uppercase character, subtract 'A' to find index.
            if ('A' <= c && c <= 'Z') {
                index = c - 'A';
            }
            else if ('a' <= c && c <= 'z') {
                // If lowercase character, subtract 'a' to find index.
                index = c - 'a';
            }

            // mark the character as visited
            mark[index] = true;
        }

        for (int i = 0; i <= 25; i++) {
            if (!mark[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPangram(String str) {
        boolean[] mark = new boolean[MAX_CHARS];
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if ('A' <= currChar && currChar <= 'Z') {
                mark[currChar - 'A'] = true;
            }
            else if ('a' <= currChar && currChar <= 'z') {
                mark[currChar - 'a'] = true;
            }
        }

        for (int i = 0; i < MAX_CHARS; i++) {
            if (!mark[i]) {
                return false;
            }
        }

        return true;
    }

    private static List<Character> missingChars(String str, int strLength) {
        boolean[] mark = new boolean[MAX_CHARS];
        List<Character> charsList = new ArrayList<>();

        for (int i = 0; i < strLength; i++) {
            char currChar = str.charAt(i);
            if ('A' <= currChar && currChar <= 'Z') {
                mark[currChar - 'A'] = true;
            }
            else if ('a' <= currChar && currChar <= 'z') {
                mark[currChar - 'a'] = true;
            }
        }
        for (int i = 0; i < MAX_CHARS; i++) {
            if (!mark[i]) {
                charsList.add((char) (i + 'a'));
            }
        }
        return charsList;
    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPangram(str));
    }
}
