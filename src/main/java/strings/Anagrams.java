package strings;

public class Anagrams {
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", s2 = "nagaram";

        boolean isAnagram = isAnagram(s1, s2);
        if (isAnagram) {
            System.out.println("Yes, strings are anagram");
        }
        else {
            System.out.println("No, strings are not anagram");
        }
    }
}
