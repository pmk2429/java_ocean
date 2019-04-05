package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {

  private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

  private static boolean validate(String emailStr) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
    return matcher.find();
  }

  public static void main(String[] args) {
    String pmkEmail = "pmk.2429@gmail.com";
    System.out.println(validate(pmkEmail));
  }
}