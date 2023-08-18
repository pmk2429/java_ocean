package strings;

import java.util.*;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "bcabc"
 * Output: "abc"
 * <p>
 * Example 2:
 * ----------
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * <p>
 * Constraints:
 * ------------
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 * <p>
 * ~!@#HARD:REVISE
 */
public class RemoveDuplicateAndSortLexicographically {

    /**
     * For String `cbacdcbc` this method will return `abcd`
     */
    private static String removeDuplicatesPQ(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        Queue<Character> pq = new PriorityQueue<>((c1, c2) -> c1.compareTo(c2));

        for (char c : charMap.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        return sb.toString();
    }

    /**
     * For string `cbacdcbc` this method will return `acdb`
     */
    private static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        // this lets us keep track of what's in our solution in O(1) time
        Set<Character> seen = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        Map<Character, Integer> charsIndexMap = new HashMap<>();

        // this map will store the last occurrence of the character in the string with it's corresponding index.
        for (int i = 0; i < s.length(); i++) {
            charsIndexMap.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!seen.contains(c)) {
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                // here, the charsIndexMap.get(stack.peek()) will fetch the latest occurrence of the char in Map
                while (!stack.isEmpty() && c < stack.peek() && charsIndexMap.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Remove duplicates `bcabc` -> " + removeDuplicateLetters("bcabc"));
        System.out.println("Remove duplicates `cbacdcbc` -> " + removeDuplicateLetters("cbacdcbc"));
        System.out.println("Remove duplicates `cbacdcbc` -> " + removeDuplicatesPQ("cbacdcbc"));
    }
}
