package arrays;

import java.util.Hashtable;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

  /**
   * If we take XOR of zero and some bit, it will return that bit
   * a XOR 0 = a
   * If we take XOR of two same bits, it will return 0
   * a XOR a =0
   * a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b
   * <p>
   * So we can XOR all bits together to find the unique number.
   *
   * @param arr
   * @return
   */
  private static int bitManipulation(int[] arr) {
    return 0;
  }

  private static int singleNum(int[] arr) {
    int singleOne = -1;
    Hashtable<Integer, Integer> singleHt = new Hashtable<>();
    for (int a : arr) {
      if (singleHt.contains(a)) {
        singleHt.put(a, singleHt.get(a) + 1);
      } else {
        singleHt.put(a, 1);
      }
    }
    // find the one with value = 1;
    if (singleHt.containsValue(1)) {
      // Iterate over each entry of map using entrySet
      for (Map.Entry<Integer, Integer> entry : singleHt.entrySet()) {
        // Check if value matches with given value
        if (entry.getValue().equals(1)) {
          // Store the key from entry to the list
          singleOne = entry.getKey();
        }
      }
    }
    return singleOne;
  }

  public static void main(String[] args) {

  }
}
