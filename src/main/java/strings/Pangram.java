package strings;

/**
 * WAP to find Given a string check if it is Pangram or not.
 * A pangram is a sentence containing every letter in the English Alphabet.
 * <p>
 * Examples : The quick brown fox jumps over the lazy dog ” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
 * “The quick brown fox jumps over the dog” is not a Pangram
 * [Doesn’t contains all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing]
 * <p>
 */
public class Pangram {

  private static boolean checkPangram(String str) {
    // Create a hash table to mark the characters present in the string
    // By default all the elements of mark would be false.
    boolean[] mark = new boolean[26];

    // For indexing in mark[]
    int index = 0;

    // Traverse all characters
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      // If uppercase character, subtract 'A' to find index.
      if ('A' <= c && c <= 'Z') {
        index = c - 'A';
      } else if ('a' <= c && c <= 'z') {
        // If lowercase character, subtract 'a' to find index.
        index = c - 'a';
      }

      // Mark current character
      mark[index] = true;
    }

    // Return false if any character is unmarked
    for (int i = 0; i <= 25; i++) {
      if (!mark[i]) {
        return false;
      }
    }

    // If all characters were present
    return true;
  }

  private static boolean isPangram(String str) {
    char[] alphabets = new char[256];
    // build the list of char arrays
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int ascii = (int) c;
      alphabets[ascii]++;
    }

    boolean charsAvailable = true;
    for (int i = 65; i < 91; i++) {
      if (alphabets[i] == 0 || alphabets[i + 32] == 0) {
        charsAvailable = false;
      }
    }
    return charsAvailable;
  }

  public static void main(String[] args) {
    String str = "The quick brown fox jump over the lazy dog";
    System.out.println(isPangram(str));
  }
}
