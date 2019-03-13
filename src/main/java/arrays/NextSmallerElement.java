package arrays;

import java.util.Arrays;

/**
 * Next Smaller Element
 * Given an array, print the Next Smaller Element (NSE) for every element.
 * The Smaller smaller Element for an element x is the first smaller element on the right side of x in array.
 * Elements for which no smaller element exist (on right side), consider next smaller element as -1.
 * <p>
 * Examples:
 * a) For any array, rightmost element always has next smaller element as -1.
 * b) For an array which is sorted in increasing order, all elements have next smaller element as -1.
 * c) For the input array [4, 8, 5, 2, 25}, the next smaller elements for each element are as follows.
 * ------------------
 * Element     NSE
 * 4      -->   2
 * 8      -->   5
 * 5      -->   2
 * 2      -->   -1
 * 25     -->   -1
 * d) For the input array [13, 7, 6, 12}, the next smaller elements for each element are as follows.
 * -------------------
 * Element       NSE
 * 13      -->    7
 * 7       -->    6
 * 6       -->    -1
 * 12      -->     -1
 */
public class NextSmallerElement {

  private static void nextSmallerElement(int[] arr) {
    int j;
    int length = arr.length;
    int lastIndex = length - 1;
    int[] nse = new int[arr.length];
    for (int i = 0; i < length; i++) {
      if (i == lastIndex) {
        nse[i] = -1;
      }
      j = i + 1;
      if (j < length) {
        if (arr[i] > arr[j]) {
          nse[i] = arr[j];
        } else {
          while (j < length - 1 && arr[i] < arr[j]) {
            j++;
          }
          nse[i] = (j == lastIndex) ? -1 : arr[j];
        }
      }
    }
    System.out.println(Arrays.toString(nse));
  }

  public static void main(String[] args) {
    int[] arr = {4, 8, 5, 2, 25};
    int[] arr1 = {13, 7, 6, 12};
    nextSmallerElement(arr);
    nextSmallerElement(arr1);
  }
}
