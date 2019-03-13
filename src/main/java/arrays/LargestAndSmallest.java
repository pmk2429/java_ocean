package arrays;

/**
 * WAP to find largest and smallest number in unsorted array.
 */
public class LargestAndSmallest {

  private static void findLargestAndSmallest(int[] arr) {
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;

    for (int num : arr) {
      if (num > largest) {
        largest = num;
      } else if (num < smallest) {
        smallest = num;
      }
    }

    System.out.println("Largest: " + largest);
    System.out.println("Smallest: " + smallest);
  }

  public static void main(String[] args) {
    findLargestAndSmallest(new int[]{-20, 34, 21, -87, 92, 111});
  }
}
