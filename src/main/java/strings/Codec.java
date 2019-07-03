package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Encoder Decoder
 */
public class Codec {

  public List<String> decode(String s) {
    List<String> resList = new ArrayList<>();
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      StringBuilder resBuilder = new StringBuilder();
      if (s.charAt(right) == '|') {
        int length = Integer.valueOf(s.substring(left, right));
        resBuilder.append(s, right + 1, right + 1 + length);
        resList.add(resBuilder.reverse().toString());
        left = right + 1 + length;
        right = left;
      }
      right++;
    }
    return resList;
  }

  public String encode(List<String> strs) {
    StringBuilder cods = new StringBuilder();
    for (String st : strs) {
      StringBuilder reverseStr = new StringBuilder();
      reverseStr.append(st);
      cods.append(reverseStr.length()).append("|").append(reverseStr.reverse().toString());
    }
    return cods.toString();
  }

  public static void main(String[] args) {
    Codec codec = new Codec();
  }
}
