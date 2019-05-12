package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexOrSubString {

  private static void getIndex(String encodedMessage) {
    Pattern pattern = Pattern.compile("<(.*?)>");
    Matcher matcher = pattern.matcher(encodedMessage);
    while (matcher.find()) {
      System.out.println(matcher.group(1));
    }
  }

  public static void main(String[] args) {
    String str = "Hello, how are you <@Pavitra Kansara>? Let's plan a trip together at <^Yellowstone NP.pdf> and in " +
        "parallel, create a task <%trip_planing> to keep track of the progress.";
    getIndex(str);
  }
}
