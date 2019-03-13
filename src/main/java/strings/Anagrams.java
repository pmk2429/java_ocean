package strings;

public class Anagrams {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = "hello";

    Anagrams anagramObj = new Anagrams();
    boolean isAnagram = anagramObj.anagram(s1, s2);
    if (isAnagram) {
      System.out.println("Yes, strings are anagram");
    } else {
      System.out.println("No, strings are not anagram");
    }
  }

  private boolean anagram(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    A = A.toLowerCase();
    B = B.toLowerCase();
    int[] letters = new int[256];
    int numOfUniqueChars = 0;
    int numCompletedInS2 = 0;
    char[] s1_array = A.toCharArray();
    for (char c : s1_array) {
      if (letters[c] == 0) {
        ++numOfUniqueChars;
      }
      ++letters[c];
    }

    for (int i = 0; i < B.length(); ++i) {
      int c = (int) B.charAt(i);
      if (letters[c] == 0) {
        return false;
      }
      --letters[c];
      if (letters[c] == 0) {
        ++numCompletedInS2;
        if (numCompletedInS2 == numOfUniqueChars) {
          return i == B.length() - 1;
        }
      }
    }
    return false;
  }
}
