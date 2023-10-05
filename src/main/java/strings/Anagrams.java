package strings;

import java.util.stream.IntStream;

public class Anagrams {
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
            charFreq[t.charAt(i) - 'a']--;
        }
        boolean allZeroes = IntStream.of(charFreq).allMatch(x -> x == 0);
        return allZeroes;
    }

    private static boolean isAnagramAllChars(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charFreq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i)]++;
            charFreq[t.charAt(i)]--;
        }
        return IntStream.of(charFreq).allMatch(x -> x == 0); // checks for all Zeros(0) truthy
    }

    public static void main(String[] args) {
        String s1 = "pavitra", s2 = "artivap";

        boolean isAnagram = isAnagram(s1, s2);
        if (isAnagram) {
            System.out.printf("Yes, '%s' and '%s' are anagram", s1, s2);
        }
        else {
            System.out.println("No, strings are not anagram");
        }
    }
}
