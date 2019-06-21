package assignment;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class SimpleStatistics {

  public static double[] getUserInput() {
    Scanner in = new Scanner(System.in);
    int size = 0;
    System.out.println("Enter the size (must be digit): ");
    while (!in.hasNextInt()) {
      in.next();
    }
    size = in.nextInt();
    System.out.println(size);
    double[] arrDouble = new double[size];
    in = new Scanner(System.in);
    System.out.println("Enter the double values:");
    for (int i = 0; i < size; i++) {
      if (in.hasNextDouble()) {
        double inputValue = in.nextDouble();
        arrDouble[i] = inputValue;
      }
    }

    return arrDouble;
  }

  public static double arithmeticMean(double[] nums) {
    double sum = 0.0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      sum += nums[i];
    }
    return (sum / size);
  }

  public static double geometricMean(double[] nums) {
    int size = nums.length;
    double product = 1.0;
    for (int i = 0; i < nums.length; i++) {
      product = product * nums[i];
    }

    double geoMean = Math.pow(product, 1.0 / size);

    return geoMean;
  }

  public static double[] minAndmax(double[] nums) {
    Arrays.sort(nums);
    double[] minAndMax = new double[2];
    minAndMax[0] = nums[0];
    minAndMax[1] = nums[nums.length - 1];

    return minAndMax;
  }

  public static double[] scaleUp(double[] nums, double factor) {
    if (factor >= 1.0) {
      for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[i] * factor;
      }
    }
    return nums;
  }

  public static double[] scaleDown(double[] nums, double factor) {
    if (factor >= 1.0) {
      for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[i] / factor;
      }
    }
    return nums;
  }

  public static void main(String[] args) {

    double[] arrayInput = SimpleStatistics.getUserInput();
    System.out.println("Enter your choice (value 1-6): ");
    System.out.println("Option 1 - arithmeticMean\n" +
        "Option 2 - geometricMean\n" +
        "Option 3 - minAndmax\n" +
        "Option 4 - scaleUp\n" +
        "Option 5 - scaleDown\n" +
        "Option 6 - Exit");
    Scanner in = new Scanner(System.in);
    for (; ; ) {
      while (!in.hasNextInt()) {
        in.next();
      }
      int choice = in.nextInt();
      if (choice >= 1 && choice <= 6) {
        switch (choice) {
          case 1:
            System.out.println(SimpleStatistics.arithmeticMean(arrayInput));
            break;
          case 2:
            System.out.println(SimpleStatistics.geometricMean(arrayInput));
            break;
          case 3:
            double[] minAndMax = SimpleStatistics.minAndmax(arrayInput);
            System.out.println("Min: " + minAndMax[0]);
            System.out.println("Max: " + minAndMax[1]);
            break;
          case 4:
            System.out.println(SimpleStatistics.scaleUp(arrayInput, 2.0));
            break;
          case 5:
            System.out.println(SimpleStatistics.scaleDown(arrayInput, 2.0));
            break;
          case 6:
            System.out.println("Exiting the console...");
            System.exit(0);
        }
      } else {
        System.out.println("Enter value again");
      }
    }

  }

}
