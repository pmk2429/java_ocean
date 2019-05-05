package numbers;

/**
 * Check if a number can be expressed as x^y (x raised to power y)
 * Given a positive integer n, find if it can be expressed as xy where y > 1 and x > 0. x and y both are integers.
 * Examples :
 * <p>
 * Input:  n = 8
 * Output: true
 * 8 can be expressed as 23
 * <p>
 * Input:  n = 49
 * Output: true
 * 49 can be expressed as 72
 * <p>
 * Input:  n = 48
 * Output: false
 * 48 can't be expressed as xy
 */
public class PowerOfX {
  // Returns true if n can be written as x^y
  static boolean isPower(int n) {
    for (int x = 2; x <= Math.sqrt(n); x++) {
      int y = 2;

      double p = Math.pow(x, y);

      while (p <= n && p > 0) {
        if (p == n)
          return true;
        y++;
        p = Math.pow(x, y);
      }
    }
    return false;
  }

  // Driver function
  public static void main(String[] args) {
    for (int i = 2; i < 100; i++)
      if (isPower(i))
        System.out.print(i + " ");
  }
}
