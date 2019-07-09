package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Custom Encoder Decoder
 */
public class Codec {

  private List<String> decode(String s) {
    List<String> resList = new ArrayList<>();
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      StringBuilder resBuilder = new StringBuilder();
      if (s.charAt(right) == '|') {
        int length = Integer.valueOf(s.substring(left, right));
        int currEndIndex = right + 1 + length; // end index of current encoded word
        resBuilder.append(s, right + 1, currEndIndex);
        resList.add(resBuilder.reverse().toString());
        left = currEndIndex;
        right = left;
      }
      right++;
    }
    return resList;
  }

  private String encode(List<String> strs) {
    StringBuilder cods = new StringBuilder();
    for (String st : strs) {
      StringBuilder encodedStr = new StringBuilder();
      encodedStr.append(st);
      // length of encodedStr + | + reverse of encodedStr
      // for eg: encode(pavitra) -> "7|artivap"
      cods.append(encodedStr.length()).append("|").append(encodedStr.reverse().toString());
    }
    return cods.toString();
  }

  public static void main(String[] args) {
    Codec codec = new Codec();
    String encoded = codec.encode(new ArrayList<String>(Arrays.asList("Pavitra")));
    System.out.println(encoded);
    System.out.println(codec.decode(encoded));
  }
}
