package numbers;

public class Palindrome {

  /**
   * 1 - Reverse the numbe
   * 2 - Compare
   *
   * @param x
   * @return
   */
  private static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int reverse = 0;
    while (x != 0) {
      if (Math.abs(reverse) > Integer.MAX_VALUE / 10) {
        return false;
      }
      reverse = reverse * 10 + x % 10;
      x /= 10;
    }
    if (reverse == x) {
      return true;
    }
    return false;
  }

  private static boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }
    int div = 1;
    while (x / div >= 10) {
      div *= 10;
    }
    while (x != 0) {
      int l = x / div;
      int r = x % 10;
      if (l != r) return false;
      x = (x % div) / 10;
      div /= 100;
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
