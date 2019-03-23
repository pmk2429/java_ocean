package numbers;

public class SecondLargest {
  public static void main(String[] args) {
    int[] list = {15, 25, 84, 14, 5, 99, 105, 24, 150};
    int[] nums = {3, 2, 1};
    int thirdBig = Integer.MIN_VALUE;
    int secondBig = Integer.MIN_VALUE;
    int big = Integer.MIN_VALUE;
    for (int n : nums) {
      if (big < n) {
        thirdBig = secondBig;
        secondBig = big;
        big = n;
      } else if (secondBig < n) {
        thirdBig = secondBig;
        secondBig = n;
      } else if (thirdBig < n) {
        thirdBig = n;
      }
    }
    System.out.println("Largest in Array - " + big);
    System.out.println("Second Largest in Array - " + secondBig);
    System.out.println("Third Largest in Array - " + thirdBig);
  }
}
