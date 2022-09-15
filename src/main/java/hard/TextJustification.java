package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be
 * assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word'addStr length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * <p>
 * Example 2:
 * ----------
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * <p>
 * Example 3:
 * ----------
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 *
 * ~!@#HARD:REVISE
 */
public class TextJustification {

    private static String getSpaceStr(int count) {
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) sb.append(" ");
        return sb.toString();
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return null;
        }

        if (maxWidth <= 0) {
            return null;
        }

        List<String> res = new ArrayList<>();

        int start = 0; // inclusive

        while (start < words.length) {
            int currWordLength = words[start].length();
            int end = start + 1; // exclusive
            while (end < words.length) {
                int nextWordLength = words[end].length();
                if (currWordLength + 1 + nextWordLength > maxWidth) break;
                currWordLength += 1 + nextWordLength;
                end++;
            }

            // build the line
            StringBuilder sb = new StringBuilder(words[start++]);
            if (end == words.length) { // left justify with single " "
                while (start < end) {
                    sb.append(" ").append(words[start++]);
                }
            }
            else {
                // spread out evenly
                int wordCount = end > start ? end - start : 1;
                int extra = (maxWidth - currWordLength) % wordCount;
                String evenly = getSpaceStr((maxWidth - currWordLength) / wordCount);
                while (start < end) {
                    sb.append(" ")
                        .append(evenly)
                        .append(extra-- > 0 ? " " : "")
                        .append(words[start++]);
                }
            }

            int lineLen = sb.length();

            // add extra padding
            while (lineLen++ < maxWidth) {
                sb.append(" ");
            }

            res.add(sb.toString());

            // set the pointer
            start = end;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words1 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth1 = 16;
        System.out.println(fullJustify(words1, maxWidth1));
        String[] words2 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth2 = 16;
        System.out.println(fullJustify(words2, maxWidth2));
    }
}
