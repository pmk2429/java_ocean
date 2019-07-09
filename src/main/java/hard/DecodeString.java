package hard;

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
 */
public class DecodeString {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    int n = s.length();
    Stack<Integer> countStack = new Stack<>();
    Stack<String> charStack = new Stack<>();
    int num = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      } else if (c == '[') {
        countStack.push(num);
        charStack.push("");
        num = 0;
      } else if (c == ']') {
        int iter = countStack.pop();
        String poppedChar = charStack.pop();
        StringBuilder next = new StringBuilder();
        while (iter-- > 0) {
          next.append(poppedChar);
        }
        if (!charStack.isEmpty()) {
          charStack.push(charStack.pop() + next.toString());
        } else {
          charStack.push(next.toString());
        }
      } else {
        if (!charStack.isEmpty()) {
          charStack.push(charStack.pop() + c);
        } else {
          charStack.push("" + c);
        }
      }
    }

    return charStack.peek();
  }
}

