package numbers;

import java.util.Random;

public class FindKthSmallest {

  private static int kthSmallestUsingHeap(int[] a, int i) {
    return 0;
  }

  private static int findKthSmallestQuickSort(int[] nums, int i) {
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = new int[5];
    Random random = new Random();
    System.out.println("Numbers: ");
    for (int i = 0; i < nums.length; i++) {
      nums[i] = random.nextInt(10);
      System.out.print(nums[i] + " ");
    }
    System.out.println();
    System.out.println("\n3th largest value in array is: " + findKthSmallestQuickSort(nums, 3));

    System.out.println("\nAfter finding kth element: ");
    for (int num : nums) {
      System.out.print(num + " ");
    }

    System.out.println("\n\n");
    int[] a = {5, 4, 1, 8, 5, 7, 9};
    System.out.println("# " + kthSmallestUsingHeap(a, 3));

  }
}
