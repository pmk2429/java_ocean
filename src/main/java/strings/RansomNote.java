package strings;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters
 * from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * ----------
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * <p>
 * Example 2:
 * ----------
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * <p>
 * Example 3:
 * ----------
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * Constraints:
 * ------------
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {

    private static boolean canConstruct(String ransomNote, String magazine) {
        // For each character, c,  in the ransom note.
        for (char c : ransomNote.toCharArray()) {
            // Find the index of the first occurrence of c in the magazine.
            int index = magazine.indexOf(c);
            // If there are none of c left in the String, return False.
            if (index == -1) {
                return false;
            }
            // Use substring to make a new string with the characters
            // before "index" (but not including), and the characters
            // after "index".
            magazine = magazine.substring(0, index) + magazine.substring(index + 1);
        }
        // If we got this far, we can successfully build the note.
        return true;
    }

    private static boolean canConstruct2(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            int value = map[c - 'a'];

            // if the character is not present in magazine, can't construct.
            if (value <= 0) {
                return false;
            }
            map[c - 'a']--;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct2("aa", "ab"));
        System.out.println(canConstruct2("aa", "aab"));
    }

}
