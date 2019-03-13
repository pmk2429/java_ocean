package numbers;

/**
 * WAP to check if input is an integer or a string.
 */
public class IntegerOrString {

  private static void isNumber(String input) {
    boolean isDigit = false;
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        isDigit = true;
      } else {
        isDigit = false;
        break;
      }
    }
    System.out.println(isDigit);
  }

  public static void main(String[] args) {
    String ip1 = "127";
    isNumber(ip1);
    String ip2 = "24.29";
    isNumber(ip2);
    String ip3 = "6LOL917";
    isNumber(ip3);
  }
}
