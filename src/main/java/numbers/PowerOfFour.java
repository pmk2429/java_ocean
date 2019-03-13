package numbers;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class PowerOfFour {
  private static boolean isPowerOfFour(int n) {
    // eliminate all odd numbers

    if (n == 1) {
      return true;
    }
    if (n % 4 != 0) {
      return false;
    }

    boolean check = false;
    if (n % 10 == 6 || n % 10 == 4) {
      if (n % 4 == 0) {
        for (int powerNum = 4; powerNum <= n; powerNum = powerNum * 4) {
          if (powerNum == n) {
            check = true;
            break;
          }
        }
      }
    }
    return check;
  }

  public static void main(String[] args) {
    System.out.println(isPowerOfFour(16));
  }
}
