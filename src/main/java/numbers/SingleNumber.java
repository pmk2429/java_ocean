package numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

  private int singleNumber3Times(int[] A, int n) {
    int ones = 0, twos = 0, threes = 0;
    for (int i = 0; i < n; i++) {
      twos |= ones & A[i];
      ones ^= A[i];
      threes = ones & twos;
      ones &= ~threes;
      twos &= ~threes;
    }
    return ones;
  }

  /**
   * Given an array of integers, every element appears three times except for one. Find that single one.
   * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
   *
   * @param A
   * @return
   */
  public int singleNumberOn(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int x : A) {
      if (set.contains(x)) {
        set.remove(x);
      } else {
        set.add(x);
      }
    }
    return set.iterator().next();
  }

  public int singleNumber(int[] A) {
    int num = 0;
    for (int x : A) {
      num ^= x;
    }
    return num;
  }

  public static void main(String[] args) {

  }
}
