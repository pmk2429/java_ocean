package arrays;

/**
 * Program to find the Hidden Number
 * Given an array of n integers, The task is to find another integer x such that, if all the elements of the array
 * are subtracted individually from the number x, then the sum of all the differences should add to 0.
 * If any such integer exists, print the value of x, else print -1.
 * <p>
 * Example
 * -------
 * Input: arr[] = {1, 2, 3}
 * Output: 2
 * <p>
 * Explanation:
 * Subtracting all the elements of arrays from 2, The sum of difference is:
 * 1 + 0 + (-1) = 0.
 */
public class HiddenNumber {

  private static int hiddenNumber(int[] arr) {
    int hiddenNumber = -1;
    int x = 2;
    int sum = 0;
    for (int value : arr) {
      sum += x - value;
    }
    return sum == 0 ? sum : hiddenNumber;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    System.out.println(hiddenNumber(arr));
  }
}
