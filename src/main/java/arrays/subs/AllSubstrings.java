package arrays.subs;

import java.util.*;

/**
 * Created by Pavitra on 11/12/2015.
 */
public class AllSubstrings {

    private static void allUniqueSubstrings() {
        String str = "catsandog";
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() - i; j++) {
                String sub = str.substring(i, i + j);
                System.out.println(sub);
            }
        }
    }

    public static void allSubstrings() {
        String sub;
        String str = "catsandog";
        int i, c, length = str.length();

        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                if (i >= 2) {
                    sub = str.substring(c, c + i);
                    System.out.println(sub);
                }
            }
        }
    }

    private static int lengthOfLongestContinuousSubstring(String s) {
        int j = 0, res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(j) + i - j) {
                j = i;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /**
     * Returns longest unique and continuous substring.
     */
    private static String longestUniqueSubstring(String str) {
        int maxLen = 0;
        String longestSubstring = "";

        for (int i = 0; i < str.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            StringBuilder currSub = new StringBuilder();

            for (int j = i; j < str.length(); j++) {
                char currChar = str.charAt(j);
                if (!charSet.contains(currChar)) {
                    charSet.add(currChar);
                    currSub.append(currChar);
                }
                else {
                    break;
                }
            }

            if (currSub.length() > maxLen) {
                maxLen = currSub.length();
                longestSubstring = currSub.toString();
            }
        }
        return longestSubstring;
    }

    private static String longestUniqueSubstringUsingString(String str) {
        int maxLen = 0;
        String longestSubstring = "";

        for (int i = 0; i < str.length(); i++) {
            String currSub = "";
            for (int j = i; j < str.length(); j++) {
                char currChar = str.charAt(j);
                if (!currSub.contains(String.valueOf(currChar))) {
                    currSub += currChar;
                }
                else {
                    break;
                }
            }

            if (currSub.length() > maxLen) {
                maxLen = currSub.length();
                longestSubstring = currSub;
            }
        }
        return longestSubstring;
    }

    private static String longestUniqueSubstring2(String str) {
        Map<Character, Integer> visited = new HashMap<>();
        String longestUniqueSubstring = "";
        for (int i = 0, j = 0; j < str.length(); j++) {
            char currChar = str.charAt(j);
            if (visited.containsKey(currChar)) {
                i = Math.max(i, visited.get(currChar) + 1);
            }
            if (longestUniqueSubstring.length() < j - i + 1) {
                longestUniqueSubstring = str.substring(i, j + 1);
            }
            visited.put(currChar, j);
        }
        return longestUniqueSubstring;
    }

    /**
     * Sliding Window Problem
     */
    private static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // map to store the character and its latest index encountered
        Map<Character, Integer> map = new HashMap<>();
        int longestUniqueSubstringLength = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                // update j to right next to `currChar` previous index + 1
                // this will update the window size for deducing max further down below
                j = Math.max(j, map.get(currChar) + 1);
            }
            map.put(currChar, i);
            // deduce the window size which is the length of max substring
            longestUniqueSubstringLength = Math.max(longestUniqueSubstringLength, i - j + 1);
        }
        return longestUniqueSubstringLength;
    }

    /**
     * ~!@#HARD:REVISE
     */
    private static int lengthOfLongestSubstringUsingArray(String s) {
        int result = 0;
        int[] charFreq = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            j = (charFreq[curr] > 0) ? Math.max(j, charFreq[curr]) : j;
            charFreq[curr] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    /**
     * ~!@#HARD:REVISE
     */
    private static int lengthOfLongestSubstringLinkedList(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    private static int longestSubstringUniqueLength(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("------ All Substrings --------");
        allSubstrings();
        System.out.println("------ All Unique Substrings --------");
        allUniqueSubstrings();
        System.out.println("------ Longest Unique Substring --------");
        System.out.println(longestUniqueSubstring("abcdefabcedasnabdba"));

        // Length Problems
        System.out.println(lengthOfLongestUniqueSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringLinkedList("abcabcbb"));
        System.out.println("abcdefabcedasnabdba -> " + lengthOfLongestSubstringLinkedList("abcdefabcedasnabdba"));
        System.out.println(lengthOfLongestUniqueSubstring("bbbbb"));
        System.out.println(lengthOfLongestUniqueSubstring("pwwkew"));
        String str = "pavitra";
        System.out.println(longestSubstringUniqueLength(str));
    }
}
