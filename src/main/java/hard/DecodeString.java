package hard;

import strings.HanaStringUtils;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * ---------
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * ~!@#HARD:REVISE
 */
public class DecodeString {
    private static String decodeString(String s) {
        if (HanaStringUtils.isNullOrEmpty(s)) {
            return "";
        }

        int n = s.length();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if (c == '[') {
                countStack.push(num);
                wordStack.push("");
                num = 0;
            }
            else if (c == ']') {
                int iterations = countStack.pop();
                String poppedChar = wordStack.pop();
                StringBuilder next = new StringBuilder();
                while (iterations-- > 0) {
                    next.append(poppedChar);
                }
                if (!wordStack.isEmpty()) {
                    wordStack.push(wordStack.pop() + next);
                }
                else {
                    wordStack.push(next.toString());
                }
            }
            else {
                if (!wordStack.isEmpty()) {
                    wordStack.push(wordStack.pop() + c);
                }
                else {
                    wordStack.push("" + c);
                }
            }
        }

        return wordStack.peek();
    }

    public static void main(String[] args) {
        System.out.println("3[ac]" + " --> " + decodeString("3[ac]"));
        System.out.println("3[a]2[bc]" + " --> " + decodeString("3[a]2[bc]"));
        System.out.println("3[a2[c]]" + " --> " + decodeString("3[a2[c]]"));
        System.out.println("2[abc]3[cd]ef" + " --> " + decodeString("2[abc]3[cd]ef"));
    }
}

