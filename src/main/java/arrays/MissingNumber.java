package arrays;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Find Missing Number(s)
 *
 * - WAP to find one missing number in an array
 * - WAP to find more than one missing numbers in continuous array of sorted numbers
 * - WAP to find missing numbers from an array of duplicates
 */
public class MissingNumber {

  // missing number in an unsorted array
  private static int findMissing(int[] arr, int totalCount) {
    Arrays.sort(arr);
    int nSum = totalCount * (totalCount + 1) / 2;
    int actualSum = 0;
    for (int num : arr) {
      actualSum += num;
    }

    return nSum - actualSum;
  }

  // missing number using BitSet
  private static void findMultipleMissing(int[] arr, int count) {
    int missingCount = count - arr.length;
    BitSet bitSet = new BitSet(count);

    for (int i : arr) {
      bitSet.set(i - 1);
    }

    int lastMissingIndex = 0;
    for (int i = 0; i < missingCount; i++) {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex);
    }
  }

  private static void findMissingFromDuplicates(int[] arr) {
    int[] register = new int[arr.length];

    for (int i : arr) {
      register[i] = 1;
    }

    for (int i = 1; i < register.length; i++) {
      if (register[i] == 0) {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) {
    int a[] = new int[]{1,2,3,4,6,7,8,9,10};
    System.out.println("Missing # in an array:");
    System.out.println(findMissing(a, 10));

    int b[] = new int[]{1,2,3,4,6,7,9,10};
    System.out.println("\nAll missing #s in an array:");
    findMultipleMissing(b, 10);

    int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };
    System.out.println("\nMissing #s in an array of duplicates:");
    findMissingFromDuplicates(input);
  }
}
