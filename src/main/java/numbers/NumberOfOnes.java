package numbers;

/**
 * given n find the total number of ones in the binary representation of
 * numbers 1,2,3,...,n
 * <p>
 * For example, if n=5
 * <p>
 * 1=1 (number of ones=1)
 * 2=10 (number of ones=1)
 * 3=11 (number of ones=2)
 * 4=100 (number of ones=1)
 * 5=101 (number of ones=2)
 * <p>
 * output
 * 7 (1+1+2+1+2)
 */

public class NumberOfOnes {

  private static int getNumberOfOnes(int num) {
    int p = 1, cnt = 0;

    if ((num & 1) != 0) {
      cnt++;
    }

    while (1 << (p - 1) < num) {
      if ((num & (1 << p)) != 0) {
        cnt += (1 << (p - 1)) * (p) + num % (1 << p) + 1;
      }
      p++;
    }
    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(getNumberOfOnes(2));
  }
}
